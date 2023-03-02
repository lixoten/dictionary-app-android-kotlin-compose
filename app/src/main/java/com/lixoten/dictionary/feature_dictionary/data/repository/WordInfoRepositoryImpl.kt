package com.lixoten.dictionary.feature_dictionary.data.repository

import com.lixoten.dictionary.feature_dictionary.core.util.Resource
import com.lixoten.dictionary.feature_dictionary.data.local.WordInfoDao
import com.lixoten.dictionary.feature_dictionary.data.remote.DictionaryApi
import com.lixoten.dictionary.feature_dictionary.domain.model.WordInfo
import com.lixoten.dictionary.feature_dictionary.domain.repository.WordInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class WordInfoRepositoryImpl(
    private val api: DictionaryApi,
    private val dao: WordInfoDao,
): WordInfoRepository {
    override fun getWordInto(word: String): Flow<Resource<List<WordInfo>>> = flow {
        emit(Resource.Loading())

        val wordInfos = dao.getWordInfo(word).map { it.toWordInfo() }
        emit(Resource.Loading(data = wordInfos))

        try {
            val remoteWordInfos = api.getWordInfo(word)
            dao.deleteWordInfo(remoteWordInfos.map { it.word })
            dao.insertWordInfos(remoteWordInfos.map { it.toWordIntoEntity() })
        } catch (e: HttpException ){
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = wordInfos,
            ))
        } catch (e: IOException ){
            emit(Resource.Error(
                message = "Couldn't reach server! Check you internet connection.",
                data = wordInfos,
            ))
        }

        val newWordInfos = dao.getWordInfo(word).map { it.toWordInfo() }
        emit(Resource.Success(data = newWordInfos))

    }

}