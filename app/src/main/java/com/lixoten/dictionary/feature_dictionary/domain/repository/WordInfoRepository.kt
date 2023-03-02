package com.lixoten.dictionary.feature_dictionary.domain.repository

import com.lixoten.dictionary.feature_dictionary.core.util.Resource
import com.lixoten.dictionary.feature_dictionary.domain.model.WordInfo
import kotlinx.coroutines.flow.Flow

interface WordInfoRepository {

    fun getWordInto(word: String): Flow<Resource<List<WordInfo>>>
}