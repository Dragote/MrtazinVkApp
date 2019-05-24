package com.murtazin.vkapp.presentation.screen.logIn

import android.provider.ContactsContract
import com.arellomobile.mvp.InjectViewState
import com.murtazin.vkapp.domain.repository.SessionRepository
import com.murtazin.vkapp.presentation.common.BasePresenter
import com.murtazin.vkapp.presentation.navigation.Screen
import io.reactivex.android.schedulers.AndroidSchedulers
import ru.terrakok.cicerone.Router
import javax.inject.Inject

@InjectViewState
class LogInPresenter @Inject constructor(
    private val router: Router,
    private val sessionRepository: SessionRepository) : BasePresenter<LogIn>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initLogInScreen("default login", "default password")
    }

    fun logIn(email: String, password: String) {
        sessionRepository
            .login(email, password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    router.newRootScreen(Screen.ProfileViewScreen())
                },
                {
                    viewState.showLogInError()
                }
            ).untilDestroy()

    }

}