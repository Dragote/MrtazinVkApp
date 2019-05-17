package com.murtazin.vkapp.presentation.screen.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.murtazin.vkapp.App
import com.murtazin.vkapp.R
import com.murtazin.vkapp.presentation.navigation.Navigator
import com.murtazin.vkapp.presentation.navigation.Screen
import ru.terrakok.cicerone.android.support.SupportAppNavigator

class MainActivity : AppCompatActivity() {

    private lateinit var navigator: SupportAppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = Navigator(this, supportFragmentManager, R.id.content)
        App.INCTANCE.router.newRootScreen(Screen.SplashScreen())
    }

    override fun onResume() {
        super.onResume()
        App.INCTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.INCTANCE.navigatorHolder.removeNavigator()
    }

}
