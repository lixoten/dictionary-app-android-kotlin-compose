package com.lixoten.dictionary.feature_dictionary.data.remote.dto

import com.lixoten.dictionary.feature_dictionary.data.local.entity.WordInfoEntity
import com.lixoten.dictionary.feature_dictionary.domain.model.WordInfo


data class WordInfoDto(
    //val license: License,
    //val meaningDtos: List<MeaningDto>,
    val meanings: List<MeaningDto>,
    val phonetic: String,
    val phonetics: List<PhoneticDto>,
    val sourceUrls: List<String>,
    val word: String
) {
//    fun toWordInto(): WordInfo {
//        return WordInfo(
//            meanings = meanings.map { it.toMeaning() },
//            phonetic = phonetic,
//            word = word
//        )
//    }
fun toWordIntoEntity(): WordInfoEntity {
    return WordInfoEntity(
        meanings = meanings.map { it.toMeaning() },
        phonetic = phonetic,
        word = word
    )
}

}