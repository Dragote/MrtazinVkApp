package com.murtazin.vkapp.data.repository

import com.murtazin.vkapp.domain.repository.PostRepository
import com.murtazin.vkapp.domain.repository.ProfileRepository
import com.murtazin.vkapp.domain.entity.PostEntity
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val profileRepository: ProfileRepository): PostRepository {
    override fun getAll(): List<PostEntity> =
        listOf(
            PostEntity(
                0,
                "Эмиль Муртазин",
                "It's just only message post",
                "",
                "",
                "",
                "",
                43,
                "14 август 2018",
                "https://vk.com/images/camera_200.png?ava=1?ava=1"
            ),
            PostEntity(
                1,
                "Эмиль Муртазин",
                "",
                "https://picsum.photos/id/153/200/300",
                "",
                "",
                "",
                21,
                "14 август 2018",
                "https://vk.com/images/camera_200.png?ava=1?ava=1"
            ),
            PostEntity(
                2,
                "Эмиль Муртазин",
                "Music PostEntity",
                "",
                "",
                "In cold blood",
                "Alt-J",
                13,
                "14 август 2018",
                "https://vk.com/images/camera_200.png?ava=1?ava=1"
            ),
            PostEntity(
                3,
                "Эмиль Муртазин",
                "Picture and music post",
                "https://picsum.photos/id/167/200/300",
                "",
                "In cold blood",
                "Alt-J",
                96,
                "14 август 2018",
                "https://vk.com/images/camera_200.png?ava=1?ava=1"
            ),
            PostEntity(
                4,
                "Эмиль Муртазин",
                "Video post",
                "",
                "Video",
                "",
                "",
                43,
                "14 август 2018",
                "https://vk.com/images/camera_200.png?ava=1?ava=1"
            ),
            PostEntity(
                5,
                "Эмиль Муртазин",
                "Basic message",
                "https://picsum.photos/id/153/200/300",
                "Video",
                "In cold blood",
                "Alt-J",
                43,
                "14 август 2018",
                "https://vk.com/images/camera_200.png?ava=1?ava=1"
            )
        )


    override fun getPost(id: Long): PostEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}