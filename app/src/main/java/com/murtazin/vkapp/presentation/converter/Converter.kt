package com.murtazin.vkapp.presentation.converter

interface Converter<T,K>  {

    fun convert(t: T): K

}