package com.murtazin.vkapp.presentation.model

open class Content(
    val type: String,
    val url: String
) {
    companion object {
        const val PHOTO = "photo"
        const val AUDIO = "audio"
        const val VIDEO = "video"
    }
}