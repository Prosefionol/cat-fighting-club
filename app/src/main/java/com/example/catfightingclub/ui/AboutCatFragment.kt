package com.example.catfightingclub.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.catfightingclub.databinding.FragmentAboutCatBinding
import com.example.catfightingclub.model.PortableCat

class AboutCatFragment : Fragment() {
    private var _binding: FragmentAboutCatBinding? = null
    private val binding
        get() = _binding!!

    private val args by navArgs<AboutCatFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutCatBinding.inflate(layoutInflater, container, false)

        binding.catId.text = args.cat.id.toString()
        binding.catName.text = args.cat.name
        binding.catDescription.text = args.cat.description

        binding.goBackButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}