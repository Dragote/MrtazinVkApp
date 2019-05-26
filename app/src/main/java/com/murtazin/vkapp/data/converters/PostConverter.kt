package com.murtazin.vkapp.data.converters

import com.murtazin.vkapp.data.response.PostResponse
import com.murtazin.vkapp.domain.entity.PostEntity

class PostConverter: DataConverter<PostResponse, PostEntity> {
    override fun convertTo(t: PostResponse): PostEntity = PostEntity(
        t.id,
        t.profileName,
        t.message,
        t.image,
        t.video,
        t.musicSongName,
        t.musicAuthor,
        t.likes,
        t.date,
        t.avatarUrl
    )

    override fun convertFrom(k: PostEntity): PostResponse = PostResponse(
        k.id,
        k.profileName,
        k.message,
        k.image,
        k.video,
        k.musicSongName,
        k.musicAuthor,
        k.likes,
        k.date,
        k.avatarUrl
    )
}