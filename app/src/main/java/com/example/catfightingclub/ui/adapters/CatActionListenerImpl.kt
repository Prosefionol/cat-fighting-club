package com.example.catfightingclub.ui.adapters

import com.example.catfightingclub.model.Cat
import com.example.catfightingclub.model.CatsService
import javax.inject.Inject

class CatActionListenerImpl @Inject constructor(private val catsService: CatsService): CatActionListener {
    override fun onChangeStatus(catId: Long) {
        catsService.changeFavoriteStatus(catId)
    }

    override fun getCatById(id: Long): Cat = catsService.getCatById(id)
}