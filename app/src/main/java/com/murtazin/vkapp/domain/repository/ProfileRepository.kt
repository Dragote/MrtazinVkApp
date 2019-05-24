package com.murtazin.vkapp.domain.repository

import com.murtazin.vkapp.domain.entity.Profile

interface ProfileRepository {
    fun getProfile(): Profile
    fun setProfile(profile: Profile)
}
