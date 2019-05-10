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
import com.gmail.intellect.logos.vkapp.moxy.Repository
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
    override fun showProfile(repository: Repository) {
        profileView_name.text = "${repository.firstName} ${repository.lastName}"
        profileView_status.text = repository.status
        profileView_birthday.text = repository.birthday
        profileView_sex.text = repository.sex
        profileView_city.text = repository.city
        profileView_country.text = repository.country
        profileView_education.text = repository.education
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