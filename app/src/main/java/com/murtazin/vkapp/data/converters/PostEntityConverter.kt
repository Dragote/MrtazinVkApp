package com.murtazin.vkapp.data.converters


import com.murtazin.vkapp.data.response.PostsResponse
import com.murtazin.vkapp.domain.entity.PostEntity
import com.murtazin.vkapp.presentation.model.Post

class PostEntityConverter: DataConverter<@JvmSuppressWildcards PostsResponse, List<PostEntity>> {

    override fun convert(t: PostsResponse): List<PostEntity> =
            t.posts.map {
                PostEntity(
                    it.postId,
                    it.profileName,
                    it.message,
                    it.content.map{ contentResponse ->
                        PostEntity.Content(
                            contentResponse.type,
                            contentResponse.url
                        )
                    },
                    it.likes,
                    it.date,
                    it.avatarUrl
                )
            }
}

