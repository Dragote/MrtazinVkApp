package com.gmail.intellect.logos.vkapp.fragment.profileEdit

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.inputmethod.EditorInfo
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.PresenterType
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.gmail.intellect.logos.vkapp.R
import com.gmail.intellect.logos.vkapp.fragment.BaseFragment
import com.gmail.intellect.logos.vkapp.fragment.profileView.ProfileViewPresenter
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profile_edit.*
import kotlinx.android.synthetic.main.fragment_profile_view.*

class ProfileEditFragment : BaseFragment(R.layout.fragment_profile_edit),ProfileEdit {


    @InjectPresenter
    internal lateinit var presenter: ProfileEditPresenter

    @ProvidePresenter
    fun providePresenter(): ProfileEditPresenter {
        return ProfileEditPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolBar()
    }

    override fun showProfileInfo(  firstName: String,
                                   lastName: String,
                                   status: String,
                                   birthday: String,
                                   sex: String,
                                   city: String,
                                   country: String,
                                   education: String) {
        profileEdit_firstNameEdit.text = firstName.toEditable()
        profileEdit_lastNameEdit.text = lastName.toEditable()
        profileEdit_statusEdit.text = status.toEditable()
        profileEdit_birthdayEdit.text = birthday.toEditable()
        profileEdit_sexEdit.text = sex.toEditable()
        profileEdit_cityEdit.text = city.toEditable()
        profileEdit_countyEdit.text = country.toEditable()
        profileEdit_educationEdit.text = education.toEditable()
    }

    private fun initToolBar(){
        profileEditToolbar.inflateMenu(R.menu.menu_profile_edit)
        profileEditToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_save_edit -> {
                    profileEdit_firstNameEdit.onEditorAction(EditorInfo.IME_ACTION_DONE)

                    presenter.saveEdit(
                        profileEdit_firstNameEdit.text.toString(),
                        profileEdit_lastNameEdit.text.toString(),
                        profileEdit_statusEdit.text.toString(),
                        profileEdit_birthdayEdit.text.toString(),
                        profileEdit_sexEdit.text.toString(),
                        profileEdit_cityEdit.text.toString(),
                        profileEdit_countyEdit.text.toString(),
                        profileEdit_educationEdit.text.toString())

                        Snackbar.make(activity?.findViewById(android.R.id.content)!!,
                        resources.getString(R.string.save_done),
                        Snackbar.LENGTH_LONG)
                        .show()

                }
                R.id.action_cancel_edit -> {
                    profileEdit_firstNameEdit.onEditorAction(EditorInfo.IME_ACTION_DONE)
                    presenter.cancelEdit()}
            }
            true
        }
    }

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)


}