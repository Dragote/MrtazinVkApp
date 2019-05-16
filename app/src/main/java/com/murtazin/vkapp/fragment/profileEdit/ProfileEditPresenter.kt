package com.murtazin.vkapp.fragment.profileEdit

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.murtazin.vkapp.App
import com.murtazin.vkapp.moxy.Repository
import com.murtazin.vkapp.navigation.Screen

@InjectViewState
class ProfileEditPresenter : MvpPresenter<ProfileEdit>() {

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



