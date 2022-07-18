package com.example.learningapp.base.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.example.learningapp.BR
import com.example.learningapp.base.common.autoCleared
import com.example.learningapp.base.viewmodel.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel, B : ViewDataBinding> : Fragment() {

    abstract val layoutId: Int
    abstract val viewModel: VM
    private var _binding: B by autoCleared()

    val binding: B
        get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        _binding = fragmentCreateAndSetupBinding(
            viewModel, container, inflater, layoutId,
            createDataBindingComponent()
        )

        return _binding.root
    }

    open fun createDataBindingComponent(): DataBindingComponent? {
        return null
    }
}

fun <VM : BaseViewModel, B : ViewDataBinding> Fragment.fragmentCreateAndSetupBinding(
    viewModel: VM,
    container: ViewGroup?,
    layoutInflater: LayoutInflater,
    layoutId: Int,
    dataBindingComponent: DataBindingComponent? = null
): B {
    val binding: B = DataBindingUtil.inflate(
        layoutInflater,
        layoutId,
        container,
        false,
        dataBindingComponent
    )



    binding.setVariable(BR.viewModel, viewModel)

    binding.lifecycleOwner = this
    binding.executePendingBindings()

    return binding
}