package com.gmail.intellect.logos.vkapp.fragment.logIn

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
import kotlinx.android.synthetic.main.fragment_log_in.*

class LogInFragment : BaseFragment(R.layout.fragment_log_in), LogIn {

    @InjectPresenter
    internal lateinit var presenter: LogInPresenter

    @ProvidePresenter
    fun providePresenter(): LogInPresenter {
        return LogInPresenter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLogInScreen()
    }

    private fun initLogInScreen() {
        logIn_logInBtn.setOnClickListener {
            logIn_passwordEdit.onEditorAction(EditorInfo.IME_ACTION_DONE)
            presenter.logIn()
        }
    }

    override fun showLogInScreen(login: String, password: String) {
        logIn_loginEdit.text = login.toEditable()
        logIn_passwordEdit.text = password.toEditable()
    }

    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
}





