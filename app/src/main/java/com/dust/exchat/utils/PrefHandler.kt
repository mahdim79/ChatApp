package com.dust.exchat.utils

import android.content.Context
import javax.inject.Inject

class PrefHandler @Inject constructor(private val context: Context) {
    private val prefName = "chat_pref"
    private val pref = context.getSharedPreferences(prefName,Context.MODE_PRIVATE)

    fun setPreference(obj: Any,key:String){
        when(obj){
            is String ->{
                pref.edit().putString(key,obj).apply()
            }
            is Int ->{
                pref.edit().putInt(key,obj).apply()
            }
            is Boolean ->{
                pref.edit().putBoolean(key,obj).apply()
            }
            is Long ->{
                pref.edit().putLong(key,obj).apply()
            }
            is Float ->{
                pref.edit().putFloat(key,obj).apply()
            }
        }
    }

    fun clearAllPrefs(){
        pref.edit().clear().apply()
    }

}