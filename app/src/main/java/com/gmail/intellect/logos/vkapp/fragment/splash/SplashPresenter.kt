package com.gmail.intellect.logos.vkapp.fragment.splash

import android.os.Handler
import com.arellomobile.mvp.MvpPresenter
import com.gmail.intellect.logos.vkapp.App
import com.gmail.intellect.logos.vkapp.navigation.Screen

class SplashPresenter : MvpPresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Handler().postDelayed({
            App.INCTANCE.router.newRootScreen(Screen.LogInScreen())
        }, 2000)
    }
}