package com.murtazin.vkapp.presentation.screen.profileView.feed


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murtazin.vkapp.presentation.model.Post

class FeedAdapter(private val loadPostsPage: () -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val items: MutableList<Post> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        PostHolder.createInstance(parent)

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (items.size - position == 5) {
            loadPostsPage()
        }
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

