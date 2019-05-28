package com.murtazin.vkapp.domain.repository

import com.murtazin.vkapp.domain.entity.PostEntity
import com.murtazin.vkapp.presentation.model.Post
import io.reactivex.Single

interface PostRepository {

    fun getPosts(page: Int): Single<List<PostEntity>>

}