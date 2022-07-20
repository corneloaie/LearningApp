package com.example.learningapp.ui.main

import androidx.fragment.app.activityViewModels
import com.example.learningapp.R
import com.example.learningapp.base.view.fragment.BaseFragment
import com.example.learningapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<MainViewModel, ActivityMainBinding>() {
    override val layoutId: Int = R.layout.activity_main
    override val viewModel: MainViewModel by activityViewModels()
}