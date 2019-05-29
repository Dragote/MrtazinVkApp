package com.murtazin.vkapp.presentation.model

class Post(
    id: Long,
    val profileName: String,
    val message: String,
    val content: List<Content>,
    val likes: Int,
    val date: String,
    val avatarUrl: String
): Item(id)