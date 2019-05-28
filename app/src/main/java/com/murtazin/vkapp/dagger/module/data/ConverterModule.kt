package com.murtazin.vkapp.dagger.module.data


import com.murtazin.vkapp.data.converters.DataConverter
import com.murtazin.vkapp.data.converters.PostEntityConverter
import com.murtazin.vkapp.data.converters.ProfileEntityConverter
import com.murtazin.vkapp.data.response.PostsResponse
import com.murtazin.vkapp.data.response.ProfileResponse
import com.murtazin.vkapp.domain.entity.PostEntity
import com.murtazin.vkapp.domain.entity.ProfileEntity
import com.murtazin.vkapp.presentation.converter.Converter
import com.murtazin.vkapp.presentation.converter.PostConverter
import com.murtazin.vkapp.presentation.converter.ProfileConverter
import com.murtazin.vkapp.presentation.model.Post
import com.murtazin.vkapp.presentation.model.Profile
import dagger.Binds
import dagger.Module
import dagger.Reusable

@Module
interface ConverterModule {

    @Reusable
    @Binds
    fun bindProfileEntityConverter(instance: ProfileEntityConverter): DataConverter<ProfileResponse, ProfileEntity>

    @Reusable
    @Binds
    fun bindProfileConverter(instance: ProfileConverter): Converter<ProfileEntity, Profile>

    @Reusable
    @Binds
    fun bindPostEntityConverter(instance: PostEntityConverter): DataConverter<PostsResponse, List<PostEntity>>

    @Reusable
    @Binds
    fun bindPostConverter(instance: PostConverter): Converter<List<PostEntity>, List<Post>>
}