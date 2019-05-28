package com.murtazin.vkapp.data.datasource

import com.murtazin.vkapp.dagger.MockQualifier
import com.murtazin.vkapp.data.datasource.interfaces.ProfileDataSource
import com.murtazin.vkapp.data.network.Api
import com.murtazin.vkapp.data.response.ProfileResponse
import io.reactivex.Single
import javax.inject.Inject

class ProfileDataSourceImpl @Inject constructor(@MockQualifier private val api: Api): ProfileDataSource {

    override fun getProfile(): Single<ProfileResponse> =
            api.getProfile(140798)


}