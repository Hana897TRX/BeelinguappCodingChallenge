package com.hana897trx.beetestandroidkt.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.hana897trx.beetestandroidkt.R
import com.hana897trx.beetestandroidkt.data.models.TileModel
import com.hana897trx.beetestandroidkt.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private var _binding: FragmentDetailsBinding? = null
    private val binding get() =
            _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<TileModel>(ARGUMENT_TILE_MODEL)?.let {
            bind(it)
        } ?: activity?.onBackPressed()
    }

    private fun bind(data: TileModel) = with(binding) {
        Glide
            .with(this@DetailsFragment)
            .load(data.imageUrl)
            .centerCrop()
            .placeholder(R.drawable.place_holder)
            .into(imgCover)
        txtTitle.text = data.titles[data.languageIndex]
        txtStoryName.text = data.name
        txtDescription.text = data.description[data.languageIndex]

        btnBack.setOnClickListener {
            activity?.onBackPressed()
        }
    }

    companion object {
        const val ARGUMENT_TILE_MODEL = "ARG_TILE_MODEL"
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}