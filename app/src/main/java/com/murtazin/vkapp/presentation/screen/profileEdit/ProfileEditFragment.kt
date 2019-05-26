package com.murtazin.vkapp.presentation.screen.profileEdit

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.murtazin.vkapp.R
import com.murtazin.vkapp.presentation.common.BaseFragment
import com.google.android.material.snackbar.Snackbar
import com.murtazin.vkapp.presentation.extensions.toEditable
import com.murtazin.vkapp.presentation.model.Profile
import kotlinx.android.synthetic.main.fragment_profile_edit.*
import javax.inject.Inject

class ProfileEditFragment : BaseFragment(R.layout.fragment_profile_edit),
    ProfileEdit {

    @Inject
    @InjectPresenter
    lateinit var presenter: ProfileEditPresenter

    @ProvidePresenter
    fun providePresenter(): ProfileEditPresenter = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolBar()
    }

    override fun showProfileInfo(profile : Profile) {
        profileEdit_firstNameEdit.text = profile.firstName.toEditable()
        profileEdit_lastNameEdit.text = profile.lastName.toEditable()
        profileEdit_statusEdit.text = profile.status.toEditable()
        profileEdit_birthdayEdit.text = profile.birthday.toEditable()
        profileEdit_sexEdit.text = profile.sex.toEditable()
        profileEdit_cityEdit.text = profile.city.toEditable()
        profileEdit_countyEdit.text = profile.country.toEditable()
        profileEdit_educationEdit.text = profile.education.toEditable()
    }

    private fun initToolBar() {
        profileEditToolbar.inflateMenu(R.menu.menu_profile_edit)
        profileEditToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_save_edit -> {
                    profileEdit_firstNameEdit.onEditorAction(EditorInfo.IME_ACTION_DONE)

                    presenter.saveEdit()
                    showSavedSuccSnackbar()
                }
                R.id.action_cancel_edit -> {
                    profileEdit_firstNameEdit.onEditorAction(EditorInfo.IME_ACTION_DONE)
                    presenter.cancelEdit()
                }
            }
            true
        }
    }

    override fun showNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun showSavedSuccSnackbar(){
        Snackbar.make(
            activity?.findViewById(android.R.id.content)!!,
            resources.getString(R.string.save_done),
            Snackbar.LENGTH_LONG
        )
            .show()
    }
}