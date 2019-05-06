package com.gmail.intellect.logos.vkapp.fragment.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.gmail.intellect.logos.vkapp.App
import com.gmail.intellect.logos.vkapp.R
import com.gmail.intellect.logos.vkapp.fragment.BaseFragment
import com.gmail.intellect.logos.vkapp.fragment.ProfileEditFragment
import com.gmail.intellect.logos.vkapp.navigation.Screen
import kotlinx.android.synthetic.main.fragment_profile_view.*


class ProfileViewFragment : BaseFragment(R.layout.fragment_profile_view), ProfileView {

    @InjectPresenter
    lateinit var presenter: ProfileViewPresenter

    private val feedAdapter = FeedAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar()
        initFeed()
    }

    private fun initFeed() {

        profileViewFeed.isNestedScrollingEnabled = false
        profileViewFeed.layoutManager = LinearLayoutManager(context)
        profileViewFeed.adapter = feedAdapter
    }

    override fun showProfile(firstName: String) {
        profileViewFirstName.text = firstName
//        TODO("Create all parameters")
    }

    override fun showFeed(items: List<BaseMessage>) {
        feedAdapter.setItems(items)
    }


    private fun initToolbar() {
        profileViewToolbar.inflateMenu(R.menu.menu_profile_view)
        profileViewToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_profile_edit -> {
//                    fTODO("Navigate to profile edit")

                    activity!!.supportFragmentManager.beginTransaction().replace(R.id.container, ProfileEditFragment())
                        .addToBackStack(ProfileEditFragment().toString())
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.action_logout -> presenter.logout()
            }

            true
        }
    }
}