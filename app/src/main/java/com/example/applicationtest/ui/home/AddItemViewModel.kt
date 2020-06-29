package com.example.applicationtest.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationtest.database.entities.Character
import com.example.applicationtest.repositories.CharacterRepository
import kotlinx.coroutines.launch

class AddItemViewModel constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    fun addCharacter(name: String, description : String) {
        var character = Character(name = name, description = description)
        viewModelScope.launch {
            try {
                //_loadingState.value = LoadingState.LOADING
                characterRepository.addCharacter(character)
                //_loadingState.value = LoadingState.LOADED
            } catch (e: Exception) {
                //_loadingState.value = LoadingState.error(e.message)
            }
        }
    }
}