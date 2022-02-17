package com.example.pokemonfunproject.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pokemonfunproject.databinding.FragmentHomeBinding
import com.example.pokemonfunproject.ui.common.adapter.PokeRecyclerViewAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private lateinit var viewBinding: FragmentHomeBinding
    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var adapter: PokeRecyclerViewAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        if (binding == null) {
            binding = FragmentHomeBinding.inflate(inflater, container, false)
        }
        viewBinding = binding!!
        return binding?.root
    }
}