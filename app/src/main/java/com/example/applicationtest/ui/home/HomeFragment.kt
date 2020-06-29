package com.example.applicationtest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.applicationtest.adapters.ItemAdapter
import com.example.applicationtest.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var itemsRecyclerView: RecyclerView
    private val homeViewModel: HomeViewModel by viewModel()
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View?
    {
        //homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = ItemAdapter()
        binding.applicationsList.adapter = adapter

        homeViewModel.getItems().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        binding.monBouton.setOnClickListener {
            homeViewModel.updateItems()
        }

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textHome.text = it
        })
        return binding.root
    }
}