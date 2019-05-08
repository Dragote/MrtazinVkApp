package com.gmail.intellect.logos.vkapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gmail.intellect.logos.vkapp.moxy.Repository
import com.gmail.intellect.logos.vkapp.navigation.Navigator
import com.gmail.intellect.logos.vkapp.navigation.Screen
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var navigator: SupportAppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigator = Navigator(this, supportFragmentManager, R.id.content)
        App.INCTANCE.router.newRootScreen(Screen.SplashScreen())
        Repository.initRepository()
        
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
