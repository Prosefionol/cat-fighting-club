package com.example.catfightingclub.model

class CatsService() {

    private var cats = mutableListOf<Cat>()

    init {
        cats = (0..19).map {
            Cat(
                id = it.toLong(),
                name = createName(it),
                photo = createPhoto(),
                isFavorite = DEFAULT_STATUS
            )
        }.toMutableList()
    }

    fun getCats(): List<Cat> {
        return cats.toList()
    }

    fun getFavoriteCats(): List<Cat> {
        return cats.filter { it.isFavorite }.toList()
    }

    fun changeFavoriteStatus(id: Long) {
        val index = getIndexById(id)
        if (index == -1) return
        val tempCat = cats[index].copy(isFavorite = !cats[index].isFavorite)
        cats = ArrayList(cats)
        cats[index] = tempCat
    }

    private fun getIndexById(id: Long): Int = cats.indexOfFirst {
        it.id == id
    }

    private fun createName(number: Int): String = "Cat $number"
    private fun createPhoto(): String = ""

    companion object {
        const val DEFAULT_STATUS = false
    }
}