package com.example.dznow
import android.content.Context
import android.content.SharedPreferences
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.os.ConfigurationCompat
import android.util.DisplayMetrics
import kotlinx.android.synthetic.main.activity_language.*
import java.util.*

class Language : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val tm = ThemeManager()
        tm.applyTheme(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)
        langChange()
        val loc = ConfigurationCompat.getLocales(resources.configuration).get(0)
        if (loc.language == "fr") {
            fr.isChecked = true
        }
        else if (loc.language == "ar") {
            ar.isChecked = true
        }
        else {
            en.isChecked = true
        }

        closeLanguage.setOnClickListener {
            finish()
        }
    }

    fun langChange() {
        fr.setOnClickListener {
            val res = resources
            val conf = res.configuration
            conf.setLocale(Locale("fr"))
            res.updateConfiguration(conf, res.displayMetrics)
            storeLanguage("fr")
            recreate()
        }
        ar.setOnClickListener {
            val res = resources
            val conf = res.configuration
            conf.setLocale(Locale("ar"))
            res.updateConfiguration(conf, res.displayMetrics)
            storeLanguage("ar")
            recreate()
        }
        en.setOnClickListener {
            val res = resources
            val conf = res.configuration
            conf.setLocale(Locale("en"))
            res.updateConfiguration(conf, res.displayMetrics)
            storeLanguage("en")
            recreate()
        }
    }

    fun storeLanguage(language : String) {
        val pref : SharedPreferences = getSharedPreferences("DZNowTheme", Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = pref.edit()
        editor.putString("Language", language)
        editor.apply()
        ThemeManager().setChanged(this, true)
    }
}
