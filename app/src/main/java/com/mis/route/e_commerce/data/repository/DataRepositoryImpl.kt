package com.mis.route.e_commerce.data.repository

import com.mis.route.e_commerce.data.models.category.Category
import com.mis.route.e_commerce.data.models.product.Product
import com.mis.route.e_commerce.data.models.subcategory.SubCategory
import com.mis.route.e_commerce.data.source.OnlineDataSourceContract

class DataRepositoryImpl(
    private val onlineDataSource: OnlineDataSourceContract
) : DataRepositoryContract {
    override suspend fun getCategories(): List<Category?>? {
        return onlineDataSource.getCategories()
    }

    override suspend fun getSubCategory(subCategoryId: String): SubCategory? {
        return onlineDataSource.getSubCategory(subCategoryId)
    }

    override suspend fun getProducts(subCategoryId: String): List<Product?>? {
        return onlineDataSource.getProducts(subCategoryId)
    }
}