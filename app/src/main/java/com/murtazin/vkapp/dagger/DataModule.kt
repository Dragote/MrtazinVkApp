package com.murtazin.vkapp.dagger

import com.murtazin.vkapp.domain.repository.PostRepository
import com.murtazin.vkapp.data.repository.PostRepositoryImpl
import com.murtazin.vkapp.domain.repository.SessionRepository
import com.murtazin.vkapp.data.repository.SessionRepositoryImpl
import com.murtazin.vkapp.data.repository.ProfileRepositoryImpl
import com.murtazin.vkapp.domain.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module(includes = [NetworkModule::class])
interface DataModule {

    @Reusable
    @Binds
    fun bindProfileRepository(instance: ProfileRepositoryImpl): ProfileRepository

    @Reusable
    @Binds
    fun bindSessionRepository(instance: SessionRepositoryImpl): SessionRepository

    @Reusable
    @Binds
    fun bindPostRepository(instance: PostRepositoryImpl): PostRepository


}