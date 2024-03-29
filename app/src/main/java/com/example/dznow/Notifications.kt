package com.example.dznow

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notifications.*

class Notifications : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val tm = ThemeManager()
        tm.applyTheme(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notifications)

        closeNotif.setOnClickListener {
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        if (ThemeManager().getChanged(this)) {
            ThemeManager().setChanged(this, false)
            recreate()
        }
    }
}
