package com.example.applicationtest.ui.itemDetail

import android.content.ClipData
import androidx.lifecycle.ViewModel
import com.example.applicationtest.models.Item

class ItemDetailViewModel (selectedItem: Item) : ViewModel() {

    val item = selectedItem
}