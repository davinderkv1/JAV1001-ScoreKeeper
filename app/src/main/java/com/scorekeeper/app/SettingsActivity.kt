package com.scorekeeper.app

import android.content.Context
import android.os.Bundle
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        val toggleSwitch = findViewById<Switch>(R.id.toggle_switch)

        val sharedPrefs = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val isToggleOn = sharedPrefs.getBoolean("toggleState", false)
        toggleSwitch.isChecked = isToggleOn

        toggleSwitch.setOnCheckedChangeListener { _, isChecked ->
            val editor = sharedPrefs.edit()
            editor.putBoolean("toggleState", isChecked)
            editor.apply()
        }
    }
}
