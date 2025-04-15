package com.example.catfightingclub.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catfightingclub.model.Cat
import com.example.catfightingclub.model.CatsService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteCatViewModel @Inject constructor(private val catsService: CatsService): ViewModel() {

    private val _favoriteCats = MutableLiveData<List<Cat>>()
    val favoriteCats: LiveData<List<Cat>> = _favoriteCats

    init {
        _favoriteCats.value = refreshData()
    }

    private fun refreshData(): List<Cat> {
        return catsService.getFavoriteCats()
    }
}
