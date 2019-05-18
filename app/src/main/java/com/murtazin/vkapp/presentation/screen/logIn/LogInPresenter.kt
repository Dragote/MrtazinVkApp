package com.murtazin.vkapp.presentation.screen.logIn

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.murtazin.vkapp.App
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class LogInPresenter @Inject constructor(private val router: Router) : BasePresenter<LogIn>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initLogInScreen("default login", "default password")
    }

    fun logIn(){
        router.newRootScreen(Screen.ProfileViewScreen())
    }

}