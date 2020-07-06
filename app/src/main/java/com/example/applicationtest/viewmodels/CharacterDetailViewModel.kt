package com.example.applicationtest.viewmodels

import android.content.ClipData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationtest.database.daos.CharacterDao
import com.example.applicationtest.database.entities.Character
import com.example.applicationtest.models.Item
import com.example.applicationtest.repositories.CharacterRepository
import kotlinx.coroutines.launch
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.experimental.property.inject
import org.koin.java.KoinJavaComponent.inject

class CharacterDetailViewModel (selectedCharacterId: Int) : ViewModel(), KoinComponent {

    private val characterRepository by inject<CharacterRepository>()
    var character : Character = Character(name="",description="")

    init {
        viewModelScope.launch {
            try {
                //_loadingState.value = LoadingState.LOADING
                character = characterRepository.getCharacterById(selectedCharacterId)
                //_loadingState.value = LoadingState.LOADED
            }
            catch (e: Exception) {
                println(e.message)
            }
        }
    }
}