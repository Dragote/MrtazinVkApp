package com.murtazin.vkapp.dagger

import com.murtazin.vkapp.App
import com.murtazin.vkapp.dagger.module.data.DataModule
import com.murtazin.vkapp.dagger.module.presentation.AppModule
import com.murtazin.vkapp.dagger.module.presentation.NavigationModule
import com.murtazin.vkapp.dagger.module.presentation.PresentationModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        PresentationModule::class,
        DataModule::class
    ]
)
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Builder : AndroidInjector.Factory<App>
}