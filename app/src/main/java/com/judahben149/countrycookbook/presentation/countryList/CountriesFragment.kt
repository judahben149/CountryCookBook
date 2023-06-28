package com.judahben149.countrycookbook.presentation.countryList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.judahben149.countrycookbook.R
import com.judahben149.countrycookbook.databinding.FragmentCountriesBinding
import com.judahben149.countrycookbook.utils.CONTINENT_CODE
import com.judahben149.countrycookbook.utils.COUNTRY_CODE
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountriesFragment : Fragment() {

    private var _binding: FragmentCountriesBinding? = null
    private val binding get() = _binding!!

    private val navController by lazy {
        findNavController()
    }

    private val viewModel: CountriesViewModel by viewModels()
    private var adapter: CountryAdapter? = null
    private lateinit var continentRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val continentCode = arguments?.getString(CONTINENT_CODE)

        setupAdapter()
        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            adapter?.submitList(state.countryList)
        }

        continentCode?.let {
            viewModel.getContinentDetails(it)
        }
    }

    private fun setupAdapter() {
        continentRecyclerView = binding.rvCountries
        adapter = CountryAdapter(requireContext()) { countryCode ->
            val bundle = Bundle().apply {
                this.putString(COUNTRY_CODE, countryCode)
            }
            navController.navigate(R.id.action_countriesFragment_to_countryDetailFragment, bundle)
        }
        continentRecyclerView.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
        adapter = null
    }
}