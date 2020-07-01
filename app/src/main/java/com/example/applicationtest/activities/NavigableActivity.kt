package com.example.applicationtest.activities

import android.view.KeyEvent
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

open class NavigableActivity : AppCompatActivity() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        onBackPressed()
        return true
    }

    override fun onKeyUp(keyCode: Int, objEvent: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed()
            return true
        }
        return super.onKeyUp(keyCode, objEvent)
    }

    override fun onBackPressed() {
        finish()
    }
}