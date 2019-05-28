package com.murtazin.vkapp.data.repository

import com.murtazin.vkapp.data.converters.DataConverter
import com.murtazin.vkapp.data.converters.ProfileEntityConverter
import com.murtazin.vkapp.data.datasource.ProfileDataSourceImpl
import com.murtazin.vkapp.data.datasource.interfaces.ProfileDataSource
import com.murtazin.vkapp.data.response.ProfileResponse
import com.murtazin.vkapp.domain.repository.ProfileRepository
import com.murtazin.vkapp.domain.entity.ProfileEntity
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileDataSource: ProfileDataSource,
    private val profileEntityConverter: DataConverter<ProfileResponse, ProfileEntity>
): ProfileRepository {

    override fun getProfile(): Single<ProfileEntity> = profileDataSource
        .getProfile()
        .subscribeOn(Schedulers.io())
        .map(profileEntityConverter::convert)


}


