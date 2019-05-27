package com.murtazin.vkapp.dagger.module.presentation

import dagger.Module

@Module(includes = [
    AppModule::class,
    MainActivityModule::class,
    NavigationModule::class
])
interface PresentationModule