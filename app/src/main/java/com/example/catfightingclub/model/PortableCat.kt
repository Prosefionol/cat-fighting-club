package com.example.catfightingclub.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PortableCat(
    val id: Long,
    val name: String,
    val description: String
): Parcelable
