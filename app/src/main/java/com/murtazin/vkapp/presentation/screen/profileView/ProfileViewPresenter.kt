package com.murtazin.vkapp.presentation.screen.profileView

import com.arellomobile.mvp.InjectViewState
import com.murtazin.vkapp.presentation.screen.profileView.feed.PostMessage
import com.murtazin.vkapp.data.Repository
import com.murtazin.vkapp.data.Repository.firstName
import com.murtazin.vkapp.data.Repository.lastName
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class ProfileViewPresenter @Inject constructor(private val router: Router) : BasePresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProfile(Repository)

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
        router.newRootScreen(Screen.LogInScreen())
    }

    fun edit() {
        router.navigateTo(Screen.ProfileEditScreen())

    }
}