package com.gmail.intellect.logos.vkapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.gmail.intellect.logos.vkapp.moxy.MvpAppCompatFragment

abstract class BaseFragment(@LayoutRes private val layoutId: Int) : MvpAppCompatFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(layoutId, container, false)

}