package com.murtazin.vkapp.presentation.screen.logIn

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.murtazin.vkapp.App
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.navigation.Screen

@InjectViewState
class LogInPresenter : BasePresenter<LogIn>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initLogInScreen("default login", "default password")
    }

    fun logIn(){
        App.INCTANCE.router.newRootScreen(Screen.ProfileViewScreen())
    }

}