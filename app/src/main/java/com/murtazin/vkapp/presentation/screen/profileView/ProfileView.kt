package com.murtazin.vkapp.presentation.screen.profileView

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.murtazin.vkapp.domain.entity.PostMessage
import com.murtazin.vkapp.domain.entity.Profile

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileView : MvpView {
    fun showProfile(profile: Profile)
    fun showFeed(items: List<PostMessage>)
    fun showNetworkError()
}