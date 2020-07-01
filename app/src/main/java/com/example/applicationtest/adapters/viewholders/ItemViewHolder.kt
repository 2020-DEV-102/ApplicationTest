package com.example.applicationtest.adapters.viewholders

import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationtest.databinding.ListItemBinding
import com.example.applicationtest.ui.home.HomeFragmentDirections
import com.example.applicationtest.database.entities.Character



class ItemViewHolder( private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.setClickListener {
            binding.character?.let { item ->
                //navigateToItem(item, it)
            }
        }
    }

    private fun navigateToItem(
        character: Character,
        view: View
    ) {
        /*val action = HomeFragmentDirections.actionHomeFragmentToItemDetailActivity(character.name!!, character)
        Navigation.findNavController(view).navigate(action)*/
    }

    fun bind(_character : Character) {
        binding.apply {
            character = _character
            executePendingBindings()
        }
    }
}