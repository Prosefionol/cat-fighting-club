package com.example.catfightingclub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.catfightingclub.ui.CatFragment
import com.example.catfightingclub.ui.FavoriteCatFragment
import com.example.catfightingclub.databinding.ActivityMainBinding
import com.example.catfightingclub.model.Cat
import com.example.catfightingclub.model.PortableCat
import com.example.catfightingclub.model.toPortableCat
import com.example.catfightingclub.ui.AboutCatFragment

class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }
        binding.bottomMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.all_fighters -> {
                    loadFragment(CatFragment())
                    true
                }
                R.id.favorite_fighters -> {
                    loadFragment(FavoriteCatFragment())
                    true
                }
                else -> false
            }
        }
        if (savedInstanceState == null) {
            loadFragment(CatFragment())
        }

    }

    override fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun showDetails(cat: Cat) {
        val fragment = AboutCatFragment.newInstance(cat.toPortableCat())
        loadFragment(fragment)
    }
}