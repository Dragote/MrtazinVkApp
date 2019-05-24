package com.murtazin.vkapp.data.repository

import com.murtazin.vkapp.domain.repository.PostRepository
import com.murtazin.vkapp.domain.repository.ProfileRepository
import com.murtazin.vkapp.domain.entity.PostMessage
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(private val profileRepository: ProfileRepository): PostRepository {
    override fun getAll(): List<PostMessage> =
        listOf(
            PostMessage(
                0, "${profileRepository.getProfile().firstName} ${profileRepository.getProfile().lastName}",
                "It's just only message post",
                "",
                "",
                "",
                "",
                43,
                "14 август 2018",
                "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg?ava=1"
            ),
            PostMessage(
                1, "${profileRepository.getProfile().firstName} ${profileRepository.getProfile().lastName}",
                "",
                "https://picsum.photos/id/153/200/300",
                "",
                "",
                "",
                21,
                "14 август 2018",
                "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg?ava=1"
            ),
            PostMessage(
                2, "${profileRepository.getProfile().firstName} ${profileRepository.getProfile().lastName}",
                "Music Post",
                "",
                "",
                "In cold blood",
                "Alt-J",
                13,
                "14 август 2018",
                "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg?ava=1"
            ),
            PostMessage(
                3, "${profileRepository.getProfile().firstName} ${profileRepository.getProfile().lastName}",
                "Picture and music post",
                "https://picsum.photos/id/167/200/300",
                "",
                "In cold blood",
                "Alt-J",
                96,
                "14 август 2018",
                "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg?ava=1"
            ),
            PostMessage(
                4, "${profileRepository.getProfile().firstName} ${profileRepository.getProfile().lastName}",
                "Video post",
                "",
                "Video",
                "",
                "",
                43,
                "14 август 2018",
                "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg?ava=1"
            ),
            PostMessage(
                5, "${profileRepository.getProfile().firstName} ${profileRepository.getProfile().lastName}",
                "Basic message",
                "https://picsum.photos/id/153/200/300",
                "Video",
                "In cold blood",
                "Alt-J",
                43,
                "14 август 2018",
                "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg?ava=1"
            )
        )


    override fun getPost(id: Long): PostMessage {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}