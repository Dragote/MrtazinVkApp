package com.murtazin.vkapp.fragment.logIn

import android.os.Bundle
import android.text.Editable
import android.view.View
import android.view.inputmethod.EditorInfo
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.murtazin.vkapp.R
import com.murtazin.vkapp.fragment.BaseFragment
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

    override fun initLogInScreen(login: String, password: String) {
        logIn_loginEdit.text = login.toEditable()
        logIn_passwordEdit.text = password.toEditable()
    }

    override fun showLogInError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showNetworkError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    private fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)
}





