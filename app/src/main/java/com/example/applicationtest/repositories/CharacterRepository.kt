package com.example.applicationtest.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.applicationtest.database.daos.CharacterDao
import com.example.applicationtest.database.entities.Character
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.produce

class CharacterRepository constructor (private val characterDao: CharacterDao)  {

    private val _selectedCharacter = MediatorLiveData<Resource<Character>>()
    val selectedCharacter: LiveData<Resource<Character>>
        get() {
            return _selectedCharacter
        }


    private val _characters = MediatorLiveData<Resource<Array<Character>>>()
    val characters: LiveData<Resource<Array<Character>>>
        get() {
            return _characters
        }


    init {
        subscribeToDatabase()
    }

    private fun subscribeToDatabase() {
        val sourceDb = characterDao.getAll()
        _characters.postValue(Resource.loading(emptyArray()))

        _characters.addSource(sourceDb) {
            _characters.postValue(Resource.success(it))
        }
    }

    suspend fun getCharacterById(characterId : Int) : Character
    {
        var char = characterDao.findById(characterId)
        return char
    }

    suspend fun addCharacter(character : Character)
    {
        withContext(Dispatchers.IO) {
            characterDao.insertCharacter(character)
        }
    }
}