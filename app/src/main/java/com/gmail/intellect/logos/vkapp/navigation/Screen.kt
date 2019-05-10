package com.gmail.intellect.logos.vkapp.navigation

import androidx.fragment.app.Fragment
import com.gmail.intellect.logos.vkapp.fragment.profileEdit.ProfileEditFragment
import com.gmail.intellect.logos.vkapp.fragment.logIn.LogInFragment
import com.gmail.intellect.logos.vkapp.fragment.profileView.ProfileViewFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

sealed class Screen(fragment: Fragment) : BaseScreen(fragment) {
    class ProfileViewScreen : Screen(ProfileViewFragment())
    class ProfileEditScreen : Screen(ProfileEditFragment())
    class LogInScreen : Screen(LogInFragment())

}

open class BaseScreen(private val fragment: Fragment) : SupportAppScreen() {
    override fun getFragment(): Fragment = fragment
}