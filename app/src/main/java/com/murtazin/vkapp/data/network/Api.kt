package com.murtazin.vkapp.data.network

import com.murtazin.vkapp.data.response.PostsResponse
import com.murtazin.vkapp.data.response.ProfileResponse
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface Api {

    @POST("login")
    fun login(@Field("phone") phone: String, @Field("password") password: String): Single<ProfileResponse>

    @GET("{profile_id}/posts/page/{page}")
    fun getPosts(@Path("profile_id") profileId: Long, @Path("page") page: Int): Single<PostsResponse>

    @GET("{user_id}/profile")
    fun getProfile(@Path("user_id") userId: Long): Single<ProfileResponse>

}