package com.gmail.intellect.logos.vkapp.fragment.splash

import com.arellomobile.mvp.presenter.InjectPresenter
import com.gmail.intellect.logos.vkapp.R
import com.gmail.intellect.logos.vkapp.fragment.BaseFragment

class SplashFragment: BaseFragment(R.layout.fragment_splash), SplashView {

    @InjectPresenter
    lateinit var presenter: SplashPresenter

}