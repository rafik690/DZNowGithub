package com.example.dznow

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_navbars.*
import kotlinx.android.synthetic.main.fragment_navbars_text.*

class Downloaded : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_downloaded)

        init_navbars()
        addListeners()
    }

    fun init_navbars() {
        reset()
        fragment.imageView7.setImageResource(R.drawable.download_colored)
        fragment2.textView4.setTextColor(resources.getColor(R.color.pink))
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

        fragment.imageView8.setOnClickListener {
            val dest = Intent(this, Settings::class.java)
            startActivity(dest)
        }
    }
}
