package com.murtazin.vkapp.domain.repository

import com.murtazin.vkapp.domain.entity.ProfileEntity
import io.reactivex.Single

interface SessionRepository {

    fun isAuth(): Boolean

    fun login(phone: String, password: String): Single<ProfileEntity>
}
