package com.example.applicationtest.activities

import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.navArgs
import com.example.applicationtest.R
import com.example.applicationtest.ui.itemDetail.CharacterDetailFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar


class CharacterDetailActivity : NavigableActivity() {

    private val args: CharacterDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)
        setSupportActionBar(findViewById(R.id.item_toobar))

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "nom du personnage"

        val manager: FragmentManager = supportFragmentManager
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.replace(R.id.fragment_container_detail, CharacterDetailFragment.newInstance(args.characterId)).commit()

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }
}