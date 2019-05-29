package com.murtazin.vkapp.presentation.screen.profileView.feed


import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murtazin.vkapp.presentation.model.Item
import com.murtazin.vkapp.presentation.model.Post
import com.murtazin.vkapp.presentation.model.Profile

class FeedAdapter(private val loadPostsPage: () -> Unit,
                  private val openEditView: () -> Unit

) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val PROFILE = 1
        const val POST = 2
    }

    private val items: MutableList<Item> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when(viewType){
            PROFILE -> { ProfileHolder.createInstance(parent) }
            POST -> PostHolder.createInstance(parent)
            else -> throw IllegalArgumentException("viewType $viewType not found")
        }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is Post -> POST
        is Profile -> PROFILE
        else -> throw IllegalArgumentException("${items[position].javaClass} not found")
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (items.size - position == 5) {
            loadPostsPage()
        }
        when (holder) {
            is PostHolder -> holder.bind(items[position] as Post)
            is ProfileHolder -> {
                holder.bind(items[position] as Profile)
                holder.initEditBtn(openEditView)
            }
        }
    }


    fun setProfile(profile: Profile, onFirstAttach: () -> Unit) {
        if (items.isNotEmpty() && items[0] is Profile) {
            items[0] = profile
            notifyItemChanged(0)
        } else {
            items.add(0, profile)
            notifyItemInserted(0)
            onFirstAttach()
        }
    }

    fun setPosts(posts: List<Item>) {
        var profile: Item? = null
        if (items.isNotEmpty() && items[0] is Profile) {
            profile = items[0]
        }
        items.clear()
        profile?.let { items.add(it) }
        items.addAll(posts)

        notifyDataSetChanged()
    }




}

