package com.example.catfightingclub.viewmodel

import androidx.lifecycle.ViewModel
import com.example.catfightingclub.model.CatsService

class CatFragmentViewModel(private val catsService: CatsService): ViewModel() {

    var cats = catsService.cats
    fun changeStatus(catId: Long) {
        catsService.changeFavoriteStatus(catId)
    }
}