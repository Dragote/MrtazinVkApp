package com.murtazin.vkapp.domain.repository

import com.murtazin.vkapp.presentation.models.Profile
import io.reactivex.Single

interface SessionRepository {

    fun isAuth(): Boolean

    fun login(email:String, password: String): Single<Profile>
}