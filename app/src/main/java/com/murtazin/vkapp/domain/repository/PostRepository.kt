package com.murtazin.vkapp.domain.repository

import com.murtazin.vkapp.presentation.screen.profileView.feed.BaseMessage

interface PostRepository {

    fun getAll(): List<BaseMessage>

    fun getPost(id: Long): BaseMessage
}