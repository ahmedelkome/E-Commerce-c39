package com.mis.route.e_commerce.data.repository.brand_repository.data_sources

import com.mis.route.e_commerce.data.repository.brand_repository.BrandsRepositoryImpl
import com.mis.route.e_commerce.domain.repoistory.brand_repository.BrandsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DI {
    @Binds
    abstract fun getInstance(brandsRepositoryImpl: BrandsRepositoryImpl)
    :BrandsRepository
}