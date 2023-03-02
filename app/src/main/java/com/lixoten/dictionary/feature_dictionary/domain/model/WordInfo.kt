package com.lixoten.dictionary.feature_dictionary.domain.model

import com.lixoten.dictionary.feature_dictionary.data.remote.dto.MeaningDto
import com.lixoten.dictionary.feature_dictionary.data.remote.dto.PhoneticDto

data class WordInfo(
    val meanings: List<Meaning>,
    val phonetic: String?,
    val word: String
)

