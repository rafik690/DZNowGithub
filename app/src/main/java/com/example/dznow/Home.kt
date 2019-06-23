package com.example.dznow

import android.annotation.SuppressLint
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.os.ConfigurationCompat
import android.util.TypedValue
import com.example.dznow.R.color.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_latest_news.*
import kotlinx.android.synthetic.main.fragment_navbars.*
import kotlinx.android.synthetic.main.fragment_navbars_text.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val tm = ThemeManager()
        tm.applyTheme(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        init_navbars()
        addListeners()
    }

    override fun onResume() {
        super.onResume()
        if (ThemeManager().getChanged(this)) {
            ThemeManager().setChanged(this, false)
            recreate()
        }
    }

    @SuppressLint("ResourceAsColor")
    fun init_navbars() {
        reset()
        fragment.imageView5.setImageResource(R.drawable.home_colored)
        fragment2.textView21.setTextColor(resources.getColor(pink))
    }

    fun reset() {
        fragment.imageView5.setImageResource(R.drawable.home)
        fragment.imageView6.setImageResource(R.drawable.news)
        fragment.imageView7.setImageResource(R.drawable.download)
        fragment.imageView8.setImageResource(R.drawable.settings)

        fragment2.textView21.setTextColor(resources.getColor(darkGrey))
        fragment2.textView3.setTextColor(resources.getColor(darkGrey))
        fragment2.textView4.setTextColor(resources.getColor(darkGrey))
        fragment2.textView5.setTextColor(resources.getColor(darkGrey))
    }

    fun addListeners() {
        fragment.imageView6.setOnClickListener {
            val dest = Intent(baseContext, News::class.java)
            startActivity(dest)
        }

        fragment.imageView7.setOnClickListener {
            val dest = Intent(this, Downloaded::class.java)
            startActivity(dest)
        }

        fragment.imageView8.setOnClickListener {
            val dest = Intent(this, Settings::class.java)
            startActivity(dest)
        }
        fragment10.lay1.setOnClickListener {
            val dest = Intent(this, ArticleActivity::class.java)
            startActivity(dest)
        }
    }
}
