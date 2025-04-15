package com.example.catfightingclub.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catfightingclub.Navigator
import com.example.catfightingclub.databinding.FragmentFavoriteCatBinding
import com.example.catfightingclub.ui.adapters.FavoriteCatsAdapter
import com.example.catfightingclub.viewmodel.FavoriteCatViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoriteCatFragment : Fragment() {

    @Inject lateinit var adapter: FavoriteCatsAdapter
    private val viewModel: FavoriteCatViewModel by viewModels()
    private var _binding: FragmentFavoriteCatBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoriteCatBinding.inflate(layoutInflater, container, false)

        binding.favoriteCatRv.layoutManager = LinearLayoutManager(requireContext())
        binding.favoriteCatRv.adapter = adapter

        viewModel.favoriteCats.observe(viewLifecycleOwner) {
            adapter.submitList(it)
            if (it.isEmpty()) {
                binding.favoriteCatRv.isVisible = false
                binding.stub.isVisible = true
            }
            else {
                binding.favoriteCatRv.isVisible = true
                binding.stub.isVisible = false
            }
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}