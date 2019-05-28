package com.murtazin.vkapp.data.datasource.interfaces

interface SessionDataSource {

    fun saveToken(token: String)

    fun clearToken()

    fun getToken(): String

}