package com.murtazin.vkapp.presentation.screen.logIn

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface LogIn : MvpView {
    fun initLogInScreen()
    fun showLogInError()
    fun showNetworkError()
}