package com.hana897trx.beetestandroidkt.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.hana897trx.beetestandroidkt.databinding.FragmentHomeBinding
import com.hana897trx.beetestandroidkt.ui.home.adapters.RowStoryAdapter
import com.hana897trx.beetestandroidkt.ui.home.events.StoriesEvent
import com.hana897trx.beetestandroidkt.ui.home.viewModel.HomeViewModel
import com.hana897trx.beetestandroidkt.utils.hide
import com.hana897trx.beetestandroidkt.utils.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class HomeFragment: Fragment() {

    private var _binding : FragmentHomeBinding? = null
    private val binding get() =
        _binding!!

    private val vm: HomeViewModel by viewModels()

    private val rowStoryAdapter : RowStoryAdapter = RowStoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(LayoutInflater.from(context), container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setInitViews()
        getStories()
    }

    private fun setInitViews() = with(binding) {
        rvContent.adapter = rowStoryAdapter
    }

    private fun getStories() {
        vm.storiesEvent.onEach { response ->
            when(response) {
                is StoriesEvent.Loading -> {
                    binding.run {
                        rvContent.hide()
                        txtError.hide()
                        contentPlaceHolder.root.show()
                        contentPlaceHolder.shimmerContentHome.startShimmer()
                    }
                }
                is StoriesEvent.Success -> {
                    rowStoryAdapter.submitList(response.data)
                    binding.run {
                        rvContent.show()
                        contentPlaceHolder.root.hide()
                        txtError.hide()
                        contentPlaceHolder.shimmerContentHome.stopShimmer()
                    }
                }
                is StoriesEvent.Error -> {
                    binding.run {
                        rvContent.hide()
                        contentPlaceHolder.root.hide()
                        txtError.show()
                    }
                }
            }
        }.launchIn(lifecycleScope)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}