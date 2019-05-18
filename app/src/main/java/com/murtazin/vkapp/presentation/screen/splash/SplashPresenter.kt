package com.murtazin.vkapp.presentation.screen.splash

import android.os.Handler
import com.arellomobile.mvp.MvpPresenter
import com.murtazin.vkapp.App
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SplashPresenter @Inject constructor(private val router: Router) : BasePresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        Handler().postDelayed({
            router.newRootScreen(Screen.LogInScreen())
        }, 2000)
    }
}