package com.murtazin.vkapp.domain.repository

import com.murtazin.vkapp.presentation.models.Profile

interface ProfileRepository {
    fun getProfile(): Profile
    fun setProfile(profile: Profile)
}
