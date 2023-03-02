package com.lixoten.dictionary.feature_dictionary.data.remote

import com.lixoten.dictionary.feature_dictionary.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {

    // Notes: Install PLUGIN: "JSON to kotlin Class"
    //  - this plugin helps us generate the DTO.. the data class for a record
    //  - multiple options of set up, phillips seems to be using "gson", select fiends only as needed option too
    //  - shift-F6 to rename
    //  - Clean up "Any" is one got generated... example was in dictionary project
    //@GET("/v1/coins")
    //suspend fun getCoins(): List<CoinDto>

    // "coinId" url path parameter
    //@GET("/v1/coins/{coinId}")
    //suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto

    // return a list of multiple words for a word, as in bank... if can return multiple
    // "word" url path parameter
    @GET("api/v2/entries/en/{word}")
    suspend fun getWordInfo(
        @Path("word") word: String
    ): List<WordInfoDto>

    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/"
    }
    // could of been in : Commons > Constants.kt - object class
//    object Constants {
//        const val BASE_URL = "https://api.coinpaprika.com/"
//        const val PARAM_COIN_ID = "coinId"
//    }
}
