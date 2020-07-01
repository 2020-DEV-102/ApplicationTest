package com.example.applicationtest.ui.itemDetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.applicationtest.databinding.ItemDetailFragmentBinding
import com.example.applicationtest.factories.ItemDetailViewModelFactory
import com.example.applicationtest.models.Item
import com.example.applicationtest.viewmodels.ItemDetailViewModel


class ItemDetailFragment : Fragment() {

    private lateinit var binding : ItemDetailFragmentBinding
    private lateinit var collBarLayout: Toolbar
    private lateinit var imageView : ImageView
    private var myItem: Item = Item()
    private lateinit var itemDetailViewModel : ItemDetailViewModel

    companion object {
        @JvmStatic
        fun newInstance(myItem: Item?) = ItemDetailFragment().apply {
            arguments = Bundle().apply {
                putSerializable("ITEM", myItem)
            }
        }
    }

    /*private val itemDetailViewModel: ItemDetailViewModel by viewModels {
        ItemDetailViewModelFactory(myItem)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getSerializable("ITEM")?.let {
            myItem = it as Item
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myItemDetailViewModel: ItemDetailViewModel by viewModels {
            ItemDetailViewModelFactory(
                myItem
            )
        }

        itemDetailViewModel = myItemDetailViewModel

        binding = ItemDetailFragmentBinding.inflate(inflater, container, false).apply {
            viewModel = itemDetailViewModel
        }

        return binding.root
    }

    /*override fun onDestroyView() {
        super.onDestroyView()
        collBarLayout.removeView(imageView)
        collBarLayout.isTitleEnabled = false
    }*/
}