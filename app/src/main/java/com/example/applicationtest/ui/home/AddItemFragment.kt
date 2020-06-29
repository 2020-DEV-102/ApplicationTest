package com.example.applicationtest.ui.home

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.example.applicationtest.databinding.AddItemFragmentBinding
import com.example.applicationtest.utilities.ContextExtensions
import com.example.applicationtest.utilities.ContextExtensions.hideKeyboard
import org.koin.androidx.viewmodel.ext.android.viewModel


class AddItemFragment : Fragment() {

    private val addItemViewModel: AddItemViewModel by viewModel()
    private lateinit var binding : AddItemFragmentBinding

    companion object {
        fun newInstance() = AddItemFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddItemFragmentBinding.inflate(inflater, container, false )

        binding.addItemButton.setOnClickListener()
        {
            addItemViewModel.addCharacter(binding.name.text.toString(), binding.description.text.toString() )
            hideKeyboard()
        }

        binding.root.setOnClickListener()
        {
            hideKeyboard()
        }
        return binding.root
    }
}