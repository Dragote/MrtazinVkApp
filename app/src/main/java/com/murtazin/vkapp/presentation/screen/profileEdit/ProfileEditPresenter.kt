package com.murtazin.vkapp.presentation.screen.profileEdit

import com.arellomobile.mvp.InjectViewState
import com.murtazin.vkapp.domain.repository.ProfileRepository
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.model.Profile
import com.murtazin.vkapp.presentation.navigation.Screen
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileEditPresenter @Inject constructor(private val router: Router,
                                               private val profileRepository: ProfileRepository) : BasePresenter<ProfileEdit>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showProfileInfo(Profile(
            48392502,
            "Эмиль",
            "Муртазин",
            "Vallar Morghulis",
            "14.07.98",
            "Томск",
            "89138117651",
            "https://vk.com/images/camera_200.png?ava=1?ava=1"
        ))
    }


    fun cancelEdit() {
        router.newRootScreen(Screen.ProfileViewScreen())
    }

    fun saveEdit() {
        router.navigateTo(Screen.ProfileViewScreen())
    }
}



