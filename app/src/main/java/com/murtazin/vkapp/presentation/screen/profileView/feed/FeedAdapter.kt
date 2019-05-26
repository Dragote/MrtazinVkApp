package com.murtazin.vkapp.presentation.screen.profileView.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murtazin.vkapp.R
import com.murtazin.vkapp.domain.entity.PostEntity
import com.murtazin.vkapp.presentation.common.loadImage
import kotlinx.android.synthetic.main.item_post_message.view.*
import java.lang.IllegalArgumentException

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val POST_MESSAGE = 1
    }

    private val items: MutableList<PostEntity> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        POST_MESSAGE -> PostMessageHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_post_message,
                parent,
                false
            )
        )
        else -> throw IllegalArgumentException("viewType $viewType not found")
    }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is PostEntity -> POST_MESSAGE
        else -> throw IllegalArgumentException("${items[position].javaClass} not found")
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostMessageHolder -> holder.bind(items[position] as PostEntity)
        }
    }

    fun setItems(items: List<PostEntity>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }

    inner class PostMessageHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: PostEntity) {
            itemView.profile_image.loadImage(data.avatarUrl)
            itemView.item_profileName.text = data.profileName
            itemView.item_postDate.text = data.date
            itemView.item_likes.text = data.likes.toString()

            if (data.message.isNotEmpty()) {
                itemView.itemPostMessage.text = data.message
                itemView.itemPostMessage.visibility = View.VISIBLE
            }

            if (data.image.isNotEmpty()) {
                itemView.itemPostImage.loadImage(data.image)
                itemView.itemPostImage.visibility = View.VISIBLE
            }

            if (data.musicAuthor.isNotEmpty() && data.musicSongName.isNotEmpty()) {
                itemView.itemPostMusic.visibility = View.VISIBLE
                itemView.item_musicAudioAuthor.text = data.musicAuthor
                itemView.item_musicAudioName.text = data.musicSongName
            }
            if (data.video.isNotEmpty()) {
                itemView.item_video.visibility = View.VISIBLE

            }

        }
    }
}

