package com.murtazin.vkapp.data.datasource.interfaces

import com.murtazin.vkapp.data.response.PostsResponse
import io.reactivex.Single

interface PostDataSource {

    fun getPosts(userId: Long, page: Int): Single<PostsResponse>
}