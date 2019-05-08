package com.gmail.intellect.logos.vkapp.fragment.profileView

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.gmail.intellect.logos.vkapp.App
import com.gmail.intellect.logos.vkapp.moxy.Repository.birthday
import com.gmail.intellect.logos.vkapp.moxy.Repository.city
import com.gmail.intellect.logos.vkapp.moxy.Repository.country
import com.gmail.intellect.logos.vkapp.moxy.Repository.education
import com.gmail.intellect.logos.vkapp.moxy.Repository.firstName
import com.gmail.intellect.logos.vkapp.moxy.Repository.lastName
import com.gmail.intellect.logos.vkapp.moxy.Repository.sex
import com.gmail.intellect.logos.vkapp.moxy.Repository.status
import com.gmail.intellect.logos.vkapp.navigation.Screen

@InjectViewState
class ProfileViewPresenter : MvpPresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()



        viewState.showProfile(firstName, lastName, status, birthday, sex, city, country, education)

        viewState.showFeed((1..100).map {
            if (it % 5 == 0) {
                CatMessage(
                    it,
                    "https://ichef.bbci.co.uk/images/ic/720x405/p0517py6.jpg"
                )
            } else {
                PostMessage(
                    it,
                    "Message".repeat(30),
                    "https://picsum.photos/id/$it/200/300"
                )
            }
        })
    }

    fun logout() {
        App.INCTANCE.router.newRootScreen(Screen.LogInScreen())
    }
    fun edit() {
        App.INCTANCE.router.navigateTo(Screen.ProfileEditScreen())

    }


}