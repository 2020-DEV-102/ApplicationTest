package com.example.applicationtest.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.applicationtest.database.entities.Character
import com.example.applicationtest.models.Item
import com.example.applicationtest.repositories.CharacterRepository
import com.example.applicationtest.repositories.Resource
import kotlinx.coroutines.launch

class HomeViewModel constructor(
    private val characterRepository: CharacterRepository
) : ViewModel() {

    val characters: LiveData<Resource<Array<Character>>> = characterRepository.characters

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private var items = MutableLiveData<List<Item>>().apply {

        val item1 = Item()
        item1.id = 0
        item1.name = "name1"
        item1.description = "desc1"

        val item2 = Item()
        item2.id = 1
        item2.name = "name2"
        item2.description = "desc2"

        var itemDatas = listOf(item1, item2)

        value = itemDatas
    }

    fun getItems(): LiveData<List<Item>> {
        return items
    }

    private fun addCharacter() {
        viewModelScope.launch {
            try {
                //_loadingState.value = LoadingState.LOADING
                //characterRepository.addCharacter()
                //_loadingState.value = LoadingState.LOADED
            } catch (e: Exception) {
                //_loadingState.value = LoadingState.error(e.message)
            }
        }
    }

    fun updateItems()
    {
        Log.d("TAG", "test");
        _text.value = "toto";
        var toto = "toto"

        addCharacter()
    }
}