package com.madappsdevlopers.padmavatisalt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class Master : AppCompatActivity() {

    private var ccc: Button? = null
    private var ppp: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_master)

        ccc = findViewById<View>(R.id.buttoncustomerlist) as Button
        ppp = findViewById<View>(R.id.buttonproductlist) as Button

        ccc!!.setOnClickListener {
            val mas1 = Intent(applicationContext, CustomerEntry::class.java)
            startActivity(mas1)
        }
        ppp!!.setOnClickListener {
            val mas2 = Intent(applicationContext, ProductEntry::class.java)
            startActivity(mas2)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val i1e = Intent(this, MainActivity::class.java)
        startActivity(i1e)

    }


}
