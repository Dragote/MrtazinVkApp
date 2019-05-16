package com.murtazin.vkapp.presentation.screen.profileEdit

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.inputmethod.EditorInfo
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.murtazin.vkapp.R
import com.murtazin.vkapp.presentation.common.BaseFragment
import com.murtazin.vkapp.data.Repository
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_profile_edit.*

class ProfileEditFragment : BaseFragment(R.layout.fragment_profile_edit),
    ProfileEdit {

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

    override fun showProfileInfo( repository : Repository) {
        profileEdit_firstNameEdit.text = repository.firstName.toEditable()
        profileEdit_lastNameEdit.text = repository.lastName.toEditable()
        profileEdit_statusEdit.text = repository.status.toEditable()
        profileEdit_birthdayEdit.text = repository.birthday.toEditable()
        profileEdit_sexEdit.text = repository.sex.toEditable()
        profileEdit_cityEdit.text = repository.city.toEditable()
        profileEdit_countyEdit.text = repository.country.toEditable()
        profileEdit_educationEdit.text = repository.education.toEditable()
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

    override fun showNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)


}