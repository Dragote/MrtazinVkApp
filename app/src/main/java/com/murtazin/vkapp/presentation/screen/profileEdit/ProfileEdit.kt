package com.murtazin.vkapp.presentation.screen.profileEdit

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.murtazin.vkapp.domain.repository.ProfileRepository
import com.murtazin.vkapp.presentation.models.Profile

@StateStrategyType(AddToEndSingleStrategy::class)
interface ProfileEdit : MvpView {
    fun showProfileInfo(profile : Profile)
    fun showNetworkError()
}