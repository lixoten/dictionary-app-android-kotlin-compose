package com.lixoten.dictionary.feature_dictionary.domain.model


// only map what we need from Dto
data class Definition(
    val antonyms: List<String>,
    val definition: String,
    val example: String?,
    val synonyms: List<String>
)
