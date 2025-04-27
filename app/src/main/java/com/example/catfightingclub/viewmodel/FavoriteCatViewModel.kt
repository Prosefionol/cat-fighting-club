package com.example.catfightingclub.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.catfightingclub.model.Cat
import com.example.catfightingclub.model.CatsService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteCatViewModel @Inject constructor(
    private val catsService: CatsService,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _favoriteCats = savedStateHandle.getLiveData<List<Cat>>(KEY_STATE)
    val favoriteCats: LiveData<List<Cat>> = _favoriteCats

    init {
        _favoriteCats.postValue(catsService.getFavoriteCats())
    }

    fun refreshData() {
        _favoriteCats.postValue(catsService.getFavoriteCats())
    }

    companion object {
        const val KEY_STATE = "state"
    }
}
