package com.murtazin.vkapp.presentation.model

class Audio(type: String = AUDIO,
            url: String,
            val author: String,
            val songName: String
) : Content(type, url)