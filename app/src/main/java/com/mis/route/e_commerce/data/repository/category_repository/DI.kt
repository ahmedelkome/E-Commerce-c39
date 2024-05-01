package com.mis.route.e_commerce.data.repository.category_repository

import com.mis.route.e_commerce.domain.repoistory.categoty_repository.CategoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DI {

    @Binds
    abstract fun getInstance(categoryRepositoryImpl: CategoryRepositoryImpl)
            : CategoryRepository
}