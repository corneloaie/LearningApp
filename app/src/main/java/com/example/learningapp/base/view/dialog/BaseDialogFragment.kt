package com.example.learningapp.base.view.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.DialogFragment
import com.example.learningapp.base.common.autoCleared
import com.example.learningapp.base.view.fragment.fragmentCreateAndSetupBinding
import com.example.learningapp.base.viewmodel.BaseViewModel

abstract class BaseDialogFragment<VM : BaseViewModel, B : ViewDataBinding> : DialogFragment() {

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

        _binding = fragmentCreateAndSetupBinding(viewModel, container, layoutInflater, layoutId)

        return _binding.root
    }
}