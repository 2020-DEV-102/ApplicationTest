package com.example.applicationtest.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.applicationtest.models.Item
import com.example.applicationtest.viewmodels.ItemDetailViewModel

@Suppress("UNCHECKED_CAST")
class ItemDetailViewModelFactory (private val item : Item?) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ItemDetailViewModel(item!!) as T
    }
}