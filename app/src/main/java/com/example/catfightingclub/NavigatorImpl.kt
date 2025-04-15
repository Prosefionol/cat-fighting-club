package com.example.catfightingclub

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.catfightingclub.model.Cat
import com.example.catfightingclub.model.toPortableCat
import com.example.catfightingclub.ui.AboutCatFragment
import dagger.hilt.android.qualifiers.ActivityContext
import javax.inject.Inject

class NavigatorImpl @Inject constructor(@ActivityContext private val activityContext: Context): Navigator {
    override fun loadFragment(fragment: Fragment) {
        (activityContext as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun showDetails(cat: Cat) {
        val fragment = AboutCatFragment.newInstance(cat.toPortableCat())
        loadFragment(fragment)
    }
}