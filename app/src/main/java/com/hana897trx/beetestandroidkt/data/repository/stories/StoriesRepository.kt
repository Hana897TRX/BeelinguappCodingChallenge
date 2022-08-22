package com.hana897trx.beetestandroidkt.data.repository.stories

import androidx.lifecycle.MutableLiveData
import com.hana897trx.beetestandroidkt.data.models.CategoryModel

interface StoriesRepository {
    suspend fun getAllStories(): MutableLiveData<List<CategoryModel>>
}