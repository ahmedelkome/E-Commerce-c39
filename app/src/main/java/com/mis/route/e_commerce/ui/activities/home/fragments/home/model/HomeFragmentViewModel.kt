package com.mis.route.e_commerce.ui.activities.home.fragments.home.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mis.route.e_commerce.data.models.category.Category
import com.mis.route.e_commerce.data.models.product.Product
import com.mis.route.e_commerce.data.models.subcategory.SubCategory
import com.mis.route.e_commerce.data.repository.DataRepositoryContract
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val dataRepository: DataRepositoryContract
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
                _categoriesList.value = dataRepository.getCategories()
            } catch (e: Exception) {
                Log.e("CategoriesTag", e.localizedMessage ?: "Exception here!")
            }
        }
    }

    fun getSubCategory(subCategoryId: String) {
        viewModelScope.launch {
            try {
                _subCategory.value = dataRepository.getSubCategory(subCategoryId)
            } catch (e: Exception) {
                Log.e("SubCategoryTag", e.localizedMessage ?: "Exception here!")
            }
        }
    }

    fun getProducts(subCategoryId: String) {
        viewModelScope.launch {
            try {
                _productsList.value = dataRepository.getProducts(subCategoryId)
            } catch (e: Exception) {
                Log.e("ProductTag", e.localizedMessage ?: "Exception here!")
            }
        }
    }
}