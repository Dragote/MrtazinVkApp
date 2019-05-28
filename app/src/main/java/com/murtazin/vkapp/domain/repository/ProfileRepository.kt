package com.murtazin.vkapp.domain.repository

import com.murtazin.vkapp.domain.entity.ProfileEntity
import com.murtazin.vkapp.presentation.model.Profile
import io.reactivex.Single

interface ProfileRepository {
    fun getProfile(): Single<ProfileEntity>
}
