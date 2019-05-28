package com.murtazin.vkapp.data.datasource

import com.murtazin.vkapp.data.datasource.interfaces.ProfileDataSource
import com.murtazin.vkapp.data.network.Api
import com.murtazin.vkapp.data.response.ProfileResponse
import io.reactivex.Single
import javax.inject.Inject

class ProfileDataSourceImpl @Inject constructor(api: Api): ProfileDataSource {

    override fun getProfile(): Single<ProfileResponse> =
        Single.just(
            ProfileResponse(
            48392502,
            "Эмиль",
            "Муртазин",
            "Vallar Morghulis",
            "14.07.98",
            "Томск",
            "89138117651",
            "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg"))

}