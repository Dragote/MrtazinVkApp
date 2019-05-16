package com.murtazin.vkapp.fragment.splash

import android.os.Handler
import com.arellomobile.mvp.MvpPresenter
import com.murtazin.vkapp.App
import com.murtazin.vkapp.navigation.Screen

class SplashPresenter : MvpPresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Handler().postDelayed({
            App.INCTANCE.router.newRootScreen(Screen.LogInScreen())
        }, 2000)
    }
}