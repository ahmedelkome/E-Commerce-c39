package com.mis.route.e_commerce.data.repository.category_repository.data_source.remote_data_source

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DI {

    abstract fun getInstance(remoteDataSourceCategoryImpl: RemoteDataSourceCategoryImpl)
            : RemoteDataSourceCategory
}