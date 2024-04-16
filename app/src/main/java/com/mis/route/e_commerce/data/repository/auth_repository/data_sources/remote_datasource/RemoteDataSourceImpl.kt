package com.mis.route.e_commerce.data.repository.auth_repository.data_sources.remote_datasource

import com.mis.route.e_commerce.data.api.WebServices
import com.mis.route.e_commerce.data.models.auth.AuthResponse
import com.mis.route.e_commerce.data.models.auth.LoginRequest
import com.mis.route.e_commerce.data.utils.SharedPrefrenceHelper
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    val webServices: WebServices,
    val sharedPrefrenceHelper: SharedPrefrenceHelper
) :
    RemoteDataSource {
    override suspend fun login(email: String, password: String) {
        try {
            val authResponse = webServices.login(LoginRequest(email, password))
            sharedPrefrenceHelper.saveToken(authResponse.token!!)
        } catch (throwable: Throwable) {
            throw throwable
        }
    }
}