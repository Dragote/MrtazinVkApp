package com.murtazin.vkapp.presentation.screen.logIn

import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AlertDialog
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.murtazin.vkapp.R
import com.murtazin.vkapp.presentation.common.BaseFragment
import com.murtazin.vkapp.presentation.extensions.showAlertOkDialog
import com.murtazin.vkapp.presentation.extensions.toEditable
import kotlinx.android.synthetic.main.fragment_log_in.*
import javax.inject.Inject

class LogInFragment : BaseFragment(R.layout.fragment_log_in),
    LogIn {

    companion object {
        fun createInstance() = LogInFragment()
    }

    @Inject
    @InjectPresenter
    lateinit var presenter: LogInPresenter

    @ProvidePresenter
    fun providePresenter(): LogInPresenter = presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLogInScreen()
    }

    override fun initLogInScreen() {
        logIn_logInBtn.setOnClickListener {
            val email = logIn_loginEdit.text.toString()
            val password = logIn_passwordEdit.text.toString()
            logIn_passwordEdit.onEditorAction(EditorInfo.IME_ACTION_DONE)
            presenter.logIn(email, password)
        }
    }


    override fun showLogInError() {
          logIn_logInBtn.showAlertOkDialog(getString(R.string.error),getString(R.string.error_login_message))
    }

    override fun showNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }
}





