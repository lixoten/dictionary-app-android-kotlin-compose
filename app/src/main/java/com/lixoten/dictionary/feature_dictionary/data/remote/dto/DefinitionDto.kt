package com.lixoten.dictionary.feature_dictionary.data.remote.dto

import com.lixoten.dictionary.feature_dictionary.domain.model.Definition

// only map what we need from Dto
data class DefinitionDto(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
) {
    fun toDefinition(): Definition {
        return Definition(
            antonyms = antonyms,
            definition = definition,
            example = example,
            synonyms = synonyms
        )
    }
}