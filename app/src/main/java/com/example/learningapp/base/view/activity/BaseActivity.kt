package com.example.learningapp.base.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.learningapp.BR
import com.example.learningapp.base.viewmodel.BaseViewModel

abstract class BaseActivity<VM : BaseViewModel, B : ViewDataBinding> : AppCompatActivity() {

    abstract val layoutId: Int
    abstract val viewModel: VM
    private lateinit var _binding: B

    val binding: B
        get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = DataBindingUtil.setContentView(this, layoutId)
        _binding.setVariable(BR.viewModel, viewModel)
        _binding.lifecycleOwner = this
        _binding.executePendingBindings()
    }
}
