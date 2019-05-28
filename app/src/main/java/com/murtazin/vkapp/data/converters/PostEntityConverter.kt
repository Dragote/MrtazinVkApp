package com.murtazin.vkapp.data.converters


import com.murtazin.vkapp.data.response.Audio
import com.murtazin.vkapp.data.response.Photo
import com.murtazin.vkapp.data.response.PostsResponse
import com.murtazin.vkapp.data.response.Video
import com.murtazin.vkapp.domain.entity.PostEntity
import com.murtazin.vkapp.presentation.model.Post
import javax.inject.Inject

class PostEntityConverter @Inject constructor() :
    DataConverter<@JvmSuppressWildcards PostsResponse,@JvmSuppressWildcards List<@JvmSuppressWildcards PostEntity>> {

    override fun convert(t: PostsResponse): List<PostEntity> =
        t.posts.map {
            PostEntity(
                it.postId,
                it.profileName,
                it.message,
                it.content.map { contentResponse ->

                    when (contentResponse) {
                        is Audio -> PostEntity.Audio(
                            contentResponse.type,
                            contentResponse.url,
                            contentResponse.author,
                            contentResponse.songName
                        )

                        is Video -> PostEntity.Video(
                            contentResponse.type,
                            contentResponse.url
                        )

                        is Photo -> PostEntity.Photo(
                            contentResponse.type,
                            contentResponse.url
                        )
                        else -> PostEntity.Content(
                            contentResponse.type,
                            contentResponse.url
                        )
                    }
                },
                it.likes,
                it.date,
                it.avatarUrl
            )
        }
}

