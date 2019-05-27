package com.murtazin.vkapp.dagger.module.presentation

import com.murtazin.vkapp.dagger.FragmentScope
import com.murtazin.vkapp.presentation.screen.logIn.LogInFragment
import com.murtazin.vkapp.presentation.screen.profileEdit.ProfileEditFragment
import com.murtazin.vkapp.presentation.screen.profileView.ProfileViewFragment
import com.murtazin.vkapp.presentation.screen.splash.SplashFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector
    fun provideSplashFragment(): SplashFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideProfileViewFragment(): ProfileViewFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideProfileEditFragment(): ProfileEditFragment

    @FragmentScope
    @ContributesAndroidInjector
    fun provideLogInFragment(): LogInFragment

}