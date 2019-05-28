package com.murtazin.vkapp.dagger.module.data

import android.content.Context
import android.content.SharedPreferences
import com.murtazin.vkapp.App
import com.murtazin.vkapp.data.datasource.LoginDataSourceImpl
import com.murtazin.vkapp.data.datasource.PostDataSourceImpl
import com.murtazin.vkapp.data.datasource.ProfileDataSourceImpl
import com.murtazin.vkapp.data.datasource.SessionDataSourceImpl
import com.murtazin.vkapp.data.datasource.interfaces.LoginDataSource
import com.murtazin.vkapp.data.datasource.interfaces.PostDataSource
import com.murtazin.vkapp.data.datasource.interfaces.ProfileDataSource
import com.murtazin.vkapp.data.datasource.interfaces.SessionDataSource
import com.murtazin.vkapp.domain.repository.PostRepository
import com.murtazin.vkapp.data.repository.PostRepositoryImpl
import com.murtazin.vkapp.domain.repository.SessionRepository
import com.murtazin.vkapp.data.repository.SessionRepositoryImpl
import com.murtazin.vkapp.data.repository.ProfileRepositoryImpl
import com.murtazin.vkapp.domain.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module(includes = [
    NetworkModule::class,
    ConverterModule::class
])
abstract class DataModule {

    @Module
    companion object {
        @JvmStatic
        @Reusable
        @Provides
        fun provideSharedPreferences(app: App): SharedPreferences =
            app.getSharedPreferences("CommonSharedPreferences", Context.MODE_PRIVATE)
    }

    @Reusable
    @Binds
    abstract fun bindProfileRepository(instance: ProfileRepositoryImpl): ProfileRepository

    @Reusable
    @Binds
    abstract fun bindSessionRepository(instance: SessionRepositoryImpl): SessionRepository

    @Reusable
    @Binds
    abstract fun bindPostRepository(instance: PostRepositoryImpl): PostRepository

    @Reusable
    @Binds
    abstract fun bindPostDataSource(instance: PostDataSourceImpl): PostDataSource

    @Reusable
    @Binds
    abstract fun bindProfileDataSource(instance: ProfileDataSourceImpl): ProfileDataSource

    @Reusable
    @Binds
    abstract fun bindLoginDataSource(instance: LoginDataSourceImpl): LoginDataSource

    @Reusable
    @Binds
    abstract fun bindSessionDataSource(instance: SessionDataSourceImpl): SessionDataSource




}