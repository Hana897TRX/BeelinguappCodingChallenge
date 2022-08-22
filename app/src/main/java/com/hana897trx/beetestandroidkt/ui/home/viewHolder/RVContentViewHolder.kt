package com.hana897trx.beetestandroidkt.ui.home.viewHolder

import androidx.recyclerview.widget.RecyclerView
import com.hana897trx.beetestandroidkt.data.models.CategoryModel
import com.hana897trx.beetestandroidkt.databinding.RowStoryComponentBinding
import com.hana897trx.beetestandroidkt.ui.home.adapters.StoriesAdapter

class RVContentViewHolder(
    private val binding: RowStoryComponentBinding
) : RecyclerView.ViewHolder(binding.root) {
    private val adapter: StoriesAdapter = StoriesAdapter()
    fun bind(categoryModel: CategoryModel) = with(binding) {
        txtCategoryTitle.text = categoryModel.category
        rvRowContent.adapter = adapter
        adapter.submitList(categoryModel.data)
    }
}