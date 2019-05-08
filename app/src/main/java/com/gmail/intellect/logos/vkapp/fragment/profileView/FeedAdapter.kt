package com.gmail.intellect.logos.vkapp.fragment.profileView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.gmail.intellect.logos.vkapp.R
import com.gmail.intellect.logos.vkapp.common.loadImage
import kotlinx.android.synthetic.main.item_post_message.view.*
import java.lang.IllegalArgumentException

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val POST_MESSAGE = 1
        const val CAT_MESSAGE = 2
    }

    private val items: MutableList<BaseMessage> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        POST_MESSAGE -> PostMessageHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_post_message,
                parent,
                false
            )
        )

        CAT_MESSAGE -> CatHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_cat_message,
                parent,
                false
            )
        )

        else -> throw IllegalArgumentException("viewType $viewType not found") as Throwable
    }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is PostMessage -> POST_MESSAGE
        is CatMessage -> CAT_MESSAGE
        else -> throw IllegalArgumentException("${items[position].javaClass} not found")
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostMessageHolder -> holder.bind(items[position] as PostMessage)
            is CatHolder -> holder.bind(items[position] as CatMessage)
        }
    }

    fun setItems(items: List<BaseMessage>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }

    inner class PostMessageHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: PostMessage) {
            itemView.itemPostMessage.text = data.message

            if (data.image.isNotEmpty()) {
                itemView.itemPostImage.loadImage(data.image)
            }
        }
    }

    inner class CatHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: CatMessage) {
            (itemView as ImageView).loadImage(data.image)
        }
    }
}