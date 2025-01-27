package com.example.catfightingclub.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.catfightingclub.databinding.FragmentCatBinding
import com.example.catfightingclub.ui.adapters.CatActionListener
import com.example.catfightingclub.ui.adapters.CatsAdapter
import com.example.catfightingclub.viewmodel.CatFragmentViewModel
import com.example.catfightingclub.viewmodel.factory

class CatFragment : Fragment() {

    private var _binding: FragmentCatBinding? = null
    private val binding
        get() = _binding!!
    private lateinit var adapter: CatsAdapter
    private val viewModel: CatFragmentViewModel by viewModels { factory() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCatBinding.inflate(layoutInflater, container, false)
        adapter = CatsAdapter(
            object:CatActionListener{
                override fun onChangeStatus(catId: Long) {
                    viewModel.changeStatus(catId)
                }
            },
            requireContext()
        )
        binding.catRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.catRecyclerView.adapter = adapter
        adapter.submitList(viewModel.cats)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}