package com.mis.route.e_commerce.data.repository.brand_repository.data_sources.remote_data_sources

import com.mis.route.e_commerce.data.models.brand.Brand

interface RemoteDataSourceBrands {
    suspend fun getAllBrands():List<Brand?>?
}