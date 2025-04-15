package com.example.catfightingclub.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catfightingclub.databinding.FragmentCatBinding
import com.example.catfightingclub.model.CatsService
import com.example.catfightingclub.ui.adapters.CatActionListener
import com.example.catfightingclub.ui.adapters.CatsAdapter
import com.example.catfightingclub.viewmodel.CatFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CatFragment : Fragment() {

    private var _binding: FragmentCatBinding? = null
    private val binding
        get() = _binding!!
    @Inject lateinit var adapter: CatsAdapter
    private val viewModel: CatFragmentViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatBinding.inflate(layoutInflater, container, false)

        binding.catRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.catRecyclerView.adapter = adapter

        viewModel.cats.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}