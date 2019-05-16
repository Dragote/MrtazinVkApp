package com.murtazin.vkapp.presentation.screen.profileEdit

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.murtazin.vkapp.App
import com.murtazin.vkapp.data.Repository
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.navigation.Screen

@InjectViewState
class ProfileEditPresenter : BasePresenter<ProfileEdit>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProfileInfo(Repository)
    }

    fun cancelEdit() {
        App.INCTANCE.router.newRootScreen(Screen.ProfileViewScreen())
    }

    fun saveEdit(
        firstName: String,
        lastName: String,
        status: String,
        birthday: String,
        sex: String,
        city: String,
        country: String,
        education: String
    ) {
        Repository.setData(firstName, lastName, status, birthday, sex, city, country, education)

        App.INCTANCE.router.navigateTo(Screen.ProfileViewScreen())


    }


}



