package com.gmail.intellect.logos.vkapp.navigation

import androidx.fragment.app.Fragment
import com.gmail.intellect.logos.vkapp.fragment.ProfileEditFragment
import com.gmail.intellect.logos.vkapp.fragment.profile.ProfileViewFragment
import com.gmail.intellect.logos.vkapp.fragment.SplashFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen(fragment: Fragment) : BaseScreen(fragment) {
    class SplashScreen : Screen(SplashFragment())
    class ProfileViewScreen : Screen(ProfileViewFragment())
    class ProfileEditScreen : Screen(ProfileEditFragment())

}

open class BaseScreen(private val fragment: Fragment) : SupportAppScreen() {
    override fun getFragment(): Fragment = fragment
}