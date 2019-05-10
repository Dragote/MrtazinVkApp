package com.gmail.intellect.logos.vkapp.fragment.profileView

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.gmail.intellect.logos.vkapp.fragment.profileView.feed.BaseMessage

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileView : MvpView {
    fun showProfile(firstName: String,
                    lastName: String,
                    status: String,
                    birthday: String,
                    sex: String,
                    city: String,
                    country: String,
                    education: String)
    fun showFeed(items: List<BaseMessage>)

}