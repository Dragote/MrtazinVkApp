package com.murtazin.vkapp.presentation.screen.profileView

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.murtazin.vkapp.R
import com.murtazin.vkapp.domain.entity.PostEntity
import com.murtazin.vkapp.presentation.common.BaseFragment
import com.murtazin.vkapp.presentation.common.loadImage
import com.murtazin.vkapp.presentation.model.Profile
import com.murtazin.vkapp.presentation.screen.profileView.feed.FeedAdapter
import kotlinx.android.synthetic.main.fragment_profile_view.*
import javax.inject.Inject

class ProfileViewFragment : BaseFragment(R.layout.fragment_profile_view),
    ProfileView {

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfileViewPresenter

    @ProvidePresenter
    fun providePresenter(): ProfileViewPresenter = presenter

    private val feedAdapter = FeedAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initBtns()
        initFeed()

    }

    private fun initFeed() {
        profileViewFeed.isNestedScrollingEnabled = false
        profileViewFeed.layoutManager = LinearLayoutManager(context)
        profileViewFeed.adapter = feedAdapter
    }

    override fun showFeed(items: List<PostEntity>) {
        feedAdapter.setItems(items)
    }

    @SuppressLint("SetTextI18n")
    override fun showProfile(profile: Profile) {
        profileView_name.text = "${profile.firstName} ${profile.lastName}"
        profileView_status.text = profile.status
        profileView_birthday.text = profile.birthday
        profileView_sex.text = profile.sex
        profileView_city.text = profile.city
        profileView_country.text = profile.country
        profileView_education.text = profile.education
        profileView_avatar.loadImage(profile.avatarUrl)
    }

    private fun initBtns() {
        profileView_editProfileBtn.setOnClickListener {
            presenter.edit()
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

}