package com.example.dznow

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // We simulate the time that the app needs to retrieve the data needed
        val bg = object : Thread() {
            override fun run() = try {
                Thread.sleep(2000)
                val toHome = Intent(baseContext, Home::class.java)
                startActivity(toHome)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        bg.start()
    }

    override fun onResume() {
        window.decorView.apply {
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }

        super.onResume()
    }

    fun init() {

    }
}
