package com.judahben149.countrycookbook.presentation.countryList

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.judahben149.countrycookbook.databinding.ItemRvCountryBinding
import com.judahben149.countrycookbook.domain.model.Country

class CountryAdapter(
    private val context: Context,
    private val onClick:(countryCode: String) -> Unit
): ListAdapter<Country, CountryViewHolder>(CountryDiffer()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemRvCountryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CountryViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bindCountryItem(getItem(position)) { countryCode ->
            onClick(countryCode)
        }
    }
}

class CountryDiffer: DiffUtil.ItemCallback<Country>() {
    override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
        return oldItem.id == newItem.id
    }

}