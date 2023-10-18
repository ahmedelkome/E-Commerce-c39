package com.mis.route.e_commerce.ui.activities.home.fragments.home.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mis.route.domain.models.category.Category
import com.mis.route.domain.models.product.Product
import com.mis.route.domain.models.subcategory.SubCategory
import com.mis.route.domain.usecases.GetCategoriesUseCase
import com.mis.route.domain.usecases.GetProductsUseCase
import com.mis.route.domain.usecases.GetSubCategoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    // TODO: how can Hilt provide this?
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getSubCategoryUseCase: GetSubCategoryUseCase,
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {
    private var _categoriesList = MutableLiveData<List<Category?>?>(null)
    val categoriesList: LiveData<List<Category?>?> get() = _categoriesList

    private var _subCategory = MutableLiveData<SubCategory?>(null)
    val subCategory: LiveData<SubCategory?> get() = _subCategory

    private var _productsList = MutableLiveData<List<Product?>?>(null)
    val productsList: LiveData<List<Product?>?> get() = _productsList


    fun getCategories() {
        viewModelScope.launch {
            try {
                _categoriesList.value = getCategoriesUseCase.invoke()
            } catch (e: Exception) {
                Log.e("CategoriesTag", e.localizedMessage ?: "Exception here!")
            }
        }
    }

    fun getSubCategory(subCategoryId: String) {
        viewModelScope.launch {
            try {
                _subCategory.value = getSubCategoryUseCase.invoke(subCategoryId)
            } catch (e: Exception) {
                Log.e("SubCategoryTag", e.localizedMessage ?: "Exception here!")
            }
        }
    }

    fun getProducts(subCategoryId: String) {
        viewModelScope.launch {
            try {
                _productsList.value = getProductsUseCase.invoke(subCategoryId)
            } catch (e: Exception) {
                Log.e("ProductTag", e.localizedMessage ?: "Exception here!")
            }
        }
    }
}