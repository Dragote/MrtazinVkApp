package com.murtazin.vkapp.domain.repository

import com.murtazin.vkapp.domain.entity.PostMessage

interface PostRepository {

    fun getAll(): List<PostMessage>

    fun getPost(id: Long): PostMessage
}