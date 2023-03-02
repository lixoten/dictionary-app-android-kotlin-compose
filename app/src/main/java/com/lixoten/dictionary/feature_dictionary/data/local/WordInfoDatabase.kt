package com.lixoten.dictionary.feature_dictionary.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.lixoten.dictionary.feature_dictionary.data.local.entity.WordInfoEntity

@Database(version = 1, entities = [WordInfoEntity::class], exportSchema = false)
@TypeConverters(Converters::class)
abstract class WordInfoDatabase: RoomDatabase() {

    abstract fun wordInfoDao(): WordInfoDao

//    companion object {
//        @Volatile
//        private var Instance: WordInfoDatabase? = null
//
//        fun getDatabase(context: Context): WordInfoDatabase {
//            // if the Instance is not null, return it, otherwise create a new database instance.
//            return Instance ?: synchronized(this) {
//                Room.databaseBuilder(context, WordInfoDatabase::class.java, "word_database")
//                    .build()
//                    .also { Instance = it }
//            }
//        }
//    }
}