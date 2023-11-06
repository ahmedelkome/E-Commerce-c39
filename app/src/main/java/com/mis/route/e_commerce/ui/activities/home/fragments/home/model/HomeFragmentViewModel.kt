package com.mis.route.e_commerce.ui.activities.home.fragments.home.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mis.route.domain.models.offer.Offer
import com.mis.route.domain.usecases.GetCategoriesUseCase
import com.mis.route.domain.usecases.GetProductsUseCase
import com.mis.route.e_commerce.R
import com.mis.route.e_commerce.ui.activities.home.fragments.home.contract.HomeContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    // TODO: how can Hilt provide this?
    private val getCategoriesUseCase: GetCategoriesUseCase,
//    private val getSubCategoryUseCase: GetSubCategoryUseCase,
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel(), HomeContract.ViewModel {
    private val _states = MutableLiveData<HomeContract.State>()
    override val states: LiveData<HomeContract.State> get() = _states

    private val _events = MutableLiveData<HomeContract.Event>()
    override val events: LiveData<HomeContract.Event> get() = _events

    override fun invokeAction(action: HomeContract.Action) {
        when (action) {
            is HomeContract.Action.GetCategories -> getCategories()
            is HomeContract.Action.GetProducts -> getProducts(action.subCategoryId)
            is HomeContract.Action.GetSubCategory -> TODO()
            is HomeContract.Action.GetOffers -> getOffers()
        }
    }

    private fun getCategories() {
        viewModelScope.launch {
            try {
                val categoriesList = getCategoriesUseCase.invoke()
                _states.value = HomeContract.State.CategoriesSuccess(categoriesList)
            } catch (e: Exception) {
                _states.value = HomeContract.State.CategoriesError(
                    e.localizedMessage ?: "Get Categories Exception"
                )
            }
        }
    }

//    private fun getSubCategory(subCategoryId: String) {
//        viewModelScope.launch {
//            try {
//                val subCategory = getSubCategoryUseCase.invoke(subCategoryId)
//                _states.value = HomeContract.State.SubCategorySuccess(subCategory)
//            } catch (e: Exception) {
//                _states.value = HomeContract.State.SubCategoryError(
//                    e.localizedMessage ?: "Get SubCategory Exception"
//                )
//            }
//        }
//    }

    private fun getProducts(subCategoryId: String) {
        viewModelScope.launch {
            try {
                val productsList = getProductsUseCase.invoke(subCategoryId)
                _states.value = HomeContract.State.ProductsSuccess(productsList)
            } catch (e: Exception) {
                _states.value =
                    HomeContract.State.ProductsError(e.localizedMessage ?: "Get Products Exception")
            }
        }
    }

    // TODO: Sudo-function to generate offers until an endpoint is added to the API
    private fun getOffers() {
        try {
            val offersList = listOf(
                Offer(1, 25, R.drawable.image_headset, "1", "For all Headphones \n& AirPods"),
                Offer(2, 30, R.drawable.image_beauty_products, "2", "For all Makeup\n& Skincare"),
                Offer(3, 20, R.drawable.image_laptop, "3", "For Laptops\n& Mobiles")
            )
            _states.value = HomeContract.State.OffersSuccess(offersList)
        } catch (e: java.lang.Exception) {
            _states.value = HomeContract.State.OffersError(e.localizedMessage ?: "Get Offers Exception")
        }
    }
}