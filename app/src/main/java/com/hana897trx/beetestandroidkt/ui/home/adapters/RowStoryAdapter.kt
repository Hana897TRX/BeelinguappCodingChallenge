package com.hana897trx.beetestandroidkt.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hana897trx.beetestandroidkt.data.models.CategoryModel
import com.hana897trx.beetestandroidkt.databinding.RowStoryComponentBinding
import com.hana897trx.beetestandroidkt.ui.home.viewHolder.RowStoryViewHolder

class RowStoryAdapter : ListAdapter<CategoryModel, RowStoryViewHolder>(DiffUtilities()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowStoryViewHolder =
        RowStoryViewHolder(RowStoryComponentBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)
        )

    override fun onBindViewHolder(holder: RowStoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffUtilities : DiffUtil.ItemCallback<CategoryModel>() {
        override fun areItemsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: CategoryModel, newItem: CategoryModel): Boolean =
            oldItem == newItem
    }
}