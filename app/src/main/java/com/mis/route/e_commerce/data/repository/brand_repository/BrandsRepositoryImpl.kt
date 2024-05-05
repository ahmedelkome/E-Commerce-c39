package com.mis.route.e_commerce.data.repository.brand_repository

import com.mis.route.e_commerce.data.models.brand.Brand
import com.mis.route.e_commerce.data.repository.brand_repository.data_sources.remote_data_sources.RemoteDataSourceBrands
import com.mis.route.e_commerce.domain.repoistory.brand_repository.BrandsRepository
import javax.inject.Inject

class BrandsRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSourceBrands
) : BrandsRepository {
    override suspend fun getAllBrands(): List<Brand?>? {
        return remoteDataSource.getAllBrands()
    }
}