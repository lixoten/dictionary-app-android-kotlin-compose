package com.lixoten.dictionary.feature_dictionary.data.remote.dto

import com.lixoten.dictionary.feature_dictionary.domain.model.Meaning

// only map what we need from Dto
data class MeaningDto(
    val antonyms: List<Any>,
    //val definitionDtos: List<DefinitionDto>,
    val definitions: List<DefinitionDto>,
    val partOfSpeech: String,
    val synonyms: List<String>
) {
    fun toMeaning(): Meaning {
        return Meaning(
            definitions = definitions.map { it.toDefinition() },
            partOfSpeech = partOfSpeech
        )
    }
}