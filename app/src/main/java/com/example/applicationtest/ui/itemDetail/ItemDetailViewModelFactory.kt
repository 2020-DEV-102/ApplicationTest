package com.example.applicationtest.ui.itemDetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.applicationtest.models.Item

@Suppress("UNCHECKED_CAST")
class ItemDetailViewModelFactory (private val item : Item?) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ItemDetailViewModel(item!!) as T
    }
}