package com.mis.route.e_commerce.data.repository.auth_repository.data_sources.remote_datasource

interface RemoteDataSource {
    suspend fun login(email: String, password: String)
}