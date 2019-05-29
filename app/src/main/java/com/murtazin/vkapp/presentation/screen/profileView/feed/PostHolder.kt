package com.murtazin.vkapp.presentation.screen.profileView.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murtazin.vkapp.R
import com.murtazin.vkapp.presentation.common.loadImage
import com.murtazin.vkapp.presentation.model.Audio
import com.murtazin.vkapp.presentation.model.Content
import com.murtazin.vkapp.presentation.model.Post
import com.murtazin.vkapp.presentation.model.Video
import kotlinx.android.synthetic.main.item_feed.view.*

class PostHolder(view: View) : RecyclerView.ViewHolder(view) {

    companion object {
        fun createInstance(parent: ViewGroup) = PostHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_feed,
                parent,
                false
            )
        )
    }

    fun bind(data: Post) {

        hideContent()

        itemView.profile_image.loadImage(data.avatarUrl)
        itemView.item_profileName.text = data.profileName
        itemView.item_postDate.text = data.date
        itemView.item_likes.text = data.likes.toString()

        if (data.message.isNotEmpty()) {
            itemView.itemPostMessage.text = data.message
            itemView.itemPostMessage.visibility = View.VISIBLE
        }

        data.content.forEach {

            when(it.type){
                Content.PHOTO -> {
                    itemView.itemPostImage.loadImage(it.url)
                    itemView.itemPostImage.visibility = View.VISIBLE
                }
                Content.AUDIO -> {
                    itemView.itemPostMusic.visibility = View.VISIBLE
                    it as Audio
                    itemView.item_musicAudioAuthor.text = it.author
                    itemView.item_musicAudioName.text = it.songName
                }
                Content.VIDEO -> {
                    it as Video
                    itemView.itemPostVideo.visibility = View.VISIBLE
                }

            }

    }

    }

    private fun hideContent(){
        itemView.itemPostImage.visibility = View.GONE
        itemView.itemPostMusic.visibility = View.GONE
        itemView.itemPostMessage.visibility = View.GONE
        itemView.itemPostVideo.visibility = View.GONE
    }
}