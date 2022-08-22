package com.hana897trx.beetestandroidkt.data.remote.stories

import androidx.lifecycle.MutableLiveData
import com.hana897trx.beetestandroidkt.data.models.CategoryModel

interface StoriesRemoteDataSource {
    suspend fun getAllStories(): MutableLiveData<List<CategoryModel>>
}