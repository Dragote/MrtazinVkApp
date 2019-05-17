package com.murtazin.vkapp.presentation.screen.splash

import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.murtazin.vkapp.R
import com.murtazin.vkapp.presentation.common.BaseFragment
import org.koin.android.ext.android.get

class SplashFragment: BaseFragment(R.layout.fragment_splash),
    SplashView {

    @InjectPresenter
    lateinit var presenter: SplashPresenter

    @ProvidePresenter
    fun providePresenter(): SplashPresenter = get()

}