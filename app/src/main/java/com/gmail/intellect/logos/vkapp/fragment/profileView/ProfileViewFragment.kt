package com.gmail.intellect.logos.vkapp.fragment.profileView

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.gmail.intellect.logos.vkapp.R
import com.gmail.intellect.logos.vkapp.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_profile_view.*


class ProfileViewFragment : BaseFragment(R.layout.fragment_profile_view),
    ProfileView {


    @InjectPresenter
    lateinit var presenter: ProfileViewPresenter

    private val feedAdapter = FeedAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initFeed()
        initBtns()
    }

    private fun initFeed() {

        profileViewFeed.isNestedScrollingEnabled = false
        profileViewFeed.layoutManager = LinearLayoutManager(context)
        profileViewFeed.adapter = feedAdapter
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

    override fun showFeed(items: List<BaseMessage>) {
        feedAdapter.setItems(items)
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