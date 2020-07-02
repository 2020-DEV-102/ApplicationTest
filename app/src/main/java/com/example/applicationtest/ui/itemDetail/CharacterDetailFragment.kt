package com.example.applicationtest.ui.itemDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.applicationtest.databinding.CharacterDetailFragmentBinding
import com.example.applicationtest.factories.ItemDetailViewModelFactory
import com.example.applicationtest.viewmodels.ItemDetailViewModel


class CharacterDetailFragment : Fragment() {

    private lateinit var binding : CharacterDetailFragmentBinding
    private var characterId : Int = 0
    private lateinit var itemDetailViewModel : ItemDetailViewModel

    companion object {
        @JvmStatic
        fun newInstance(characterId: Int) = CharacterDetailFragment().apply {
            arguments = Bundle().apply {
                putInt("CHARACTER_ID", characterId)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getInt("CHARACTER_ID")?.let {
            characterId = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myItemDetailViewModel: ItemDetailViewModel by viewModels {
            ItemDetailViewModelFactory(characterId)
        }
        itemDetailViewModel = myItemDetailViewModel

        binding = CharacterDetailFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = itemDetailViewModel
        }

        return binding.root
    }
}