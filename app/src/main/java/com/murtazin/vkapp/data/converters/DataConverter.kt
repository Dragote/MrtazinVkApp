package com.murtazin.vkapp.data.converters

interface DataConverter<T, K> {

    fun convertTo(t: T): K

    fun convertFrom(k: K): T

}