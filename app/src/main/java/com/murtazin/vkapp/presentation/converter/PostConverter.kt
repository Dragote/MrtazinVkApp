package com.murtazin.vkapp.presentation.converter

import com.murtazin.vkapp.domain.entity.PostEntity
import com.murtazin.vkapp.presentation.model.*
import java.lang.Exception
import javax.inject.Inject

class PostConverter @Inject constructor() : Converter<PostEntity, Post> {

    override fun convert(t: PostEntity): Post = Post(
        t.id,
        t.profileName,
        t.message,
        t.content.map {
           when(it){
               is PostEntity.Audio -> Audio(
                   it.type,
                   it.url,
                   it.author,
                   it.songName
               )
               is PostEntity.Video -> Video(
                   it.type,
                   it.url
               )
               is PostEntity.Photo -> Photo(
                   it.type,
                   it.url
               )
               else -> Content(
                   it.type,
                   it.url
               )
           }
        },
        t.likes,
        t.date,
        t.avatarUrl
    )
}