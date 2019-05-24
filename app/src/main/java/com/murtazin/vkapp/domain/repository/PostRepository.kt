package com.murtazin.vkapp.domain.repository

import com.murtazin.vkapp.domain.entity.PostMessage
import io.reactivex.Single

interface PostRepository {

    fun getAll(): List<PostMessage>

    fun getPost(id: Long): PostMessage
}