package com.example.catfightingclub.viewmodel

import androidx.lifecycle.ViewModel
import com.example.catfightingclub.model.CatsService

class CatFragmentViewModel(private val catsService: CatsService): ViewModel() {
    fun getCat(): String = catsService.getCatName()
}