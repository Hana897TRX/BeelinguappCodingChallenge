package com.hana897trx.beetestandroidkt.ui.home.events

import com.hana897trx.beetestandroidkt.data.models.CategoryModel

sealed class StoriesEvent {
    object Loading: StoriesEvent()
    data class Error(val error: Int): StoriesEvent()
    data class Success(val data: List<CategoryModel>): StoriesEvent()
}