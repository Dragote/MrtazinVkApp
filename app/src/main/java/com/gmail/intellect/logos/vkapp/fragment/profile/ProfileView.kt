package com.gmail.intellect.logos.vkapp.fragment.profile

import com.arellomobile.mvp.MvpView

interface ProfileView : MvpView {
    fun showProfile(firstName: String)
    fun showFeed(items: List<BaseMessage>)
}