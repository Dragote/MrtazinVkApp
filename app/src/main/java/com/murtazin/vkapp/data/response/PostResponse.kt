package com.murtazin.vkapp.data.response

import com.google.gson.annotations.SerializedName

class PostResponse (
    @SerializedName("id") val id: Long,
    @SerializedName("profileName") val profileName: String,
    @SerializedName("message") val message: String,
    @SerializedName("image") val image: String,
    @SerializedName("videoid") val video: String,
    @SerializedName("musicSongName" )val musicSongName: String,
    @SerializedName("musicAuthor") val musicAuthor: String,
    @SerializedName("likes") val likes: Int,
    @SerializedName("date") val date: String,
    @SerializedName("avatarUrl") val avatarUrl: String
)