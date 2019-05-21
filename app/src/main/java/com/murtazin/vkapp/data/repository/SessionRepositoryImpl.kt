package com.murtazin.vkapp.data.repository

import com.murtazin.vkapp.domain.repository.SessionRepository
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor() : SessionRepository {

    override fun isAuth(): Boolean = false
}