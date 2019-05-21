package com.murtazin.vkapp.presentation.screen.splash

import android.os.Handler
import com.murtazin.vkapp.domain.repository.SessionRepository
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.navigation.Screen
import ru.terrakok.cicerone.Router
import javax.inject.Inject

class SplashPresenter @Inject constructor(private val router: Router, private val sessionRepository: SessionRepository) : BasePresenter<SplashView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        Handler().postDelayed({
            router.newRootScreen(
                if (sessionRepository.isAuth()) {
                    Screen.ProfileViewScreen()
                } else {
                    Screen.LogInScreen()
                }
            )
        }, 2000)
    }
}