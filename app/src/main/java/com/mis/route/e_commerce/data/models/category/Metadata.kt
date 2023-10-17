package com.mis.route.e_commerce.data.models.category

import com.google.gson.annotations.SerializedName

data class Metadata(
    @field:SerializedName("currentPage")
    val currentPage: Int? = null,

    @field:SerializedName("numberOfPages")
    val numberOfPages: Int? = null,

    @field:SerializedName("limit")
    val limit: Int? = null
)