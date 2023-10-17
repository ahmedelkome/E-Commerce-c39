package com.mis.route.e_commerce.data.source

import com.mis.route.e_commerce.data.api.WebServices
import com.mis.route.e_commerce.data.models.category.Category
import com.mis.route.e_commerce.data.models.product.Product
import com.mis.route.e_commerce.data.models.subcategory.SubCategory

class OnlineDataSourceImpl(
    private val webServices: WebServices
) : OnlineDataSourceContract {
    override suspend fun getCategories(): List<Category?>? {
        val response = webServices.getCategories()
        return response.data
    }

    override suspend fun getSubCategory(subCategoryId: String): SubCategory? {
        val response = webServices.getSubCategory(subCategoryId)
        return response.data?.get(0)
    }

    override suspend fun getProducts(subCategoryId: String): List<Product?>? {
        val response = webServices.getProducts(subCategoryId)
        return response.data
    }
}