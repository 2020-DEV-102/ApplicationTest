package com.example.applicationtest.adapters.viewholders

import android.view.View
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationtest.ui.home.HomeFragmentDirections
import com.example.applicationtest.database.entities.Character
import com.example.applicationtest.databinding.ListCharacterBinding


class CharacterViewHolder(private val binding: ListCharacterBinding) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.setClickListener {
            binding.character?.let { character ->
                navigateToCharacterDescription(character, it)
            }
        }
    }

    private fun navigateToCharacterDescription(
        character: Character,
        view: View
    ) {
        val action = HomeFragmentDirections.actionHomeFragmentToItemDetailActivity(character.cid)
        Navigation.findNavController(view).navigate(action)
    }

    fun bind(_character : Character) {
        binding.apply {
            character = _character
            executePendingBindings()
        }
    }
}