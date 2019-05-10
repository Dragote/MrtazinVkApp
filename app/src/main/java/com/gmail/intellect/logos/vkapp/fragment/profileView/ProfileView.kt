package com.gmail.intellect.logos.vkapp.fragment.profileView

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.gmail.intellect.logos.vkapp.fragment.profileView.feed.BaseMessage
import com.gmail.intellect.logos.vkapp.moxy.Repository

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileView : MvpView {
    fun showProfile(repository: Repository)
    fun showFeed(items: List<BaseMessage>)
    fun showNetworkError()

}