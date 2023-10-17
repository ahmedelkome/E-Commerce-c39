package com.mis.route.e_commerce.data.models.category

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @field:SerializedName("results")
    val results: Int? = null,

    @field:SerializedName("metadata")
    val metadata: Metadata? = null,

    @field:SerializedName("data")
    val data: List<Category?>? = null,
)

