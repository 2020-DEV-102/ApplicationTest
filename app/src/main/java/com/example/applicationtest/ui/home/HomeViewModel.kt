package com.example.applicationtest.ui.home

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.applicationtest.database.entities.Character
import com.example.applicationtest.models.Item
import com.example.applicationtest.repositories.CharacterRepository
import com.example.applicationtest.services.APIManager
import com.example.applicationtest.services.IItemsService
import com.example.applicationtest.services.ItemsRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.net.ConnectException
import java.util.Calendar.getInstance
import javax.inject.Inject

class HomeViewModel /*@Inject constructor(
    private val characterRepository: CharacterRepository
)*/ : ViewModel() {

    //val cRepository = characterRepository

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

       /* var sub = ItemsRepository.getInstance().provideItems()?.subscribe({
            value = it
        }, {
            Log.d(TAG, it.message!!)
        })*/
    }

    /*fun getCharacters() : List<Character>
    {
        return characterRepository.getCharacters()
    }*/

    fun getItems(): LiveData<List<Item>> {
        return items
    }

    fun updateItems()
    {
        Log.d("TAG", "test");
        _text.value = "toto";
        var toto = "toto"
    }
}