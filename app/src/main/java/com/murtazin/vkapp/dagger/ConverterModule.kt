package com.murtazin.vkapp.dagger

import com.murtazin.vkapp.data.converters.DataConverter
import com.murtazin.vkapp.data.converters.ProfileEntityConverter
import com.murtazin.vkapp.data.response.ProfileResponse
import com.murtazin.vkapp.domain.entity.ProfileEntity
import com.murtazin.vkapp.presentation.converter.Converter
import com.murtazin.vkapp.presentation.converter.ProfileConverter
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
}