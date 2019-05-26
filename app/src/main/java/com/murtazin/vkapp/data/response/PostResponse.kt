package com.murtazin.vkapp.data.response

import com.google.gson.annotations.SerializedName

class PostsResponse(
    @SerializedName("posts") val posts: List<Post>
)

class Post(
    @SerializedName("id") val postId: Long,
    @SerializedName("profileName") val profileName: String,
    @SerializedName("message") val message: String,
    @SerializedName("content") val content: List<Content>,
    @SerializedName("likes") val likes: Int,
    @SerializedName("date") val date: String,
    @SerializedName("avatarUrl") val avatarUrl: String
)

open class Content(
    @SerializedName("type") val type: String,
    @SerializedName("url") val url: String
) {
    companion object {
        const val PHOTO = "photo"
        const val AUDIO = "audio"
        const val VIDEO = "video"
    }
}
class Audio(type: String = PHOTO,
            url: String,
            @SerializedName("author") val author: String,
            @SerializedName("songName") val songName: String
) : Content(type, url)

class Video(type: String = VIDEO, url: String) : Content(type, url)
class Photo(type: String = PHOTO, url: String) : Content(type, url)