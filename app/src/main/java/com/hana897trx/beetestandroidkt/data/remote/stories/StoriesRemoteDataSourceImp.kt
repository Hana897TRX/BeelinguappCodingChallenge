package com.hana897trx.beetestandroidkt.data.remote.stories

import androidx.lifecycle.MutableLiveData
import com.hana897trx.beetestandroidkt.data.models.CategoryModel
import com.hana897trx.beetestandroidkt.data.models.toMap
import com.hana897trx.beetestandroidkt.utils.NetworkGetStoriesAPI.END_POINT
import com.hana897trx.beetestandroidkt.utils.toMap
import com.kumulos.android.Kumulos
import com.kumulos.android.ResponseHandler
import javax.inject.Inject

class StoriesRemoteDataSourceImp @Inject constructor(): StoriesRemoteDataSource {
   private val responseList : MutableLiveData<List<CategoryModel>> = MutableLiveData()
    override suspend fun getAllStories(): MutableLiveData<List<CategoryModel>> {
        val callback = object : ResponseHandler() {
            override fun didCompleteWithResult(result: Any?) {
                super.didCompleteWithResult(result)
                val list = (result as ArrayList<LinkedHashMap<String, String>>).toMap()
                val data = list.groupBy { it.dynamicCategories[it.languageIndex] }.toMap()
                responseList.postValue(data)
            }
        }

        Kumulos.call(END_POINT, HashMap<String, String>(), callback)
        return responseList
    }
}