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

class ProductEntry : AppCompatActivity() {

    var Pro: DatabaseReference? = null
    var pronamee: AutoCompleteTextView? = null
    var pnumb: EditText? = null
    private var btnnnpro: Button? = null
    private var recyclerpro: RecyclerView? = null
    private var proadapter: ProductAdapter? = null
    private var qq12:Query?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_entry)

        Pro = FirebaseDatabase.getInstance().reference.child("ProductsList")
        pnumb = findViewById<View>(R.id.pnumb) as EditText
        pronamee = findViewById<View>(R.id.pronamee) as AutoCompleteTextView
        btnnnpro = findViewById<View>(R.id.buttonclkpro) as Button
        recyclerpro = findViewById(R.id.recyclerpro)

        recyclerpro!!.setLayoutManager(LinearLayoutManager(this))

//        val options = FirebaseRecyclerOptions.Builder<Post>()
//            .setQuery(FirebaseDatabase.getInstance().reference.child("ProductsList").orderByChild("productName"), Post::class.java)
//            .build()
//        proadapter = ProductAdapter(options, this)
//        recyclerpro!!.setAdapter(proadapter)

        qq12 = FirebaseDatabase.getInstance().reference.child("ProductsList").orderByChild("productName")
        fnquerya(qq12!!)

        btnnnpro!!.setOnClickListener(View.OnClickListener {
            if (pronamee!!.length() == 0) {
                Toast.makeText(applicationContext, "Enter Product Name", Toast.LENGTH_SHORT).show()
            } else if (pnumb!!.length() == 0) {
                Toast.makeText(applicationContext, "Enter weight", Toast.LENGTH_SHORT).show()
            } else {
                val mapCustomer55 = HashMap<String, Any>()
                mapCustomer55["productName"] = pronamee!!.getText().toString().trim { it <= ' ' }
                mapCustomer55["pnumber"] = pnumb!!.getText().toString().trim { it <= ' ' }
                //mapCustomer.put("customerAddress",address.getText().toString().trim());
                Pro!!.push()
                    .setValue(mapCustomer55).addOnCompleteListener { Log.i("completeCustomerList", "oncomplete") }.addOnFailureListener { e -> Log.i("errorCustomerList", "onFailure :$e") }
                pronamee!!.setText("")
                pnumb!!.setText("")
                val i0p0o = Intent(applicationContext, ProductEntry::class.java)
                startActivity(i0p0o)
                overridePendingTransition(0, 0)
                i0p0o.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            }
        })

        val productarraylist = ArrayList<String>()
        Pro!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (dataSnapshot1 in dataSnapshot.children) {
                    val productarray = dataSnapshot1.child("productName").value.toString()
                    //System.out.println("thisissintel  " +a101);
                    if (productarraylist.contains(productarray)) {
                    } else {
                        productarraylist.add(productarray)
                    }
                }
               // println("thisissintel23pname  $productarraylist")
                val productarrayadap = ArrayAdapter(this@ProductEntry, android.R.layout.simple_list_item_1, productarraylist)
                pronamee!!.setAdapter(productarrayadap)


            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

        pronamee!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                //  TODO("Not yet implemented")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // TODO("Not yet implemented")

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val cccname:String = pronamee!!.text.toString().trim()
               // println("cccnameee  " +cccname)

                if (cccname.isEmpty() || !productarraylist.contains(cccname) ){
                  //  println("cccnameee  t" )
                    qq12 = FirebaseDatabase.getInstance().reference.child("ProductsList").orderByChild("productName")
                    fnquerya(qq12!!)
//                    val options = FirebaseRecyclerOptions.Builder<Post>()
//                        .setQuery(FirebaseDatabase.getInstance().reference.child("CustomerList").orderByChild("customerName"), Post::class.java)
//                        .build()
//                    cusadapter = CustomerAdapter(options, this@CustomerEntry)
//                    recyclerViewcus!!.setAdapter(cusadapter)
                }
                else{
                    //println("cccnameee  f")
                    qq12 = FirebaseDatabase.getInstance().reference.child("ProductsList").orderByChild("productName").equalTo(cccname)
                    fnquerya(qq12!!)
//                    val options = FirebaseRecyclerOptions.Builder<Post>()
//                        .setQuery(FirebaseDatabase.getInstance().reference.child("CustomerList").orderByChild("customerName").equalTo(cccname), Post::class.java)
//                        .build()
//                    cusadapter = CustomerAdapter(options, this@CustomerEntry)
//                    recyclerViewcus!!.setAdapter(cusadapter)

                }

            }

        })



    }
    private fun fnquerya(qureyab: Query) {
//        val options = FirebaseRecyclerOptions.Builder<Post>()
//            .setQuery(qurey, Post::class.java)
//            .build()
//        disadapter = DispatchAdapter(options, this@Dispatched)
//        disrecycler.adapter = disadapter
//        disadapter!!.startListening()
        val options = FirebaseRecyclerOptions.Builder<Post>()
            .setQuery(qureyab, Post::class.java)
            .build()
        proadapter = ProductAdapter(options, this)
        recyclerpro!!.setAdapter(proadapter)
        proadapter!!.startListening()
    }
    override fun onStart() {
        super.onStart()
        proadapter!!.startListening()
    }

    override fun onStop() {
        super.onStop()
        proadapter!!.stopListening()
    }

    override fun onBackPressed() {
        val i1e = Intent(this, Master::class.java)
        startActivity(i1e)
        super.onBackPressed()
    }
}
