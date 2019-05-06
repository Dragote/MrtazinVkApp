package com.gmail.intellect.logos.vkapp.fragment.profile

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter

@InjectViewState
class ProfileViewPresenter : MvpPresenter<ProfileView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProfile("Ilya")

        viewState.showFeed((1..100).map {
            if (it % 5 == 0) {
                CatMessage(
                    it,
                    "https://ichef.bbci.co.uk/images/ic/720x405/p0517py6.jpg"
                )
            } else {
                PostMessage(it, "Message".repeat(30), "https://picsum.photos/id/$it/200/300")
            }
        })
    }

    fun logout() {
        TODO("Navigate to login")
    }

}