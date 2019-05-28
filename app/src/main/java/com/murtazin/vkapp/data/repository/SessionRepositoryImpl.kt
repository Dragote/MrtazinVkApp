package com.murtazin.vkapp.data.repository

import com.murtazin.vkapp.data.converters.DataConverter
import com.murtazin.vkapp.data.datasource.interfaces.LoginDataSource
import com.murtazin.vkapp.data.datasource.interfaces.SessionDataSource
import com.murtazin.vkapp.data.response.ProfileResponse
import com.murtazin.vkapp.domain.repository.SessionRepository
import com.murtazin.vkapp.domain.entity.ProfileEntity
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
    private val sessionDataSource: SessionDataSource,
    private val loginDataSource: LoginDataSource,
    private val profileEntityDataConverter: DataConverter<ProfileResponse, ProfileEntity>
) : SessionRepository {

    override fun login(phone: String, password: String): Single<ProfileEntity> =
        loginDataSource.login(phone, password)
            .subscribeOn(Schedulers.io())
            .map(profileEntityDataConverter::convert)

    override fun isAuth(): Boolean = sessionDataSource.getToken().isNotEmpty()

}