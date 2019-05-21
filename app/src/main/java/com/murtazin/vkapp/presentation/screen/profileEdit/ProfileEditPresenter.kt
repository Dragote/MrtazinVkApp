package com.murtazin.vkapp.presentation.screen.profileEdit

import com.arellomobile.mvp.InjectViewState
import com.murtazin.vkapp.domain.repository.ProfileRepository
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileEditPresenter @Inject constructor(private val router: Router,
                                               private val profileRepository: ProfileRepository) : BasePresenter<ProfileEdit>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showProfileInfo(profileRepository.getProfile())
    }

    fun cancelEdit() {
        router.newRootScreen(Screen.ProfileViewScreen())
    }

    fun saveEdit() {
        router.navigateTo(Screen.ProfileViewScreen())
    }
}



