package com.mis.route.e_commerce.domain.usecases.brands_usecase

import com.mis.route.e_commerce.data.models.brand.Brand
import com.mis.route.e_commerce.domain.repoistory.brand_repository.BrandsRepository
import javax.inject.Inject

class BrandUseCase @Inject constructor(
    private val brandRepository: BrandsRepository
) {
    suspend fun execute(): List<Brand?>? {
        return brandRepository.getAllBrands()
    }

}