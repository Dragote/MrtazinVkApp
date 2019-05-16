package com.murtazin.vkapp.fragment.logIn

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType


@StateStrategyType(AddToEndSingleStrategy::class)
interface LogIn : MvpView {
    fun initLogInScreen(login : String, password : String)
    fun showLogInError()
    fun showNetworkError()
}