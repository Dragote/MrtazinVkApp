package com.murtazin.vkapp.data.repository

import com.murtazin.vkapp.domain.repository.ProfileRepository
import com.murtazin.vkapp.presentation.models.Profile
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(): ProfileRepository {
    override fun getProfile(): Profile = Profile(
        48392502,
        "Эмиль",
        "Муртазин",
        "Vallar Morghulis",
        "14.07.98",
        "Мужской",
        "Томск",
        "Россия",
        "ТПУ Инженерная школа информационных технологий и робототехники (бывш. Институт кибернетики)",
        "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg?ava=1"
    )

    override fun setProfile(profile:Profile) {

    }

}


