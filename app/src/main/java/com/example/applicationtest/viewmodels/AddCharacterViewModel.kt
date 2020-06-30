package com.example.applicationtest.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationtest.database.entities.Character
import com.example.applicationtest.repositories.CharacterRepository
import kotlinx.coroutines.launch

class AddCharacterViewModel constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    fun addCharacter(name: String, description : String) {
        viewModelScope.launch {
            try {
                //_loadingState.value = LoadingState.LOADING
                characterRepository.addCharacter(character = Character(name = name, description = description))
                //_loadingState.value = LoadingState.LOADED
            } catch (e: Exception) {
                //_loadingState.value = LoadingState.error(e.message)
            }
        }
    }
}