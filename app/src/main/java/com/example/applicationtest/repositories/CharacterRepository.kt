package com.example.applicationtest.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.applicationtest.database.daos.CharacterDao
import com.example.applicationtest.database.entities.Character
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce

class CharacterRepository constructor (private val characterDao: CharacterDao)  {

    private val _characters = MediatorLiveData<Resource<Array<Character>>>()
    val characters: LiveData<Resource<Array<Character>>>
        get() {
            return _characters
        }


    init {
        subscribeToDatabase()
    }

    private fun subscribeToDatabase() {
        //characterDao.insertCharacter(character = Character(0, "Jean", "Dupont"))
        val sourceDb = characterDao.getAll()
        _characters.postValue(Resource.loading(emptyArray()))

        _characters.addSource(sourceDb) {
            _characters.postValue(Resource.success(it))
        }
    }

    suspend fun addCharacter()
    {
        withContext(Dispatchers.IO) {
            characterDao.insertCharacter(character = Character(0, "Jean", "Dupont"))
        }
    }

    /*private fun CoroutineScope.getCharacters() = produce {
        val lastData: Array<Character> = characters.value?.data ?: emptyArray()
        send(Resource.loading(lastData))

        Fuel.request(CoinRouting.GetCharacters())
            .awaitObjectResult(coinResultDeserializer)
            .fold(success = { response ->
                characterDao.insertAll(response.data)
            }, failure = { error ->
                send(Resource.error(error, lastData))
            })
    }

    fun fetchCharacters() = GlobalScope.launch {
        for (coin in getCharacters()) {
            _characters.postValue(coin)
        }
    }*/
}