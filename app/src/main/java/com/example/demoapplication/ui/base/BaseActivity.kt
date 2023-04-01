@file:Suppress("UNCHECKED_CAST")

package com.example.demoapplication.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import com.example.demoapplication.BuildConfig

abstract class BaseActivity<VB: ViewDataBinding> : AppCompatActivity() {
    private var _binding: ViewDataBinding? = null
    abstract val bindingInflater: (LayoutInflater) -> VB

    val binding: VB
    get() = _binding as VB

    abstract fun initView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = bindingInflater.invoke(layoutInflater)
        setContentView((_binding as VB).root)
        initView()
    }
}