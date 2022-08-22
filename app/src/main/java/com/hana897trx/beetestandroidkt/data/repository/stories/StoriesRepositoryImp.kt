package com.hana897trx.beetestandroidkt.data.repository.stories

import androidx.lifecycle.MutableLiveData
import com.hana897trx.beetestandroidkt.data.models.CategoryModel
import com.hana897trx.beetestandroidkt.data.remote.stories.StoriesRemoteDataSource
import javax.inject.Inject

class StoriesRepositoryImp @Inject constructor(
    private val storiesRemoteDataSource: StoriesRemoteDataSource
): StoriesRepository {
    override suspend fun getAllStories(): MutableLiveData<List<CategoryModel>> {
        return storiesRemoteDataSource.getAllStories()
    }
}