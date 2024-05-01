package com.mis.route.e_commerce.data.repository.category_repository.data_source.remote_data_source

import com.mis.route.e_commerce.data.api.WebServices
import com.mis.route.e_commerce.data.models.category.Category
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val webServices: WebServices
) : RemoteDataSource {
    override suspend fun getAllCategory(): List<Category?>? {
        try {
            val response = webServices.getAllCategory()
            return response.data
        } catch (e: Exception) {
            throw e
        }
    }
}