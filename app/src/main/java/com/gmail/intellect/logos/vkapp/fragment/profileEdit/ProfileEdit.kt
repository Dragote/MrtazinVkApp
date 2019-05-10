package com.gmail.intellect.logos.vkapp.fragment.profileEdit

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.gmail.intellect.logos.vkapp.moxy.Repository

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileEdit : MvpView {
    fun showProfileInfo(repository: Repository)
    fun showNetworkError()

}