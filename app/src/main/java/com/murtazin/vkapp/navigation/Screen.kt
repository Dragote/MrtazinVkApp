package com.murtazin.vkapp.navigation

import androidx.fragment.app.Fragment
import com.murtazin.vkapp.fragment.profileEdit.ProfileEditFragment
import com.murtazin.vkapp.fragment.logIn.LogInFragment
import com.murtazin.vkapp.fragment.profileView.ProfileViewFragment
import com.murtazin.vkapp.fragment.splash.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen(fragment: Fragment) : BaseScreen(fragment) {
    class ProfileViewScreen : Screen(ProfileViewFragment())
    class ProfileEditScreen : Screen(ProfileEditFragment())
    class LogInScreen : Screen(LogInFragment())
    class SplashScreen : Screen(SplashFragment())

}

open class BaseScreen(private val fragment: Fragment) : SupportAppScreen() {
    override fun getFragment(): Fragment = fragment
}