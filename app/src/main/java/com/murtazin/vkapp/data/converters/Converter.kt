package com.murtazin.vkapp.data.converters

interface Converter<T, K> {

    fun convertTo(t: T): K

    fun convertFrom(k: K): T

}