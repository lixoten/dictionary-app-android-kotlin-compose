package com.lixoten.dictionary.feature_dictionary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.lixoten.dictionary.feature_dictionary.data.local.entity.WordInfoEntity

@Dao
interface WordInfoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfos(infos: List<WordInfoEntity>)

    @Query("DELETE from wordInfoEntity WHERE word IN(:words)")
    suspend fun deleteWordInfo(words: List<String>)

    // the || is SQL concatenate
    @Query("SELECT * from wordInfoEntity WHERE word LIKE '%' || :word || '%'")
    suspend fun getWordInfo(word: String): List<WordInfoEntity>
}