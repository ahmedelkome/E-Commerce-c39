package com.mis.route.e_commerce.domain.repoistory.categoty_repository

import com.mis.route.e_commerce.data.models.category.Category

interface CategoryRepository {
    suspend fun getAllCategory(): List<Category?>?
}