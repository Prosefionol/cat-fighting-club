package com.example.catfightingclub

import android.content.Context
import androidx.navigation.fragment.NavHostFragment
import com.example.catfightingclub.model.Cat
import com.example.catfightingclub.model.toPortableCat
import com.example.catfightingclub.ui.FavoriteCatFragmentDirections
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class NavigatorImpl @Inject constructor(@ActivityContext private val activityContext: Context): Navigator {

    override fun showDetails(cat: Cat) {
        val direction = FavoriteCatFragmentDirections.actionFavoriteCatFragmentToAboutCatFragment(cat.toPortableCat())
        val navHostFragment = (activityContext as MainActivity)
            .supportFragmentManager
            .findFragmentById(R.id.fragment_container)
                as NavHostFragment
        val navController = navHostFragment.navController
        navController.navigate(direction)
    }
}