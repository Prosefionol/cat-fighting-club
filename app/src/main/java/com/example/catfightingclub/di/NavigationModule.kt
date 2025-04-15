package com.example.catfightingclub.di

import com.example.catfightingclub.Navigator
import com.example.catfightingclub.NavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
abstract class NavigationModule {
    @Binds
    @ActivityScoped
    abstract fun bindNavigator(impl: NavigatorImpl): Navigator
}
