package com.example.catfightingclub.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.catfightingclub.model.Cat
import com.example.catfightingclub.model.CatsService
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CatFragmentViewModel @Inject constructor(
    private val catsService: CatsService,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _cats = savedStateHandle.getLiveData<List<Cat>>(KEY_STATE)
    val cats: LiveData<List<Cat>> = _cats

    init {
        _cats.postValue(catsService.getCats())
    }

    companion object {
        const val KEY_STATE = "state"
    }
}