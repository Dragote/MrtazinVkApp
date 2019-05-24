package com.murtazin.vkapp.data.repository

import com.murtazin.vkapp.data.network.Api
import com.murtazin.vkapp.domain.repository.SessionRepository
import com.murtazin.vkapp.domain.entity.Profile
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(private val api: Api) : SessionRepository {

    override fun login(email: String, password: String): Single<Profile> = TODO()
       /* api.login(email, password)
            .subscribeOn(Schedulers.io())
            .map()*/


    override fun isAuth(): Boolean = false


}