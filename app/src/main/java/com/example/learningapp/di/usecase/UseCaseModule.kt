package com.example.learningapp.di.usecase

import com.example.learningapp.domain.usecase.GetNftsUseCase
import com.example.learningapp.domain.usecase.GetNftsUseCaseImplementation
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun provideGetNftsUseCase(impl: GetNftsUseCaseImplementation): GetNftsUseCase
}