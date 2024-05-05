package com.mis.route.e_commerce.domain.repoistory.brand_repository

import com.mis.route.e_commerce.data.models.brand.Brand

interface BrandsRepository {

    suspend fun getAllBrands(): List<Brand?>?
}