package com.murtazin.vkapp.data.repository

import com.murtazin.vkapp.domain.repository.ProfileRepository
import com.murtazin.vkapp.domain.entity.ProfileEntity
import io.reactivex.Single
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(): ProfileRepository {
    override fun getProfile(): Single<ProfileEntity> = Single.just(ProfileEntity(
        48392502,
        "Эмиль",
        "Муртазин",
        "Vallar Morghulis",
        "14.07.98",
        "Томск",
        "89138117651",
        "https://vk.com/images/camera_200.png?ava=1?ava=1"
    ))

    override fun setProfile(profileEntity: ProfileEntity) {

    }

}


