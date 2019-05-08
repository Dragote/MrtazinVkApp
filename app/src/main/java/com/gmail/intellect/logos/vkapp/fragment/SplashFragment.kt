package com.gmail.intellect.logos.vkapp.fragment

import android.os.Handler
import com.gmail.intellect.logos.vkapp.App
import com.gmail.intellect.logos.vkapp.R
import com.gmail.intellect.logos.vkapp.navigation.Screen
import kotlinx.android.synthetic.main.frament_splash.*


class SplashFragment : BaseFragment(R.layout.frament_splash) {

    override fun onResume() {
        super.onResume()


        Handler().postDelayed({
            App.INCTANCE.router.replaceScreen(Screen.LogInScreen())
        }, 3000)
    }

}