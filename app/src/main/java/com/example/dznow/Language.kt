package com.example.dznow

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.os.ConfigurationCompat
import android.util.DisplayMetrics
import kotlinx.android.synthetic.main.activity_language.*
import java.util.*

class Language : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
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
    }

    fun langChange() {
        fr.setOnClickListener {
            val res = resources
            val ds = res.displayMetrics
            val conf = res.configuration
            conf.setLocale(Locale("fr"))
            res.updateConfiguration(conf, ds)
        }
        ar.setOnClickListener {
            val res = resources
            val ds = res.displayMetrics
            val conf = res.configuration
            conf.setLocale(Locale("ar"))
            res.updateConfiguration(conf, ds)
        }
        en.setOnClickListener {
            val res = resources
            val ds = res.displayMetrics
            val conf = res.configuration
            conf.setLocale(Locale("en"))
            res.updateConfiguration(conf, ds)
        }
    }
}
