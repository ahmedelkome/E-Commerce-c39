package com.mis.route.e_commerce.data.repository.auth_repository

import com.mis.route.e_commerce.data.repository.AuthRepositoryImpl
import com.mis.route.e_commerce.data.repository.auth_repository.data_sources.remote_datasource.RemoteDataSource
import com.mis.route.e_commerce.data.repository.auth_repository.data_sources.remote_datasource.RemoteDataSourceImpl
import com.mis.route.e_commerce.domain.repoistory.auth_repository.AuthRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DI {

    @Binds
    abstract fun provideAuthRepo(authRepositoryImpl: AuthRepositoryImpl): AuthRepository
}