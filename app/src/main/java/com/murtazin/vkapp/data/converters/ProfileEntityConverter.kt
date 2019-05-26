package com.murtazin.vkapp.data.converters

import com.murtazin.vkapp.data.response.ProfileResponse
import com.murtazin.vkapp.domain.entity.ProfileEntity
import javax.inject.Inject

class ProfileEntityConverter @Inject constructor(): DataConverter<ProfileResponse, ProfileEntity> {

    override fun convert(t: ProfileResponse): ProfileEntity = ProfileEntity(
        t.id,
        t.firstName,
        t.lastName,
        t.status,
        t.birthday,
        t.city,
        t.phone,
        t.avatarUrl
    )

}