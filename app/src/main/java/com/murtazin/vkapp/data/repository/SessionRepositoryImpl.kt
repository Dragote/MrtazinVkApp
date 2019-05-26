package com.murtazin.vkapp.data.repository

import com.murtazin.vkapp.data.converters.DataConverter
import com.murtazin.vkapp.data.network.Api
import com.murtazin.vkapp.data.response.ProfileResponse
import com.murtazin.vkapp.domain.repository.SessionRepository
import com.murtazin.vkapp.domain.entity.ProfileEntity
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
    private val api: Api,
    private val profileEntityDataConverter: DataConverter<ProfileResponse, ProfileEntity>
) : SessionRepository {

    override fun login(email: String, password: String): Single<ProfileEntity> =
        api.login(email, password)
            .subscribeOn(Schedulers.io())
            .map(profileEntityDataConverter::convertTo)

    override fun isAuth(): Boolean = true


}