package com.murtazin.vkapp.presentation.screen.profileView

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.murtazin.vkapp.presentation.screen.profileView.feed.BaseMessage
import com.murtazin.vkapp.data.Repository

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileView : MvpView {
    fun showProfile(repository: Repository)
    fun showFeed(items: List<BaseMessage>)
    fun showNetworkError()

}