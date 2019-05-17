package com.murtazin.vkapp.presentation

import com.murtazin.vkapp.presentation.screen.logIn.LogInPresenter
import com.murtazin.vkapp.presentation.screen.main.MainPresenter
import com.murtazin.vkapp.presentation.screen.profileEdit.ProfileEditPresenter
import com.murtazin.vkapp.presentation.screen.profileView.ProfileViewPresenter
import com.murtazin.vkapp.presentation.screen.splash.SplashPresenter
import org.koin.dsl.module
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Router

val presentationModule = module {

    single { Cicerone.create() }
    single { get<Cicerone<Router>>().router }
    single { get<Cicerone<Router>>().navigatorHolder }

    factory { SplashPresenter(get()) }
    factory { MainPresenter(get()) }
    factory { LogInPresenter(get()) }
    factory { ProfileEditPresenter(get()) }
    factory { ProfileViewPresenter(get()) }
}