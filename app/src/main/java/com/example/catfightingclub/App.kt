package com.example.catfightingclub

import android.app.Application
import com.example.catfightingclub.model.CatsService

class App: Application() {
    val catsService: CatsService by lazy {
        CatsService()
    }
}