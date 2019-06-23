package com.example.dznow

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_news.*
import kotlinx.android.synthetic.main.fragment_navbars.*
import kotlinx.android.synthetic.main.fragment_navbars_text.*
import kotlinx.android.synthetic.main.fragment_topics_list.*

class News : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val tm = ThemeManager()
        tm.applyTheme(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val firstFragment = international()

        firstFragment.arguments = intent.extras

        supportFragmentManager.beginTransaction()
            .add(R.id.scrollArticles, firstFragment).commit()

        initNavbars()
        addListeners()
        initTopics()
    }

    override fun onResume() {
        super.onResume()
        if (ThemeManager().getChanged(this)) {
            ThemeManager().setChanged(this, false)
            recreate()
        }
    }

    fun initNavbars() {
        reset()
        fragment.imageView6.setImageResource(R.drawable.news_colored)
        fragment2.textView3.setTextColor(resources.getColor(R.color.pink))
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

        fragment.imageView7.setOnClickListener {
            val dest = Intent(this, Downloaded::class.java)
            startActivity(dest)
        }

        fragment.imageView8.setOnClickListener {
            val dest = Intent(this, Settings::class.java)
            startActivity(dest)
        }

        /** Topics Navbar*/

        fragment9.textView10.setOnClickListener {
            resetTopics()
            setStyle(fragment9.textView10, R.color.white, R.color.colorAccentLight)

            val newFrag = international()
            replaceFrag(newFrag)
        }
        fragment9.secondTopic.setOnClickListener {
            resetTopics()
            setStyle(fragment9.secondTopic, R.color.white, R.color.colorAccentLight)

            val newFrag = culture()
            replaceFrag(newFrag)
        }
        fragment9.textView13.setOnClickListener {
            resetTopics()
            setStyle(fragment9.textView13, R.color.white, R.color.colorAccentLight)

            val newFrag = sports()
            replaceFrag(newFrag)
        }
        fragment9.textView14.setOnClickListener {
            resetTopics()
            setStyle(fragment9.textView14, R.color.white, R.color.colorAccentLight)

            val newFrag = politics()
            replaceFrag(newFrag)
        }
        fragment9.textView15.setOnClickListener {
            resetTopics()
            setStyle(fragment9.textView15, R.color.white, R.color.colorAccentLight)

            val newFrag = economy()
            replaceFrag(newFrag)
        }
    }

    fun initTopics() {
        resetTopics()
        setStyle(fragment9.textView10, R.color.white, R.color.colorAccentLight)
    }

    fun resetTopics() {
        setStyle(fragment9.textView10, R.color.darkGrey, R.color.white)
        setStyle(fragment9.secondTopic, R.color.darkGrey, R.color.white)
        setStyle(fragment9.textView13, R.color.darkGrey, R.color.white)
        setStyle(fragment9.textView14, R.color.darkGrey, R.color.white)
        setStyle(fragment9.textView15, R.color.darkGrey, R.color.white)
    }

    fun setStyle(view : TextView, text : Int, bg : Int) {
        view.setTextColor(resources.getColor(text))
        view.setBackgroundColor(resources.getColor(bg))
    }

    fun replaceFrag(newFrag : Fragment) {
        val transaction = supportFragmentManager.beginTransaction().apply {
            replace(R.id.scrollArticles, newFrag)
            addToBackStack(null)
        }

        transaction.commit();
    }
}
