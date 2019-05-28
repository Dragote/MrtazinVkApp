package com.murtazin.vkapp.data.datasource

import com.murtazin.vkapp.dagger.MockQualifier
import com.murtazin.vkapp.data.datasource.interfaces.LoginDataSource
import com.murtazin.vkapp.data.network.Api
import com.murtazin.vkapp.data.response.ProfileResponse
import io.reactivex.Single
import javax.inject.Inject

class LoginDataSourceImpl @Inject constructor(@MockQualifier private val api: Api): LoginDataSource {

    override fun login(phone: String, password: String): Single<ProfileResponse> = api.login(phone,password)

}