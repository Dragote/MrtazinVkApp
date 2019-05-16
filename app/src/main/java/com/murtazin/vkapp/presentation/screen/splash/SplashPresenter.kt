package com.murtazin.vkapp.presentation.screen.splash

import android.os.Handler
import com.arellomobile.mvp.MvpPresenter
import com.murtazin.vkapp.App
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.navigation.Screen

class SplashPresenter : BasePresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Handler().postDelayed({
            App.INCTANCE.router.newRootScreen(Screen.LogInScreen())
        }, 2000)
    }
}