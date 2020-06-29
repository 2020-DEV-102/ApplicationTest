package com.example.applicationtest.adapters.viewholders

import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationtest.ItemDetailActivity
import com.example.applicationtest.MainActivity
import com.example.applicationtest.databinding.ListItemBinding
import com.example.applicationtest.models.Item
import com.example.applicationtest.ui.home.HomeFragmentDirections


class ItemViewHolder( private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.setClickListener {
            binding.item?.let { item ->
                navigateToItem(item, it)
            }
        }
    }

    private fun navigateToItem(
        item: Item,
        view: View
    ) {
        val action = HomeFragmentDirections.actionHomeFragmentToItemDetailActivity(item.name!!, item)
        Navigation.findNavController(view).navigate(action)
    }

    fun bind(_item: Item) {
        binding.apply {
            item = _item
            executePendingBindings()
        }
    }
}