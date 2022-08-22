package com.hana897trx.beetestandroidkt.utils

import com.hana897trx.beetestandroidkt.utils.Constants.EMPTY

sealed class DataSource <out T: Any?> {
    object Loading: DataSource<Nothing>()
    data class Error(val message: String = EMPTY, val errorCode: Int) : DataSource<Nothing>()
    data class Success<out T: Any?>(val data: T) : DataSource<T>()
}