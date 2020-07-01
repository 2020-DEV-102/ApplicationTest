package com.example.applicationtest.activities

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.navArgs
import com.example.applicationtest.R
import com.example.applicationtest.ui.itemDetail.ItemDetailFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class ItemDetailActivity : NavigableActivity() {

    private val args: ItemDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(findViewById(R.id.item_toobar))

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = args.title

        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container_detail, ItemDetailFragment.newInstance(args.itemArg)).commit()

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}