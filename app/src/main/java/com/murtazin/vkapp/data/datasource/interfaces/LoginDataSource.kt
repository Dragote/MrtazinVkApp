package com.murtazin.vkapp.data.datasource.interfaces

import com.murtazin.vkapp.data.response.ProfileResponse
import io.reactivex.Single

interface LoginDataSource {

    fun login(name:String,password: String): Single<ProfileResponse>

}

