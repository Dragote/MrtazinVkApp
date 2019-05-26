package com.murtazin.vkapp.domain.repository

import com.murtazin.vkapp.presentation.model.Post

interface PostRepository {

    fun getAll(): List<Post>

    fun getPost(id: Long): Post
}