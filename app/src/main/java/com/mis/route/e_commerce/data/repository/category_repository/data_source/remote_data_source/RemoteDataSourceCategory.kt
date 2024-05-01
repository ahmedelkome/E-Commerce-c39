package com.mis.route.e_commerce.data.repository.category_repository.data_source.remote_data_source

import com.mis.route.e_commerce.data.models.category.Category

interface RemoteDataSourceCategory {
    suspend fun getAllCategory(): List<Category?>?
}