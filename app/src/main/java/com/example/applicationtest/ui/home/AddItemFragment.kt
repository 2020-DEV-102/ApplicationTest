package com.example.applicationtest.ui.home

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.applicationtest.R
import com.example.applicationtest.databinding.AddItemFragmentBinding

class AddItemFragment : Fragment() {

    private lateinit var viewModel: AddItemViewModel
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

        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddItemViewModel::class.java)
        // TODO: Use the ViewModel
    }

}