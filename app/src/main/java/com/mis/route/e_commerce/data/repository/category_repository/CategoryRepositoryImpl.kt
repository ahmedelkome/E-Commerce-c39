package com.mis.route.e_commerce.data.repository.category_repository


import com.mis.route.e_commerce.data.models.category.Category
import com.mis.route.e_commerce.data.repository.category_repository.data_source.remote_data_source.RemoteDataSourceCategory
import com.mis.route.e_commerce.domain.repoistory.categoty_repository.CategoryRepository

import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSourceCategory
) : CategoryRepository {
    override suspend fun getAllCategory(): List<Category?>? {
        return remoteDataSource.getAllCategory()
    }


}