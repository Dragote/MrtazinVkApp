package com.murtazin.vkapp.presentation.screen.profileView

import com.arellomobile.mvp.InjectViewState
import com.murtazin.vkapp.domain.repository.PostRepository
import com.murtazin.vkapp.domain.repository.ProfileRepository
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileViewPresenter @Inject constructor(private val router: Router,
                                               private val postRepository: PostRepository,
                                               private val profileRepository: ProfileRepository) : BasePresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProfile(profileRepository.getProfile())

        viewState.showFeed(postRepository.getAll())

    }

    fun logout() {
        router.newRootScreen(Screen.LogInScreen())
    }

    fun edit() {
        router.navigateTo(Screen.ProfileEditScreen())

    }
}