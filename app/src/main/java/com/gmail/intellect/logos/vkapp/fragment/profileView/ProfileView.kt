package com.gmail.intellect.logos.vkapp.fragment.profileView

import com.arellomobile.mvp.MvpView

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