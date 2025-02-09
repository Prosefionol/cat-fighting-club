package com.example.catfightingclub.viewmodel

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.catfightingclub.App

class ViewModelFactory(
    private val app: App
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when(modelClass) {
            CatFragmentViewModel::class.java -> {
                CatFragmentViewModel(app.catsService)
            }
            FavoriteCatViewModel::class.java -> {
                FavoriteCatViewModel(app.catsService)
            }
            else -> throw IllegalStateException()
        }
        return viewModel as T
    }
}

fun Fragment.factory() = ViewModelFactory(requireContext().applicationContext as App)