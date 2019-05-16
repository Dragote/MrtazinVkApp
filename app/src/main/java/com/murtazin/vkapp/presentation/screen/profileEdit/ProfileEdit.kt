package com.murtazin.vkapp.presentation.screen.profileEdit

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.murtazin.vkapp.data.Repository

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileEdit : MvpView {
    fun showProfileInfo(repository: Repository)
    fun showNetworkError()

}