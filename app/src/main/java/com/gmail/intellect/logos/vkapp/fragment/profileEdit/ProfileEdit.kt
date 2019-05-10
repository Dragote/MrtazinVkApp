package com.gmail.intellect.logos.vkapp.fragment.profileEdit

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileEdit : MvpView {
    fun showProfileInfo(firstName: String,
                        lastName: String,
                        status: String,
                        birthday: String,
                        sex: String,
                        city: String,
                        country: String,
                        education: String)

}