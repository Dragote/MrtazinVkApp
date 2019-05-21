package com.murtazin.vkapp.presentation.screen.profileView

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.murtazin.vkapp.domain.repository.ProfileRepository
import com.murtazin.vkapp.presentation.models.Profile
import com.murtazin.vkapp.presentation.screen.profileView.feed.BaseMessage

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileView : MvpView {
    fun showProfile(profile: Profile)
    fun showFeed(items: List<BaseMessage>)
    fun showNetworkError()
}