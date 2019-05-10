package com.gmail.intellect.logos.vkapp.fragment.profileView

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.arellomobile.mvp.presenter.ProvidePresenterTag
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.gmail.intellect.logos.vkapp.R
import com.gmail.intellect.logos.vkapp.fragment.BaseFragment
import com.gmail.intellect.logos.vkapp.fragment.profileView.feed.BaseMessage
import com.gmail.intellect.logos.vkapp.fragment.profileView.feed.FeedAdapter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_profile_view.*
import kotlinx.android.synthetic.main.item_post_message.*

class ProfileViewFragment : BaseFragment(R.layout.fragment_profile_view), ProfileView {



    @InjectPresenter
    internal lateinit var presenter: ProfileViewPresenter

    @ProvidePresenter
    fun providePresenter(): ProfileViewPresenter {
        return ProfileViewPresenter()
    }

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

    override fun showFeed(items: List<BaseMessage>) {
        feedAdapter.setItems(items)
    }

    @SuppressLint("SetTextI18n")
    override fun showProfile(
        firstName: String,
        lastName: String,
        status: String,
        birthday: String,
        sex: String,
        city: String,
        country: String,
        education: String
    ) {
        profileView_name.text = "$firstName $lastName"
        profileView_status.text = status
        profileView_birthday.text = birthday
        profileView_sex.text = sex
        profileView_city.text = city
        profileView_country.text = country
        profileView_education.text = education
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






}