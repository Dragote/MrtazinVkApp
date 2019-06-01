package com.murtazin.vkapp.presentation.screen.profileEdit

import com.arellomobile.mvp.InjectViewState
import com.murtazin.vkapp.domain.entity.ProfileEntity
import com.murtazin.vkapp.domain.repository.ProfileRepository
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.converter.Converter
import com.murtazin.vkapp.presentation.model.Profile
import com.murtazin.vkapp.presentation.navigation.Screen
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileEditPresenter @Inject constructor(private val router: Router,
                                               private val profileRepository: ProfileRepository,
                                               private val profileConverter: Converter<ProfileEntity, Profile>) : BasePresenter<ProfileEdit>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        profileRepository.getProfile()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    viewState.showProfileInfo(profileConverter.convert(it))
                },
                {
                    viewState.showNetworkError()
                }
            ).untilDestroy()

    }


    fun cancelEdit() {
        router.newRootScreen(Screen.ProfileViewScreen())
    }

    fun saveEdit() {
        router.newRootScreen(Screen.ProfileViewScreen())
    }
}



