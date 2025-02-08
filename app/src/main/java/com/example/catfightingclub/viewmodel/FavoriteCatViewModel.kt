package com.example.catfightingclub.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catfightingclub.model.Cat
import com.example.catfightingclub.model.CatsService

class FavoriteCatViewModel(private val catsService: CatsService): ViewModel() {

    private val _favoriteCats = MutableLiveData<List<Cat>>()
    val favoriteCats: LiveData<List<Cat>> = _favoriteCats

    init {
        _favoriteCats.value = refreshData()
    }

    private fun refreshData(): List<Cat> {
        return catsService.getFavoriteCats()
    }
}
