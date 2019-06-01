package com.murtazin.vkapp.presentation.extensions

import android.text.Editable
import android.view.View
import androidx.appcompat.app.AlertDialog

fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)

fun View.showAlertOkDialog(title: String, message: String) {
    AlertDialog.Builder(context)
        .setTitle(title)
        .setMessage(message)
        .setNeutralButton("OK"){_,_ -> }
        .create()
        .show()
}