package com.gmail.intellect.logos.vkapp.fragment.profileEdit

import android.text.Editable
import com.arellomobile.mvp.MvpView
import java.util.*

interface ProfileEdit : MvpView {
    fun showProfileInfo(firstName: String,
                        lastName: String,
                        status: String,
                        birthday: String,
                        sex: String,
                        city: String,
                        country: String,
                        education: String)

}