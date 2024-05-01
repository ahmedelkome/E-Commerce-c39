package com.mis.route.e_commerce.domain.usecases.categoryusecase

import com.mis.route.e_commerce.data.models.category.Category
import com.mis.route.e_commerce.domain.repoistory.categoty_repository.CategoryRepository
import javax.inject.Inject

class CategoryUseCase @Inject constructor(
    private val categoryRepository: CategoryRepository
) {

    suspend fun execute(): List<Category?>? {
        return categoryRepository.getAllCategory()
    }
}