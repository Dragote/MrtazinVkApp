package com.murtazin.vkapp.presentation.screen.profileView

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.murtazin.vkapp.presentation.model.Post
import com.murtazin.vkapp.presentation.model.Profile

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileView : MvpView {
    fun showProfile(profile: Profile)
    fun showFeed(items: List<Post>)
    fun showNetworkError()
    fun showProgress()
    fun hideProgress()
}