package com.murtazin.vkapp.presentation.screen.profileView.feed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murtazin.vkapp.R
import com.murtazin.vkapp.presentation.model.Post
import com.murtazin.vkapp.presentation.common.loadImage
import kotlinx.android.synthetic.main.item_wall.view.*
import java.lang.IllegalArgumentException

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<Post> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        PostHolder.createInstance(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is PostHolder -> holder.bind(items[position])
        }
    }

    fun setItems(items: List<Post>) {
        this.items.clear()
        this.items.addAll(items)

        notifyDataSetChanged()
    }


}

