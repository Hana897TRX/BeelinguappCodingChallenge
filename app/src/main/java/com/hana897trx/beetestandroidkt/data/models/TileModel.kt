package com.hana897trx.beetestandroidkt.data.models

import android.os.Parcelable
import com.hana897trx.beetestandroidkt.utils.Constants.EMPTY
import com.hana897trx.beetestandroidkt.utils.StoryLevel
import kotlinx.parcelize.Parcelize

@Parcelize
data class TileModel (
    val name: String = EMPTY,
    val titles: List<String> = emptyList(),
    val language: List<String> = emptyList(),
    val imageUrl: String = EMPTY,
    val description: List<String> = emptyList(),
    val dynamicCategories: List<String> = emptyList(),
    val levelV2: String = EMPTY,
    val languageIndex: Int = -1,
    val storyLevel: StoryLevel = StoryLevel.NO_RELATED
) : Parcelable
