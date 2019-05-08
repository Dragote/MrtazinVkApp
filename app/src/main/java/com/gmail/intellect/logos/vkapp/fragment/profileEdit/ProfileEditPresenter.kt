package com.gmail.intellect.logos.vkapp.fragment.profileEdit

import android.app.PendingIntent.getActivity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.gmail.intellect.logos.vkapp.App
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
import androidx.fragment.app.Fragment
import android.content.Context.INPUT_METHOD_SERVICE
import android.view.View
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.ContextCompat.getSystemService





@InjectViewState
class ProfileEditPresenter : MvpPresenter<ProfileEdit>(){

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showProfileInfo(firstName, lastName, status, birthday, sex, city, country, education)
    }

    fun cancelEdit(){
        App.INCTANCE.router.navigateTo(Screen.ProfileViewScreen())
    }
    fun saveEdit(firstName: String,
                 lastName: String,
                 status: String,
                 birthday: String,
                 sex: String,
                 city: String,
                 country: String,
                 education: String){
        Repository.setData(firstName, lastName, status, birthday, sex, city, country, education)



        App.INCTANCE.router.navigateTo(Screen.ProfileViewScreen())



    }


}



