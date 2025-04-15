package com.example.catfightingclub

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.catfightingclub.model.Cat

interface Navigator {
    fun loadFragment(fragment: Fragment)
    fun showDetails(cat: Cat)
}