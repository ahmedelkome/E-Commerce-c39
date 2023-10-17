package com.mis.route.e_commerce.data.models.product

import com.google.gson.annotations.SerializedName

data class ProductsResponse(
	@field:SerializedName("results")
	val results: Int? = null,

	@field:SerializedName("metadata")
	val metadata: Metadata? = null,

	@field:SerializedName("data")
	val data: List<Product?>? = null
)