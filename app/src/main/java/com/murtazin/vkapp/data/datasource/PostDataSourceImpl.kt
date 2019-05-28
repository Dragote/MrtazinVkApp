package com.murtazin.vkapp.data.datasource

import com.murtazin.vkapp.data.datasource.interfaces.PostDataSource
import com.murtazin.vkapp.data.network.Api
import com.murtazin.vkapp.data.response.Audio
import com.murtazin.vkapp.data.response.Photo
import com.murtazin.vkapp.data.response.Post
import com.murtazin.vkapp.data.response.PostsResponse
import io.reactivex.Single
import javax.inject.Inject

class PostDataSourceImpl @Inject constructor(private val api: Api): PostDataSource {

    override fun getPosts(userId: Long, page: Int): Single<PostsResponse> = Single.just(
        PostsResponse(
            listOf(
                Post(
                    0,
                    "Эмиль Муртазин",
                    "It's just only message post",
                    listOf(
                        Photo(
                            "photo",
                            "https://vk.com/images/camera_200.png?ava=1?ava=1"
                        )

                    ),
                    25,
                    "14.07.2019",
                    "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg"
                ),
                Post(
                    0,
                    "Эмиль Муртазин",
                    "It's just only message post",
                    listOf(
                        Audio(
                            "audio",
                            "",
                            "Alt-J",
                            "In clod blood"
                        )

                    ),
                    25,
                    "14.07.2019",
                    "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg"
                )
            )
        )
    )
}