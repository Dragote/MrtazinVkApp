package com.murtazin.vkapp.data.datasource

import com.murtazin.vkapp.dagger.MockQualifier
import com.murtazin.vkapp.data.datasource.interfaces.PostDataSource
import com.murtazin.vkapp.data.network.Api
import com.murtazin.vkapp.data.response.Audio
import com.murtazin.vkapp.data.response.Photo
import com.murtazin.vkapp.data.response.Post
import com.murtazin.vkapp.data.response.PostsResponse
import io.reactivex.Single
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(@MockQualifier private val api: Api): PostDataSource {

    override fun getPosts(userId: Long, page: Int): Single<PostsResponse> =
            api.getPosts(userId,page)
}