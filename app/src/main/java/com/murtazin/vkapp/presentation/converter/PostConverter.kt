package com.murtazin.vkapp.presentation.converter

import com.murtazin.vkapp.domain.entity.PostEntity
import com.murtazin.vkapp.presentation.model.*
import java.lang.Exception
import javax.inject.Inject

class PostConverter @Inject constructor() :
    Converter<@JvmSuppressWildcards List<@JvmSuppressWildcards PostEntity>, @JvmSuppressWildcards List<@JvmSuppressWildcards Post>> {

    override fun convert(t: List<PostEntity>): List<Post> = t.map {
        Post(
            it.id,
            it.profileName,
            it.message,
            it.content.map {content ->
                when (content) {
                    is PostEntity.Audio -> Audio(
                       content.type,
                        content.url,
                        content.author,
                        content.songName
                    )
                    is PostEntity.Video -> Video(
                        content.type,
                        content.url
                    )
                    is PostEntity.Photo -> Photo(
                        content.type,
                        content.url
                    )
                    else -> Content(
                        content.type,
                        content.url
                    )
                }
            },
            it.likes,
            it.date,
            it.avatarUrl
        )
    }

}