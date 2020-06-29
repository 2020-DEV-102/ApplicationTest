package com.example.applicationtest.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.applicationtest.database.daos.CharacterDao
import com.example.applicationtest.database.entities.Character

class CharacterRepository constructor (private val characterDao: CharacterDao)  {

    /*private val _characters = MediatorLiveData<Array<Character>>()
    val characters: LiveData<Array<Character>>
        get() {
            return _characters
        }


    init {
        subscribeToDatabase()
    }

    private fun subscribeToDatabase() {
        val sourceDb = characterDao.getAll()
    }

    fun getCharacters() : List<Character>
    {
        return characterDao.getAll()
    }*/
}