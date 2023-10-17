package com.mis.route.e_commerce.data.models.subcategory

import com.google.gson.annotations.SerializedName

data class SubCategory(
	@field:SerializedName("_id")
	val id: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("slug")
	val slug: String? = null,

	@field:SerializedName("category")
	val category: String? = null,

	@field:SerializedName("createdAt")
	val createdAt: String? = null,

	@field:SerializedName("updatedAt")
	val updatedAt: String? = null
)