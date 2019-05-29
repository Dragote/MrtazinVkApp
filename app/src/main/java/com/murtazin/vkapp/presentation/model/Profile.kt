package com.murtazin.vkapp.presentation.model

class Profile (
    id: Long,
    val firstName: String,
    val lastName: String,
    val status: String,
    val birthday: String,
    val city: String,
    val phone: String,
    val avatarUrl: String
): Item(id)