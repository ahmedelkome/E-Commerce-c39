package com.mis.route.e_commerce.data.models.brand

import com.google.gson.annotations.SerializedName

data class BrandResponse(

	@field:SerializedName("metadata")
	val metadata: Metadata? = null,

	@field:SerializedName("data")
	val data: List<Brand?>? = null,

	@field:SerializedName("results")
	val results: Int? = null
)