package com.murtazin.vkapp.dagger.module.presentation

import com.murtazin.vkapp.dagger.ActivityScope
import com.murtazin.vkapp.presentation.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun provideMainAtivity(): MainActivity
}