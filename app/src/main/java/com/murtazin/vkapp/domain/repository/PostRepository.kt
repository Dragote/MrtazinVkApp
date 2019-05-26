package com.murtazin.vkapp.domain.repository

import com.murtazin.vkapp.domain.entity.PostEntity

interface PostRepository {

    fun getAll(): List<PostEntity>

    fun getPost(id: Long): PostEntity
}