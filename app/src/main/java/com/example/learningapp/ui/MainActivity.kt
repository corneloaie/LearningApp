package com.example.learningapp.ui

import androidx.activity.viewModels
import com.example.learningapp.R
import com.example.learningapp.base.view.activity.BaseActivity
import com.example.learningapp.databinding.ActivityMainBinding
import com.example.learningapp.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {
    override val layoutId: Int = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()
}