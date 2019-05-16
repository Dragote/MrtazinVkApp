package com.murtazin.vkapp.presentation.screen.splash

import com.arellomobile.mvp.presenter.InjectPresenter
import com.murtazin.vkapp.R
import com.murtazin.vkapp.presentation.common.BaseFragment

class SplashFragment: BaseFragment(R.layout.fragment_splash),
    SplashView {

    @InjectPresenter
    lateinit var presenter: SplashPresenter

}