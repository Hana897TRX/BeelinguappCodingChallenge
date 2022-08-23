package com.hana897trx.beetestandroidkt.utils

import android.view.View
import com.hana897trx.beetestandroidkt.data.models.TileModel
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.LinkedHashMap

fun ArrayList<LinkedHashMap<String, String>>.toMap() = map {
    TileModel(
        name = it["name"] ?: String(),
        titles = it["titles"]?.splitData()?.removeLanguageInText() ?: emptyList(),
        language = it["languages"]?.splitData() ?: emptyList(),
        imageUrl = it["imageUrl"] ?: String(),
        description = it["descriptions"]?.splitData()?.removeLanguageInText() ?: emptyList(),
        dynamicCategories = it["dynamicCategories"]?.splitData()?.removeLanguageInText() ?: emptyList(),
        levelV2 = it["levelV2"] ?: String(),
        languageIndex = it["languages"]?.splitData()?.getLanguageIndex() ?: -1,
        storyLevel = it["levelV2"]?.parseLevel() ?: StoryLevel.NO_RELATED
    )
}

fun String.splitData() =
    this.removeRange(0..1)
        .dropLast(2)
        .replace("\"", "")
        .split(",")

fun List<String>.getLanguageIndex() : Int {
    val lan = Locale.getDefault().language
    return this.indexOfFirst {
        it == lan
    }
}

fun String.parseLevel() : StoryLevel {
    return when(this) {
        "beginner_2", "beginner_1" -> StoryLevel.BEGINNER
        "intermediate_1", "intermediate_2" -> StoryLevel.INTERMEDIATE
        "advanced_1", "advanced_2" -> StoryLevel.ADVANCED
        else -> StoryLevel.NO_RELATED
    }
}

fun List<String>.removeLanguageInText() = map {
    it.drop(3)
}

fun View.hide() {
    this.visibility = View.INVISIBLE
}

fun View.show() {
    this.visibility = View.VISIBLE
}