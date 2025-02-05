package com.example.catfightingclub.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.catfightingclub.model.Cat
import com.example.catfightingclub.model.CatsService

class CatFragmentViewModel(private val catsService: CatsService): ViewModel() {

    private val _cats = MutableLiveData<List<Cat>>()
    val cats: LiveData<List<Cat>> = _cats

    init {
        _cats.value = refreshData()
    }

    fun changeStatus(catId: Long) {
        catsService.changeFavoriteStatus(catId)
        _cats.value = refreshData()
    }

    private fun refreshData(): List<Cat> {
        return catsService.getCats()
    }
}