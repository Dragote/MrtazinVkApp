package com.murtazin.vkapp.data.network

import com.murtazin.vkapp.data.response.*
import io.reactivex.Single
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ApiMock @Inject constructor() : Api {


    override fun login(phone: String, password: String): Single<ProfileResponse> =
        if (phone == "88005553535" && password == "password") {
            val profile =  ProfileResponse(
                48392502,
                "Эмиль",
                "Муртазин",
                "Vallar Morghulis",
                "14.07.98",
                "Томск",
                "89138117651",
                "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg")

            Single.just(profile)
        } else {
            Single.error(RuntimeException("User not found"))
        }
            .delay(2, TimeUnit.SECONDS)

    override fun getPosts(profileId: Long, page: Int): Single<PostsResponse> =
        Single.just(
            PostsResponse((1L..5L).map {
                listOf(
                    Post(
                        it,
                        "Эмиль Муртазин",
                        "It's just only message post",
                        listOf(
                            Photo(
                                "photo",
                                "https://static-eu.insales.ru/images/products/1/6056/125573032/znak-po-lestnitse-vniz-napravo.png"
                            )

                        ),
                        25,
                        "14.07.2019",
                        "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg"
                    ),
                    Post(
                        it,
                        "Эмиль Муртазин",
                        "It's just only message post",
                        listOf(
                            Audio(
                                "audio",
                                "",
                                "Alt-J",
                                "In clod blood"
                            ),
                            Photo(
                                "photo",
                                "https://static-eu.insales.ru/images/products/1/6273/125573249/znak-po-lestnitse-vniz-nalevo.png"
                            )

                        ),
                        17,
                        "14.07.2019",
                        "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg"
                    )
                )
            }.flatten())
        ).delay(2, TimeUnit.SECONDS)


    override fun getProfile(userId: Long): Single<ProfileResponse> =
        Single.just(
            ProfileResponse(
               48392502,
                "Эмиль",
                "Муртазин",
                "Vallar Morghulis",
                "14.07.98",
                "Томск",
                "89138117651",
                "https://pp.userapi.com/c824602/v824602809/f7624/95vngsg5onM.jpg"
            )
        )
            .delay(1, TimeUnit.SECONDS)


}