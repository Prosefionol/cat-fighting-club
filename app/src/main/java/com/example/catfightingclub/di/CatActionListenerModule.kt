package com.example.catfightingclub.di

import com.example.catfightingclub.ui.adapters.CatActionListener
import com.example.catfightingclub.ui.adapters.CatActionListenerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped

@Module
@InstallIn(FragmentComponent::class)
abstract class CatActionListenerModule {
    @Binds
    @FragmentScoped
    abstract fun bindCatActionListener(catActionListener: CatActionListenerImpl): CatActionListener
}
