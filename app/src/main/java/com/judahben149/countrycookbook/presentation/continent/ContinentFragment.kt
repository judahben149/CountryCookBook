package com.judahben149.countrycookbook.presentation.continent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.judahben149.countrycookbook.databinding.FragmentContinentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContinentFragment : Fragment() {

    private var _binding: FragmentContinentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ContinentViewModel by viewModels()
    private var adapter: ContinentAdapter? = null
    private lateinit var continentRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentContinentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()

        viewModel.continentList.observe(viewLifecycleOwner) { continentList ->
            if (continentList.isNotEmpty()) {
                adapter?.submitList(continentList)
            }
        }
    }

    private fun setupAdapter() {
        continentRecyclerView = binding.rvContinents
        adapter = ContinentAdapter()
        continentRecyclerView.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        adapter = null
    }
}