package com.murtazin.vkapp.dagger

import com.murtazin.vkapp.presentation.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface AppModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModules::class])
    fun provideMainAtivity(): MainActivity
}