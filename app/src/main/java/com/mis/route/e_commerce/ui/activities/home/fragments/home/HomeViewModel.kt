package com.mis.route.e_commerce.ui.activities.home.fragments.home

import androidx.lifecycle.MutableLiveData
import com.mis.route.e_commerce.domain.usecases.categoryusecase.CategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.mis.route.e_commerce.domain.usecases.brands_usecase.BrandUseCase
import com.mis.route.e_commerce.ui.base.BaseViewModel
import com.mis.route.e_commerce.ui.model.ViewMessage
import kotlinx.coroutines.launch


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val categoryUseCase: CategoryUseCase,
    private val brandUseCase: BrandUseCase
) : BaseViewModel() {

    private var _state = MutableLiveData<HomeFragmentState>()
    val state get() = _state

    fun invoke(actions: HomeFragmentActions) {
        when (actions) {
            HomeFragmentActions.HomeLoadedCategory -> getAllCategories()
            HomeFragmentActions.HomeLoadedBrands -> getAllBrands()
        }
    }

    private fun getAllBrands() {
        viewModelScope.launch {
            try {
                _state.value = HomeFragmentState.BrandsLoaded(brandUseCase.execute())
            } catch (e: Exception) {
                viewMessageLiveData.value =
                    ViewMessage(title = "Error", message = e.localizedMessage)
            }
        }
    }

    private fun getAllCategories() {
        viewModelScope.launch {
            try {
                _state.value = HomeFragmentState.CategoryLoaded(categoryUseCase.execute())
            } catch (e: Exception) {
                viewMessageLiveData.value = ViewMessage(
                    title = "Error",
                    message = e.localizedMessage
                )
            }
        }
    }

}