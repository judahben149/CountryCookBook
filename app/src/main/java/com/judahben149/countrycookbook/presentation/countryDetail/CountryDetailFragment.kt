package com.judahben149.countrycookbook.presentation.countryDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.judahben149.countrycookbook.databinding.FragmentCountryDetailBinding
import com.judahben149.countrycookbook.utils.COUNTRY_CODE
import com.judahben149.countrycookbook.utils.createPalette
import com.judahben149.countrycookbook.utils.getEmojiDrawable
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryDetailFragment : Fragment() {

    private var _binding: FragmentCountryDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: CountryDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCountryDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val countryCode = arguments?.getString(COUNTRY_CODE)

        viewModel.uiState.observe(viewLifecycleOwner) { state ->
            if (!state.isLoading) {
                bindUI(state)
            }
        }

        countryCode?.let {
            viewModel.getCountryDetails(countryCode)
        }
    }

    private fun bindUI(state: CountryDetailState) {
        binding.collapsingToolBarLayout.title = state.country.name
        val flag = state.country.flag.getEmojiDrawable(requireContext())
//        binding.ivFlag.setImageDrawable(flag)
//        binding.ivBackdrop.setImageDrawable(flag)

        val palette = createPalette(flag)

        palette.apply {
            mutedSwatch?.let {
                binding.background.apply {
                    setBackgroundColor(it.rgb)
                    alpha = 0.4f
                }
            }
            vibrantSwatch?.let {
                binding.collapsingToolBarLayout.setBackgroundColor(it.rgb)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}