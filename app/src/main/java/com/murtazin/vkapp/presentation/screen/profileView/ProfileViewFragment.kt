package com.murtazin.vkapp.presentation.screen.profileView

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.murtazin.vkapp.R
import com.murtazin.vkapp.presentation.model.Post
import com.murtazin.vkapp.presentation.common.BaseFragment
import com.murtazin.vkapp.presentation.model.Profile
import com.murtazin.vkapp.presentation.screen.profileView.feed.FeedAdapter
import kotlinx.android.synthetic.main.fragment_profile_view.*
import javax.inject.Inject

class ProfileViewFragment : BaseFragment(R.layout.fragment_profile_view),
    ProfileView {

    companion object {

        fun createInstance() = ProfileViewFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfileViewPresenter

    @ProvidePresenter
    fun providePresenter(): ProfileViewPresenter = presenter

    private val feedAdapter = FeedAdapter ({ presenter.loadPosts()},{presenter.edit()})

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initFeed()
        profileRefreshLayout.setOnRefreshListener(presenter::refreshPosts)
    }

    private fun initFeed() {
        profileViewFeed.isNestedScrollingEnabled = false
        profileViewFeed.layoutManager = LinearLayoutManager(context)
        profileViewFeed.adapter = feedAdapter
    }

    override fun showFeed(items: List<Post>) {
        feedAdapter.setPosts(items)
    }

    @SuppressLint("SetTextI18n")
    override fun showProfile(profile: Profile) {
        feedAdapter.setProfile(profile){
            profileViewFeed.smoothScrollToPosition(0)
        }

    }


    private fun initToolbar() {
        profileViewToolbar.inflateMenu(R.menu.menu_profile_view)
        profileViewToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_logout -> presenter.logout()
            }
            true
        }
    }

    override fun showNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        profileProgressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        profileRefreshLayout.isRefreshing = false
        profileProgressBar.visibility = View.GONE
    }

}
