package com.gmail.intellect.logos.vkapp.fragment.logIn

import com.arellomobile.mvp.MvpView

interface LogIn : MvpView {
    fun showLogInScreen(login : String, password : String)
}