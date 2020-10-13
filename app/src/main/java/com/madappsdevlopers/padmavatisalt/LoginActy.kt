package com.madappsdevlopers.padmavatisalt

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.google.firebase.messaging.FirebaseMessaging

class LoginActy : AppCompatActivity() {

    var editpass: EditText? = null
    var sendpass: Button? = null
    var auth: DatabaseReference? = null
    var progb: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_acty)

        FirebaseMessaging.getInstance().unsubscribeFromTopic("/topics/maddy123")

        auth = FirebaseDatabase.getInstance().getReference().child("Auth")
        editpass = findViewById<View>(R.id.editpass) as EditText
        sendpass = findViewById<View>(R.id.sendpass) as Button
        progb = findViewById<View>(R.id.progressBar) as ProgressBar

        sendpass!!.isEnabled= false
        var devlist = ArrayList<String>()
        auth!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (dataSnapshot1 in dataSnapshot.children) {
                    val dev = dataSnapshot1.child("key").value.toString()
                    devlist.add(dev)
                }
                sendpass!!.isEnabled= true

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

        sendpass!!.setOnClickListener {

            if (devlist.contains(editpass!!.text.toString())){

                val mas132 = Intent(applicationContext, MainActivity::class.java)
                startActivity(mas132)

                FirebaseMessaging.getInstance().subscribeToTopic("/topics/maddy123")
                finish()

                val shared = Shared(applicationContext)
                shared.second(editpass!!.getText().toString())

            }

            else{
                Toast.makeText(applicationContext, "Password is wrong", Toast.LENGTH_SHORT)
                    .show()
            }

        }






    }

    override fun onBackPressed() {
        super.onBackPressed()
        val mas132 = Intent(applicationContext, LoginActy::class.java)
        startActivity(mas132)
        overridePendingTransition(0, 0)
        mas132.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
    }
}
