package com.murtazin.vkapp.data.network

import com.murtazin.vkapp.data.response.ProfileResponse
import io.reactivex.Single
import retrofit2.http.POST

interface Api {

    @POST("login")
    fun login(email: String, password: String): Single<ProfileResponse>
}