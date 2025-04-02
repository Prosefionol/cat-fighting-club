package com.example.catfightingclub.model

data class Cat (
    val id: Long,
    val name: String,
    val description: String,
    val isFavorite: Boolean
)

fun Cat.toPortableCat(): PortableCat {
    return PortableCat(
        id = this.id,
        name = this.name,
        description = this.description
    )
}