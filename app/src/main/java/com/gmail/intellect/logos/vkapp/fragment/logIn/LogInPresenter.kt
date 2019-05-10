package com.gmail.intellect.logos.vkapp.fragment.logIn

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.gmail.intellect.logos.vkapp.App
import com.gmail.intellect.logos.vkapp.navigation.Screen

@InjectViewState
class LogInPresenter : MvpPresenter<LogIn>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initLogInScreen("default login", "default password")
    }

    fun logIn(){
        App.INCTANCE.router.newRootScreen(Screen.ProfileViewScreen())
    }

}