package com.madappsdevlopers.padmavatisalt


import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {
    private var nList: Button? = null
    private var master: Button? = null
    private var pList: Button? = null
    private var dList: Button? = null
    private var remList: Button? = null
    private var bank: Button? = null
    var Anon: DatabaseReference? = null


    fun onbutton() {
        nList!!.isEnabled = true
        pList!!.isEnabled = true
        dList!!.isEnabled = true
        master!!.isEnabled = true
        bank!!.isEnabled = true
        remList!!.isEnabled = true

        nList!!.visibility = View.VISIBLE
        pList!!.visibility = View.VISIBLE
        dList!!.visibility = View.VISIBLE
        master!!.visibility = View.VISIBLE
        bank!!.visibility = View.VISIBLE
        remList!!.visibility = View.VISIBLE

        FirebaseMessaging.getInstance().subscribeToTopic("/topics/maddy1234")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        FirebaseMessaging.getInstance().subscribeToTopic("/topics/maddy1234")
        nList = findViewById<View>(R.id.nlist) as Button
        pList = findViewById<View>(R.id.plist) as Button
        dList = findViewById<View>(R.id.dlist) as Button
        remList = findViewById<View>(R.id.remList) as Button
        master = findViewById<View>(R.id.master) as Button
        bank = findViewById<View>(R.id.sendbankdetail) as Button

        nList!!.isEnabled = true
        pList!!.isEnabled = true
        dList!!.isEnabled = true
        master!!.isEnabled = true
        bank!!.isEnabled = true
        remList!!.isEnabled = true


        var devlist21 = ArrayList<String>()
        //  bool = false
        FirebaseDatabase.getInstance().getReference().child("Auth")!!
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    for (dataSnapshot1 in dataSnapshot.children) {
                        val dev = dataSnapshot1.child("key").value.toString()
                        devlist21.add(dev)

                    }
                    val shared = Shared(applicationContext)
                    shared.first(devlist21, this@MainActivity)

                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })

//                nList!!.isEnabled = true
//                pList!!.isEnabled = true
//                dList!!.isEnabled = true
//                master!!.isEnabled = true
//                bank!!.isEnabled = true
//                remList!!.isEnabled = true
//
//                val shared2 = Shared(applicationContext)

//                do {
//                    bool = devlist21.contains(shared2.sharedPreferences.getString("lock","returnednull"))
//                    System.out.println("thisismadddd "+bool)
//
//                }while (bool==false)

        //               nList!!.isEnabled = true


        bank!!.setOnClickListener {
            val mas = Intent(applicationContext, Bankdetails::class.java)
            startActivity(mas)
        }


        master!!.setOnClickListener {
            val mas = Intent(applicationContext, Master::class.java)
            startActivity(mas)
        }



        Anon = FirebaseDatabase.getInstance().reference.child("Anonymous")
        nList!!.setOnClickListener {
            Anon!!.addValueEventListener(object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    val sss: String
                    sss = dataSnapshot.child("renew").value.toString()
                    val vvvv: String
                    vvvv = dataSnapshot.child("version").value.toString()
                    // println("Locked Please Renewwwwww$sss")
                    try {
                        val formatter = SimpleDateFormat("dd/MM/yyyy")
                        val date12 = formatter.parse(sss)
                        val str2 =
                            SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(Date())
                        // println("Locked Please Renew$str2")
                        val date2 = formatter.parse(str2)
                        if (vvvv != "1") {
                            Toast.makeText(
                                applicationContext,
                                "Locked Old Version",
                                Toast.LENGTH_SHORT
                            ).show()
                            pList!!.isEnabled = false
                            master!!.isEnabled = false
                            dList!!.isEnabled = false
                            remList!!.isEnabled = false
                            bank!!.isEnabled = false
                        } else if (date12.compareTo(date2) <= 0) {
                            Toast.makeText(
                                applicationContext,
                                "Locked Please Renew",
                                Toast.LENGTH_SHORT
                            ).show()
                            //System.out.println("date2 is Greater than my date1");
                        } else {
                            functionNewList()
                        }
                    } catch (e: ParseException) {
                        e.printStackTrace()
                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {}
            })
        }
        pList!!.setOnClickListener { functionPendingList() }
        dList!!.setOnClickListener { functionDisList() }
        remList!!.setOnClickListener { funrem() }
        val t2: Thread = object : Thread() {
            override fun run() {
                while (!isInterrupted) {
                    try {
                        sleep(5000)
                        runOnUiThread {
                            if (isOnline) {
                                findViewById<View>(R.id.nointernet).visibility =
                                    View.INVISIBLE // Online
                            } else {
                                findViewById<View>(R.id.nointernet).visibility =
                                    View.VISIBLE // Disconnected
                            }
                        }
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
        }
        t2.start()
    }

    private fun funrem() {
        val iio = Intent(this, DeleteList::class.java)
        startActivity(iio)
    }

    fun functionNewList() {
        val intent = Intent(this, NewList::class.java)
        startActivity(intent)
    }

    fun functionPendingList() {


        val intent = Intent(this, PendingList::class.java)
        startActivity(intent)
    }

    fun functionDisList() {
        val intent = Intent(this, Dispatched::class.java)
        startActivity(intent)
    }


    //Log.e(TAG, e.getMessage());
    val isOnline: Boolean
        get() {
            var connected = false
            try {
                val connectivityManager =
                    applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkInfo = connectivityManager.activeNetworkInfo
                connected =
                    networkInfo != null && networkInfo.isAvailable && networkInfo.isConnected
                return connected
            } catch (e: Exception) {
                //Log.e(TAG, e.getMessage());
            }
            return connected
        }

    override fun onBackPressed() {
        if (back_pressed + TIME_DELAY > System.currentTimeMillis()) {
            val io = Intent(Intent.ACTION_MAIN)
            io.addCategory(Intent.CATEGORY_HOME)
            io.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(io)
            finish()
        } else {
            Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show()
        }
        back_pressed = System.currentTimeMillis()
        //super.onBackPressed();
    }

    companion object {
        private const val TIME_DELAY = 2000
        private var back_pressed: Long = 0
    }
}
        

