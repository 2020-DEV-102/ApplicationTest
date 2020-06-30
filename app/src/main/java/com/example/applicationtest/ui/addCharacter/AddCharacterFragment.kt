package com.example.applicationtest.ui.addCharacter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.applicationtest.databinding.AddCharacterFragmentBinding
import com.example.applicationtest.utilities.ContextExtensions.hideKeyboard
import com.example.applicationtest.viewmodels.AddCharacterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddCharacterFragment : Fragment() {

    private val addCharacterViewModel: AddCharacterViewModel by viewModel()
    private lateinit var binding : AddCharacterFragmentBinding

    companion object {
        fun newInstance() =
            AddCharacterFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddCharacterFragmentBinding.inflate(inflater, container, false )

        binding.addItemButton.setOnClickListener()
        {
            addCharacterViewModel.addCharacter(binding.name.text.toString(), binding.description.text.toString() )
            hideKeyboard()
        }

        binding.root.setOnClickListener()
        {
            hideKeyboard()
        }
        return binding.root
    }
}