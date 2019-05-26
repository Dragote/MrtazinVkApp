package com.murtazin.vkapp.presentation.converter

import com.murtazin.vkapp.domain.entity.ProfileEntity
import com.murtazin.vkapp.presentation.model.Profile
import javax.inject.Inject

class ProfileConverter @Inject constructor() : Converter<ProfileEntity, Profile> {

    override fun convert (t: ProfileEntity): Profile =
            Profile(
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