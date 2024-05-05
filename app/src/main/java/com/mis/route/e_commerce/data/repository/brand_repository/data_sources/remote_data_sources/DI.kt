package com.mis.route.e_commerce.data.repository.brand_repository.data_sources.remote_data_sources

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DI {

    @Binds
    abstract fun getInstance(remoteDataSourceBrandsImpl: RemoteDataSourceBrandsImpl)
    :RemoteDataSourceBrands
}