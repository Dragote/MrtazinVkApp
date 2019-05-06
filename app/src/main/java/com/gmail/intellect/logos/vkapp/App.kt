package com.gmail.intellect.logos.vkapp

import android.app.Application
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router


class App : Application() {

    companion object {
        lateinit var INCTANCE: App
    }

    private lateinit var cicerone: Cicerone<Router>

    val router: Router
        get() = cicerone.router

    val navigatorHolder: NavigatorHolder
        get() = cicerone.navigatorHolder

    override fun onCreate() {
        super.onCreate()

        INCTANCE = this
        cicerone = Cicerone.create()
    }
}