package com.murtazin.vkapp.fragment.logIn

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.murtazin.vkapp.App
import com.murtazin.vkapp.navigation.Screen

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