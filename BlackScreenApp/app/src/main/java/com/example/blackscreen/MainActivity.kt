package com.example.blackscreen

import android.os.Bundle
import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private var isBlackScreen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            toggleBlackScreen()
        }
    }

    private fun toggleBlackScreen() {
        if (isBlackScreen) {
            setContentView(R.layout.activity_main)
        } else {
            setContentView(R.layout.activity_black)
        }
        isBlackScreen = !isBlackScreen
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN || keyCode == KeyEvent.KEYCODE_VOLUME_UP) {
            if (isBlackScreen) {
                toggleBlackScreen()
                return true
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}