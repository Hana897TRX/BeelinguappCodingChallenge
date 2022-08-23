package com.hana897trx.beetestandroidkt.ui.home.viewHolder

import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hana897trx.beetestandroidkt.R
import com.hana897trx.beetestandroidkt.data.models.TileModel
import com.hana897trx.beetestandroidkt.databinding.StoryComponentBinding
import com.hana897trx.beetestandroidkt.ui.details.DetailsFragment.Companion.ARGUMENT_TILE_MODEL

class StoryViewHolder(
    private val binding: StoryComponentBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(tileModel: TileModel) = with(binding) {
        Glide
            .with(binding.root)
            .load(tileModel.imageUrl)
            .centerCrop()
            .placeholder(R.drawable.place_holder)
            .into(imgStoryCover)
        txtStoryTitle.text = tileModel.titles[tileModel.languageIndex]
        cardStory.setOnClickListener {
            val bundle = bundleOf(ARGUMENT_TILE_MODEL to tileModel)
            Navigation.findNavController(binding.root).navigate(R.id.action_homeFragment_to_detailsFragment, bundle)
        }
    }
}