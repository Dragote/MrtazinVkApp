package com.gmail.intellect.logos.vkapp.fragment.profileEdit

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.gmail.intellect.logos.vkapp.App
import com.gmail.intellect.logos.vkapp.fragment.profileView.ProfileViewPresenter
import com.gmail.intellect.logos.vkapp.moxy.Repository
import com.gmail.intellect.logos.vkapp.moxy.Repository.birthday
import com.gmail.intellect.logos.vkapp.moxy.Repository.city
import com.gmail.intellect.logos.vkapp.moxy.Repository.country
import com.gmail.intellect.logos.vkapp.moxy.Repository.education
import com.gmail.intellect.logos.vkapp.moxy.Repository.firstName
import com.gmail.intellect.logos.vkapp.moxy.Repository.lastName
import com.gmail.intellect.logos.vkapp.moxy.Repository.sex
import com.gmail.intellect.logos.vkapp.moxy.Repository.status
import com.gmail.intellect.logos.vkapp.navigation.Screen
import com.google.android.material.snackbar.Snackbar
import com.gmail.intellect.logos.vkapp.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_profile_edit.*
import kotlinx.android.synthetic.main.fragment_profile_view.*

@InjectViewState
class ProfileEditPresenter : MvpPresenter<ProfileEdit>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProfileInfo(firstName, lastName, status, birthday, sex, city, country, education)
    }

    fun cancelEdit() {
        App.INCTANCE.router.newRootScreen(Screen.ProfileViewScreen())
    }

    fun saveEdit(
        firstName: String,
        lastName: String,
        status: String,
        birthday: String,
        sex: String,
        city: String,
        country: String,
        education: String
    ) {
        Repository.setData(firstName, lastName, status, birthday, sex, city, country, education)

        App.INCTANCE.router.navigateTo(Screen.ProfileViewScreen())


    }


}



