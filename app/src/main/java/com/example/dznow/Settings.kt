package com.example.dznow

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.fragment_navbars.*
import kotlinx.android.synthetic.main.fragment_navbars_text.*
import kotlinx.android.synthetic.main.fragment_settings_list.*

class Settings : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        init_navbars()
        addListeners()
        addLinks()
    }

    fun init_navbars() {
        reset()
        fragment.imageView8.setImageResource(R.drawable.settings_colored)
        fragment2.textView5.setTextColor(resources.getColor(R.color.pink))
    }

    fun reset() {
        fragment.imageView5.setImageResource(R.drawable.home)
        fragment.imageView6.setImageResource(R.drawable.news)
        fragment.imageView7.setImageResource(R.drawable.download)
        fragment.imageView8.setImageResource(R.drawable.settings)

        fragment2.textView21.setTextColor(resources.getColor(R.color.darkGrey))
        fragment2.textView3.setTextColor(resources.getColor(R.color.darkGrey))
        fragment2.textView4.setTextColor(resources.getColor(R.color.darkGrey))
        fragment2.textView5.setTextColor(resources.getColor(R.color.darkGrey))
    }

    fun addListeners() {
        fragment.imageView5.setOnClickListener {
            val dest = Intent(this, Home::class.java)
            startActivity(dest)
        }

        fragment.imageView6.setOnClickListener {
            val dest = Intent(this, News::class.java)
            startActivity(dest)
        }

        fragment.imageView7.setOnClickListener {
            val dest = Intent(this, Downloaded::class.java)
            startActivity(dest)
        }
    }

    fun addLinks() {
        fragment15.link1.setOnClickListener {
            val dest = Intent(this, Language::class.java)
            startActivity(dest)
        }
        fragment15.link2.setOnClickListener {
            val dest = Intent(this, Theme::class.java)
            startActivity(dest)
        }
        fragment15.link3.setOnClickListener {
            val dest = Intent(this, Notifications::class.java)
            startActivity(dest)
        }
    }
}
