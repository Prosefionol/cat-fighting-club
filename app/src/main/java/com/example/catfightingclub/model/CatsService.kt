package com.example.catfightingclub.model

class CatsService() {

    private var _cats = mutableListOf<Cat>()
    val cats: List<Cat> = _cats

    init {
        _cats = (0..19).map {
            Cat(
                id = it.toLong(),
                name = createName(it),
                photo = createPhoto(),
                isFavorite = DEFAULT_STATUS
            )
        }.toMutableList()
    }

    fun changeFavoriteStatus(id: Long) {
        val index = getIndexById(id)
        if (index == -1) return
        val tempCat = _cats[index].copy(isFavorite = !_cats[index].isFavorite)
        _cats = ArrayList(_cats)
        _cats[index] = tempCat
    }

    fun getCatName(id: Long = 5): String {
        val index = getIndexById(id)
        return _cats[index].name
    }

    private fun getIndexById(id: Long): Int = _cats.indexOfFirst {
        it.id == id
    }
    private fun createName(number: Int): String = "Cat $number"
    private fun createPhoto(): String = ""

    companion object {
        const val DEFAULT_STATUS = false
    }
}