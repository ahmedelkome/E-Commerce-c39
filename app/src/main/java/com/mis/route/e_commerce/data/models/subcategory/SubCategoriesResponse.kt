package com.mis.route.e_commerce.data.models.subcategory

import com.google.gson.annotations.SerializedName

data class SubCategoriesResponse(
	@field:SerializedName("results")
	val results: Int? = null,

	@field:SerializedName("metadata")
	val metadata: Metadata? = null,

	@field:SerializedName("data")
	val data: List<SubCategory?>? = null,
)