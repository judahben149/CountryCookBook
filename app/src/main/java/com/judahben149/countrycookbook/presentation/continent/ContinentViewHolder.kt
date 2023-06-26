package com.judahben149.countrycookbook.presentation.continent

import androidx.recyclerview.widget.RecyclerView
import com.judahben149.countrycookbook.databinding.ItemRvContinentBinding
import com.judahben149.countrycookbook.domain.model.Continent

class ContinentViewHolder(private val binding: ItemRvContinentBinding): RecyclerView.ViewHolder(binding.root) {

    fun bindContinentItem(continent: Continent) {
        binding.tvContinentName.text = continent.name
    }
}