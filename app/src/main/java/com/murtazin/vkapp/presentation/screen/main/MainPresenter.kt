package com.murtazin.vkapp.presentation.screen.main

import com.arellomobile.mvp.InjectViewState
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.navigation.Screen
import ru.terrakok.cicerone.Router


@InjectViewState
class MainPresenter(private val router: Router): BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.newRootScreen(Screen.SplashScreen())
    }
}