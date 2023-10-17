package com.mis.route.e_commerce.di

import com.mis.route.e_commerce.data.repository.DataRepositoryContract
import com.mis.route.e_commerce.data.repository.DataRepositoryImpl
import com.mis.route.e_commerce.data.source.OnlineDataSourceContract
import com.mis.route.e_commerce.data.source.OnlineDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DataRepositoryModule {
    @Binds
    abstract fun bindOnlineDataSource(onlineDataSourceImpl: OnlineDataSourceImpl): OnlineDataSourceContract

    @Binds
    abstract fun bindDataRepository(dataRepositoryImpl: DataRepositoryImpl): DataRepositoryContract
}