package com.hana897trx.beetestandroidkt.data.models

data class CategoryModel (
    val category: String = String(),
    val data: List<TileModel>
)

fun Map<String, List<TileModel>>.toMap() = map {
    CategoryModel(
        category = it.key,
        data = it.value
    )
}