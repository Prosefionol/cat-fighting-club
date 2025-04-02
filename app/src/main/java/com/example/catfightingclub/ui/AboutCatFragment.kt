package com.example.catfightingclub.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.catfightingclub.databinding.FragmentAboutCatBinding
import com.example.catfightingclub.model.PortableCat

class AboutCatFragment : Fragment() {
    private var _binding: FragmentAboutCatBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var cat: PortableCat

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutCatBinding.inflate(layoutInflater, container, false)

        arguments?.let {
            cat = it.getParcelable(ARG)!!
        }

        binding.catId.text = cat.id.toString()
        binding.catName.text = cat.name
        binding.catDescription.text = cat.description

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val ARG = "ARGUMENT"
        fun newInstance(cat: PortableCat): AboutCatFragment {
            val args = Bundle().apply {
                putParcelable(ARG, cat)
            }
            val fragment = AboutCatFragment()
            fragment.arguments = args
            return fragment
        }
    }
}