package com.hana897trx.beetestandroidkt.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.hana897trx.beetestandroidkt.data.models.TileModel
import com.hana897trx.beetestandroidkt.databinding.StoryComponentBinding
import com.hana897trx.beetestandroidkt.ui.home.viewHolder.StoryViewHolder

class StoryAdapter : ListAdapter<TileModel, StoryViewHolder>(DiffUtilities()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder =
        StoryViewHolder(
            StoryComponentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private class DiffUtilities : DiffUtil.ItemCallback<TileModel>() {
        override fun areItemsTheSame(oldItem: TileModel, newItem: TileModel): Boolean =
            oldItem == newItem

        override fun areContentsTheSame(oldItem: TileModel, newItem: TileModel): Boolean =
            oldItem == newItem
    }
}