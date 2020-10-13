package com.madappsdevlopers.padmavatisalt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.*
import java.util.ArrayList
import java.util.HashMap

class CustomerEntry : AppCompatActivity() {

    var Cus: DatabaseReference? = null
    var cusnamee: AutoCompleteTextView? = null
    var mobinamee: EditText? = null
    private var btnnn: Button? = null
    private var recyclerViewcus: RecyclerView? = null
    private var cusadapter: CustomerAdapter? = null
    private var qq1:Query?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_entry)

        Cus = FirebaseDatabase.getInstance().reference.child("CustomerList")
        mobinamee = findViewById<View>(R.id.mobinamee) as EditText
        cusnamee = findViewById<View>(R.id.cusnamee) as AutoCompleteTextView
        btnnn = findViewById<View>(R.id.buttonclk) as Button
        recyclerViewcus = findViewById(R.id.recyclercus)


        recyclerViewcus!!.setLayoutManager(LinearLayoutManager(this))


//        val options = FirebaseRecyclerOptions.Builder<Post>()
//            .setQuery(, Post::class.java)
//            .build()
//        cusadapter = CustomerAdapter(options, this)
//        recyclerViewcus!!.adapter = cusadapter
        qq1 = FirebaseDatabase.getInstance().reference.child("CustomerList").orderByChild("customerName")
        fnquerya(qq1!!)

        btnnn!!.setOnClickListener(View.OnClickListener {
            if (cusnamee!!.length() == 0) {
                Toast.makeText(applicationContext, "Enter Name", Toast.LENGTH_SHORT).show()
            } else if (mobinamee!!.length() > 25|| mobinamee!!.length() <= 9) {
                Toast.makeText(applicationContext, "Enter Mobile No. correctly", Toast.LENGTH_SHORT).show()
            } else {
                val mapCustomer = HashMap<String, Any>()
                mapCustomer["customerName"] = cusnamee!!.getText().toString().trim { it <= ' ' }
                mapCustomer["mobileNo"] = mobinamee!!.getText().toString().trim { it <= ' ' }
                //mapCustomer.put("customerAddress",address.getText().toString().trim());
                Cus!!.push()
                    .setValue(mapCustomer).addOnCompleteListener { Log.i("completeCustomerList", "oncomplete") }.addOnFailureListener { e -> Log.i("errorCustomerList", "onFailure :$e") }
                cusnamee!!.setText("")
                mobinamee!!.setText("")
                val i0p0o = Intent(applicationContext, CustomerEntry::class.java)
                startActivity(i0p0o)
                overridePendingTransition(0, 0)
                i0p0o.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            }
        })

        val customerarraylist = ArrayList<String>()
        Cus!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (dataSnapshot1 in dataSnapshot.children) {
                    val customerarray = dataSnapshot1.child("customerName").value.toString()
                    //System.out.println("thisissintel  " +a101);
                    if (customerarraylist.contains(customerarray)) {
                    } else {
                        customerarraylist.add(customerarray)
                    }
                    //  rowList.add(new RowItem(customerarray));
                }
               // println("thisissintel23cname  $customerarraylist")
                val customerarrayadap = ArrayAdapter(this@CustomerEntry, android.R.layout.simple_list_item_1, customerarraylist)
                cusnamee!!.setAdapter(customerarrayadap)

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })


        cusnamee!!.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                //  TODO("Not yet implemented")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // TODO("Not yet implemented")

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val cccname:String = cusnamee!!.text.toString().trim()
              //  println("cccnameee  " +cccname)

                if (cccname.isEmpty() || !customerarraylist.contains(cccname) ){
                  //  println("cccnameee  t" )
                    qq1 = FirebaseDatabase.getInstance().reference.child("CustomerList").orderByChild("customerName")
                    fnquerya(qq1!!)
//                    val options = FirebaseRecyclerOptions.Builder<Post>()
//                        .setQuery(FirebaseDatabase.getInstance().reference.child("CustomerList").orderByChild("customerName"), Post::class.java)
//                        .build()
//                    cusadapter = CustomerAdapter(options, this@CustomerEntry)
//                    recyclerViewcus!!.setAdapter(cusadapter)
                }
                else{
                    //println("cccnameee  f")
                    qq1 = FirebaseDatabase.getInstance().reference.child("CustomerList").orderByChild("customerName").equalTo(cccname)
                    fnquerya(qq1!!)
//                    val options = FirebaseRecyclerOptions.Builder<Post>()
//                        .setQuery(FirebaseDatabase.getInstance().reference.child("CustomerList").orderByChild("customerName").equalTo(cccname), Post::class.java)
//                        .build()
//                    cusadapter = CustomerAdapter(options, this@CustomerEntry)
//                    recyclerViewcus!!.setAdapter(cusadapter)

                }

            }

        })




    }


    private fun fnquerya(qureya: Query) {
//        val options = FirebaseRecyclerOptions.Builder<Post>()
//            .setQuery(qurey, Post::class.java)
//            .build()
//        disadapter = DispatchAdapter(options, this@Dispatched)
//        disrecycler.adapter = disadapter
//        disadapter!!.startListening()
        val options = FirebaseRecyclerOptions.Builder<Post>()
            .setQuery(qureya, Post::class.java)
            .build()
        cusadapter = CustomerAdapter(options, this)
        recyclerViewcus!!.adapter = cusadapter
        cusadapter!!.startListening()
    }

    override fun onStart() {
        super.onStart()
        //cusadapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        cusadapter!!.stopListening()
    }

    override fun onBackPressed() {
        val i1e = Intent(this, Master::class.java)
        startActivity(i1e)
        super.onBackPressed()
    }
}
