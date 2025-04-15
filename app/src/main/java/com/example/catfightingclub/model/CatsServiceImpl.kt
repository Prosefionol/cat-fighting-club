package com.example.catfightingclub.model

class CatsServiceImpl(): CatsService {

    private var cats = mutableListOf<Cat>()

    init {
        cats = (0..19).map {
            Cat(
                id = it.toLong(),
                name = createName(it),
                description = createDescription(it),
                isFavorite = DEFAULT_STATUS
            )
        }.toMutableList()
    }

    override fun getCats(): List<Cat> {
        return cats.toList()
    }

    override fun getFavoriteCats(): List<Cat> {
        return cats.filter { it.isFavorite }.toList()
    }

    override fun changeFavoriteStatus(id: Long) {
        val index = getIndexById(id)
        if (index == -1) return
        val tempCat = cats[index].copy(isFavorite = !cats[index].isFavorite)
        cats = ArrayList(cats)
        cats[index] = tempCat
    }

    override fun getCatById(id: Long): Cat {
        return cats[getIndexById(id)]
    }

    private fun getIndexById(id: Long): Int = cats.indexOfFirst {
        it.id == id
    }

    private fun createName(number: Int): String = "Cat $number"
    private fun createDescription(number: Int): String = "Cat $number description"

    companion object {
        const val DEFAULT_STATUS = false
    }
}