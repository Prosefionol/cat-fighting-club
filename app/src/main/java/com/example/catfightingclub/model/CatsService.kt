package com.example.catfightingclub.model

interface CatsService {
    fun getCats(): List<Cat>
    fun getFavoriteCats(): List<Cat>
    fun getCatById(id: Long): Cat
    fun changeFavoriteStatus(id: Long)
}