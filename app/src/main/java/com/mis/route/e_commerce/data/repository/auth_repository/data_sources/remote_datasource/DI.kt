package com.mis.route.e_commerce.data.repository.auth_repository.data_sources.remote_datasource

import com.mis.route.e_commerce.data.repository.AuthRepositoryImpl
import com.mis.route.e_commerce.domain.repoistory.auth_repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DI {
    @Binds
    abstract fun provideRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl)
            : RemoteDataSource
}