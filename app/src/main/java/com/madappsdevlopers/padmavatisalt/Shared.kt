package com.madappsdevlopers.padmavatisalt

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import java.util.*

class Shared(var ccont9: Context) {
    var sharedPreferences: SharedPreferences
    var editor: SharedPreferences.Editor

    fun second(keyoflock: String?) {
        editor.putString("lock", keyoflock)
        editor.commit()
    }

    fun first(dl: ArrayList<*>,activity: MainActivity) {


        if (!dl.contains(ss())) {

            val inni = Intent(ccont9, LoginActy::class.java)
            inni.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            inni.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            inni.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            ccont9.startActivity(inni)
        }
        else{

          activity.onbutton()

        }
    }

    private fun ss(): String? {
        return sharedPreferences.getString("lock", "returnednull")
    }

    init {
        sharedPreferences =
            ccont9.getSharedPreferences("systemfiles", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }
}