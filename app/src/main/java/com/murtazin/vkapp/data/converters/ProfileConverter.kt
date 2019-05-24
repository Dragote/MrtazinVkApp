package com.murtazin.vkapp.data.converters

import com.murtazin.vkapp.data.response.ProfileResponse
import com.murtazin.vkapp.domain.entity.Profile
import javax.inject.Inject

class ProfileConverter @Inject constructor(): Converter<ProfileResponse, Profile> {

    override fun convertTo(t: ProfileResponse): Profile = Profile(
        t.id,
        t.firstName,
        t.lastName,
        t.status,
        t.birthday,
        t.sex,
        t.city,
        t.country,
        t.education,
        t.avatarUrl
    )

    override fun convertFrom(k: Profile): ProfileResponse = ProfileResponse(
        k.id,
        k.firstName,
        k.lastName,
        k.status,
        k.birthday,
        k.sex,
        k.city,
        k.country,
        k.education,
        k.avatarUrl
    )
}