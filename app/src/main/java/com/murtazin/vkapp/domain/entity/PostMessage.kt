package com.murtazin.vkapp.domain.entity

class PostMessage(
    val id: Long,
    val profileName: String,
    val message: String,
    val image: String,
    val video: String,
    val musicSongName: String,
    val musicAuthor: String,
    val likes: Int,
    val date: String,
    val avatarUrl: String
)