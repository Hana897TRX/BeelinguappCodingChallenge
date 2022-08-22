package com.hana897trx.beetestandroidkt.domain

import com.hana897trx.beetestandroidkt.data.repository.stories.StoriesRepository
import com.hana897trx.beetestandroidkt.utils.DataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class StoriesUseCase @Inject constructor(
    private val repository: StoriesRepository
){
    operator fun invoke() = flow {
        emit(DataSource.Loading)
        try {
            emit(DataSource.Success(repository.getAllStories()))
        } catch (e: Exception) {
            emit(DataSource.Error(message = e.message.orEmpty(), errorCode = e.hashCode()))
        }
    }.flowOn(Dispatchers.IO)
}