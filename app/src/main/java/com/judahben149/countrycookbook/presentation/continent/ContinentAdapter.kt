package com.judahben149.countrycookbook.presentation.continent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.judahben149.countrycookbook.databinding.ItemRvContinentBinding
import com.judahben149.countrycookbook.domain.model.Continent

class ContinentAdapter: ListAdapter<Continent, ContinentViewHolder>(ContinentDiffer()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContinentViewHolder {
        val binding = ItemRvContinentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContinentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContinentViewHolder, position: Int) {
        holder.bindContinentItem(getItem(position))
    }
}


class ContinentDiffer(): DiffUtil.ItemCallback<Continent> () {
    override fun areItemsTheSame(oldItem: Continent, newItem: Continent): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Continent, newItem: Continent): Boolean {
        return oldItem.id == newItem.id
    }

}