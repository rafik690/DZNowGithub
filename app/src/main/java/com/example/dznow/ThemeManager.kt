package com.example.dznow

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.support.v4.os.ConfigurationCompat
import android.util.TypedValue
import android.widget.Toast
import java.util.*

class ThemeManager {

    fun getCustomTheme(activity: Activity): String {
        val pref : SharedPreferences = activity.getSharedPreferences("DZNowTheme", Context.MODE_PRIVATE)
        return pref.getString("Theme", "light") ?: return "light"
    }

    fun applyTheme(activity: Activity) {
        val theme = getCustomTheme(activity)
        if (theme.equals("light")) {
            activity.setTheme(R.style.AppTheme_light)
        }
        else if (theme.equals("dark")) {
            activity.setTheme(R.style.AppTheme_dark)
        }

        val lang = getLanguage(activity)
        val res = activity.resources
        val conf = res.configuration
        conf.setLocale(Locale(lang))
        res.updateConfiguration(conf, res.displayMetrics)
    }

    fun getLanguage(activity: Activity): String {
        val pref : SharedPreferences = activity.getSharedPreferences("DZNowTheme", Context.MODE_PRIVATE)
        return pref.getString("Language", "en") ?: return "en"
    }

    fun setChanged(activity: Activity, bool : Boolean) {
        val pref : SharedPreferences = activity.getSharedPreferences("DZNowTheme", Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = pref.edit()
        editor.putBoolean("Changed", bool)
        editor.apply()
    }

    fun getChanged(activity: Activity): Boolean {
        val pref : SharedPreferences = activity.getSharedPreferences("DZNowTheme", Context.MODE_PRIVATE)
        return pref.getBoolean("Changed", false)
    }

}