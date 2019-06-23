package com.example.dznow

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_theme.*

class Theme : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val tm = ThemeManager()
        tm.applyTheme(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)

        val currentTheme = tm.getCustomTheme(this)
        if (currentTheme.equals("dark")) {
            darkBtn.isChecked = true
        }
        else {
            lightBtn.isChecked = true
        }

        closeTheme.setOnClickListener {
            finish()
        }

        lightBtn.setOnClickListener {
            storeCustomTheme("light")
            recreate()
        }

        darkBtn.setOnClickListener {
            storeCustomTheme("dark")
            recreate()
        }
    }

    private fun storeCustomTheme(theme: String) {
        val pref : SharedPreferences = getSharedPreferences("DZNowTheme", Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = pref.edit()
        editor.putString("Theme", theme)
        editor.apply()
        ThemeManager().setChanged(this, true)
    }

}
