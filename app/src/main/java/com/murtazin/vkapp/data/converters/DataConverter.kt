package com.murtazin.vkapp.data.converters

interface DataConverter<T, K> {

    fun convert(t: T): K


}