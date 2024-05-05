package com.mis.route.e_commerce.data.repository.brand_repository.data_sources.remote_data_sources

import com.mis.route.e_commerce.data.api.WebServices
import com.mis.route.e_commerce.data.models.brand.Brand
import javax.inject.Inject

class RemoteDataSourceBrandsImpl @Inject constructor(
    private val webServices: WebServices
) : RemoteDataSourceBrands {
    override suspend fun getAllBrands(): List<Brand?>? {
        try {
            val response = webServices.getAllBrand()
            return response.data
        } catch (e: Exception) {
            throw e
        }
    }
}