package com.mis.route.e_commerce.data.api

import com.mis.route.e_commerce.data.models.auth.AuthResponse
import com.mis.route.e_commerce.data.models.auth.LoginRequest
import com.mis.route.e_commerce.data.models.category.CategoryResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface WebServices {
    @POST("/api/v1/auth/signin")
    suspend fun login(
        @Body loginRequest: LoginRequest,
    ): AuthResponse

    @GET("/api/v1/categories")
    suspend fun getAllCategory(): CategoryResponse
}