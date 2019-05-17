package com.murtazin.vkapp.presentation.extensions

import android.text.Editable

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)