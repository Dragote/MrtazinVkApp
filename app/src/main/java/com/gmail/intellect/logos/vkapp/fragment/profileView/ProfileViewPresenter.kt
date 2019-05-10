package com.gmail.intellect.logos.vkapp.fragment.profileView

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.gmail.intellect.logos.vkapp.App
import com.gmail.intellect.logos.vkapp.fragment.profileView.feed.PostMessage
import com.gmail.intellect.logos.vkapp.moxy.Repository.birthday
import com.gmail.intellect.logos.vkapp.moxy.Repository.city
import com.gmail.intellect.logos.vkapp.moxy.Repository.country
import com.gmail.intellect.logos.vkapp.moxy.Repository.education
import com.gmail.intellect.logos.vkapp.moxy.Repository.firstName
import com.gmail.intellect.logos.vkapp.moxy.Repository.lastName
import com.gmail.intellect.logos.vkapp.moxy.Repository.sex
import com.gmail.intellect.logos.vkapp.moxy.Repository.status
import com.gmail.intellect.logos.vkapp.navigation.Screen
import com.google.android.material.snackbar.Snackbar

@InjectViewState
class ProfileViewPresenter : MvpPresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProfile(firstName, lastName, status, birthday, sex, city, country, education)

        viewState.showFeed(
            listOf(
                PostMessage(
                    0, "$firstName $lastName",
                    "It's just only message post",
                    "",
                    "",
                    "",
                    "",
                    43,
                    "14 август 2018"
                ),
                PostMessage(
                    1, "$firstName $lastName",
                    "",
                    "https://picsum.photos/id/153/200/300",
                    "",
                    "",
                    "",
                    21,
                    "14 август 2018"
                ),
                PostMessage(
                    2, "$firstName $lastName",
                    "Music Post",
                    "",
                    "",
                    "In cold blood",
                    "Alt-J",
                    13,
                    "14 август 2018"
                ),
                PostMessage(
                    3, "$firstName $lastName",
                    "Picture and music post",
                    "https://picsum.photos/id/167/200/300",
                    "",
                    "In cold blood",
                    "Alt-J",
                    96,
                    "14 август 2018"
                ),
                PostMessage(
                    4, "$firstName $lastName",
                    "Video post",
                    "",
                    "Video",
                    "",
                    "",
                    43,
                    "14 август 2018"
                ),
                PostMessage(
                    5, "$firstName $lastName",
                    "Basic message",
                    "https://picsum.photos/id/153/200/300",
                    "Video",
                    "In cold blood",
                    "Alt-J",
                    43,
                    "14 август 2018"
                )
            )
        )

    }

    fun logout() {
        App.INCTANCE.router.newRootScreen(Screen.LogInScreen())
    }
    fun edit() {
        App.INCTANCE.router.navigateTo(Screen.ProfileEditScreen())

    }


}