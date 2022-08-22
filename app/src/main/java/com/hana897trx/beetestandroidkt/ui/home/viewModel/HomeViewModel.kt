package com.hana897trx.beetestandroidkt.ui.home.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hana897trx.beetestandroidkt.domain.StoriesUseCase
import com.hana897trx.beetestandroidkt.ui.home.events.StoriesEvent
import com.hana897trx.beetestandroidkt.utils.DataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val storiesUseCase: StoriesUseCase
): ViewModel() {

    private var _storiesEvent: MutableStateFlow<StoriesEvent> =
        MutableStateFlow(StoriesEvent.Loading)
    val storiesEvent: StateFlow<StoriesEvent> = _storiesEvent

    init {
        getStories()
    }

    private fun getStories() {
        storiesUseCase.invoke().onEach { response ->
            when(response) {
                is DataSource.Loading -> _storiesEvent.emit(StoriesEvent.Loading)
                is DataSource.Success -> {
                    (response.data.value ?: emptyList()).let {
                        _storiesEvent.emit(StoriesEvent.Success(it))
                    }
                }
                is DataSource.Error -> _storiesEvent.emit(StoriesEvent.Error(response.errorCode))
            }
        }.launchIn(viewModelScope)
    }
}