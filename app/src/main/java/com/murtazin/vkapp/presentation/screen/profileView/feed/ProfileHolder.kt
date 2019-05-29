package com.murtazin.vkapp.presentation.screen.profileView.feed

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murtazin.vkapp.R
import com.murtazin.vkapp.presentation.common.loadImage
import com.murtazin.vkapp.presentation.model.Profile
import kotlinx.android.synthetic.main.item_profile.view.*


class ProfileHolder(view: View): RecyclerView.ViewHolder(view){

    companion object {
        fun createInstance(parent: ViewGroup) = ProfileHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_profile,
                parent,
                false
            )
        )
    }


    @SuppressLint("SetTextI18n")
    fun bind(profile: Profile){
        itemView.profileView_name.text = "${profile.firstName} ${profile.lastName}"
        itemView.profileView_status.text = profile.status
        itemView.profileView_birthday.text = profile.birthday
        itemView.profileView_city.text = profile.city
        itemView.profileView_phone.text = profile.phone
        itemView. profileView_avatar.loadImage(profile.avatarUrl)


    }

    fun initEditBtn(openEditView: () -> Unit){
        itemView.profileView_editProfileBtn.setOnClickListener {
             openEditView()
        }
    }



}