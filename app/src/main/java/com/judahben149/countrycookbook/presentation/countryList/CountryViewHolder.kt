package com.judahben149.countrycookbook.presentation.countryList

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.judahben149.countrycookbook.databinding.ItemRvCountryBinding
import com.judahben149.countrycookbook.domain.model.Country
import com.judahben149.countrycookbook.utils.getEmojiDrawable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountryViewHolder(private val binding: ItemRvCountryBinding, private val context: Context): RecyclerView.ViewHolder(binding.root) {

    fun bindCountryItem(country: Country, onClick:(countryCode: String) -> Unit) {
        binding.tvCountryCode.text = country.id
        binding.tvCountryName.text = country.name
        binding.tvCountryCapital.text = country.capital

        CoroutineScope(Dispatchers.IO).launch {
            val drawable = country.flag.getEmojiDrawable(context)
            withContext(Dispatchers.Main) {
                binding.ivCountryFlag.setImageDrawable(drawable)
            }
        }

        binding.itemCountry.setOnClickListener {
            onClick(country.id)
        }
    }
}