package com.lixoten.dictionary.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.lixoten.dictionary.feature_dictionary.domain.model.Meaning
import com.lixoten.dictionary.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    @PrimaryKey val id: Int? = null,
    val word: String,
    val phonetic: String?,
    val meanings: List<Meaning>,
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            word = word,
            phonetic = phonetic,
            meanings = meanings
        )
    }
}