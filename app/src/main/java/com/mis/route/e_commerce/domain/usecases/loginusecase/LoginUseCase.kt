package com.mis.route.e_commerce.domain.usecases.loginusecase


import com.mis.route.e_commerce.domain.repoistory.auth_repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private var authRepo: AuthRepository) {

    var email = ""
    var password = ""
    suspend fun execute(){

        authRepo.login(email, password)
    }
}