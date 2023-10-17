package com.mis.route.e_commerce.data.repository

import com.mis.route.e_commerce.data.models.category.Category
import com.mis.route.e_commerce.data.models.product.Product
import com.mis.route.e_commerce.data.models.subcategory.SubCategory

interface DataRepositoryContract {
    suspend fun getCategories(): List<Category?>?
    suspend fun getSubCategory(subCategoryId: String): SubCategory?
    suspend fun getProducts(subCategoryId: String): List<Product?>?
}