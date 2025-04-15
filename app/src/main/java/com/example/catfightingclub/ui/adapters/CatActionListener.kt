package com.example.catfightingclub.ui.adapters

import com.example.catfightingclub.model.Cat

interface CatActionListener {
    fun onChangeStatus(catId: Long)
    fun getCatById(id: Long): Cat
}