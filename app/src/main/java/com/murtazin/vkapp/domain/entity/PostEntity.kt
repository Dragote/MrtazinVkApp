package com.murtazin.vkapp.domain.entity

data class PostEntity(
    val id: Long,
    val profileName: String,
    val message: String,
    val content: List<Content>,
    val likes: Int,
    val date: String,
    val avatarUrl: String
) {
    open class Content(
        val type: String,
        val url: String
    ) companion object {
        const val PHOTO = "photo"
        const val AUDIO = "audio"
        const val VIDEO = "video"
    }
    class Audio(type: String = AUDIO,
                url: String,
                val author: String,
                val songName: String
    ) : Content(type, url)

    class Video(type: String = VIDEO, url: String) : Content(type, url)
    class Photo(type: String = PHOTO, url: String) : Content(type, url)
}


