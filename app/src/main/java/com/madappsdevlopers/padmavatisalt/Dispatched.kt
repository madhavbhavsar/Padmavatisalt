package com.madappsdevlopers.padmavatisalt

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.*
import java.util.*

class Dispatched : AppCompatActivity() {

    private lateinit var disrecycler: RecyclerView
    private var disadapter: DispatchAdapter? = null
    private var aabbc: LinearLayoutManager? = null
    private var searchh: AutoCompleteTextView? = null
    private var qurey:Query?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dispatched)

        searchh = findViewById<AutoCompleteTextView>(R.id.searchh)


        disrecycler = findViewById<RecyclerView>(R.id.recyclerDispatched)
        aabbc = LinearLayoutManager(this)
        aabbc!!.stackFromEnd = true
        //  mLayoutManager.setReverseLayout(false); // THIS ALSO SETS setStackFromBottom to true
        disrecycler.setLayoutManager(aabbc)

        val customerarraylist = ArrayList<String>()
        FirebaseDatabase.getInstance().getReference().child("DispatchList")!!.addValueEventListener(object : ValueEventListener {
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

                val customerarrayadap = ArrayAdapter(this@Dispatched, android.R.layout.simple_list_item_1, customerarraylist)
                searchh!!.setAdapter(customerarrayadap)

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

        qurey = FirebaseDatabase.getInstance().getReference().child("DispatchList")
        fnquery(qurey!!)

        searchh!!.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (searchh!!.text.toString().isEmpty()) {
                    qurey = FirebaseDatabase.getInstance().reference.child("DispatchList")
                    fnquery(qurey!!)
                } else {
                    qurey = FirebaseDatabase.getInstance().reference.child("DispatchList").orderByChild("customerName").equalTo(searchh!!.text.toString())
                    fnquery(qurey!!)
                }
                return@OnEditorActionListener true
            }
            false
        })

        searchh!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                //  TODO("Not yet implemented")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // TODO("Not yet implemented")

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val cccname:String = searchh!!.text.toString().trim()
               // println("cccnameee  " +cccname)

                if (cccname.isEmpty() || !customerarraylist.contains(cccname) ){
                   // println("cccnameee  t" )
//                    qq1 = FirebaseDatabase.getInstance().reference.child("CustomerList").orderByChild("customerName")
//                    fnquerya(qq1!!)
                    qurey = FirebaseDatabase.getInstance().reference.child("DispatchList")
                    fnquery(qurey!!)
//                    val options = FirebaseRecyclerOptions.Builder<Post>()
//                        .setQuery(FirebaseDatabase.getInstance().reference.child("CustomerList").orderByChild("customerName"), Post::class.java)
//                        .build()
//                    cusadapter = CustomerAdapter(options, this@CustomerEntry)
//                    recyclerViewcus!!.setAdapter(cusadapter)
                }
                else{
                    //println("cccnameee  f")
//                    qq1 = FirebaseDatabase.getInstance().reference.child("CustomerList").orderByChild("customerName").equalTo(cccname)
//                    fnquerya(qq1!!)
                    qurey = FirebaseDatabase.getInstance().reference.child("DispatchList").orderByChild("customerName").equalTo(cccname)
                    fnquery(qurey!!)
//                    val options = FirebaseRecyclerOptions.Builder<Post>()
//                        .setQuery(FirebaseDatabase.getInstance().reference.child("CustomerList").orderByChild("customerName").equalTo(cccname), Post::class.java)
//                        .build()
//                    cusadapter = CustomerAdapter(options, this@CustomerEntry)
//                    recyclerViewcus!!.setAdapter(cusadapter)

                }

            }

        })



    }

    private fun fnquery(qurey: Query) {
        val options = FirebaseRecyclerOptions.Builder<Post>()
            .setQuery(qurey, Post::class.java)
            .build()
        disadapter = DispatchAdapter(options, this@Dispatched)
        disrecycler.adapter = disadapter
        disadapter!!.startListening()
    }

//    override fun onStart() {
//        super.onStart()
//        disadapter!!.startListening()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        disadapter!!.stopListening()
//    }

    override fun onBackPressed() {
        disadapter!!.stopListening()
        val i1 = Intent(this, MainActivity::class.java)
        startActivity(i1)
        super.onBackPressed()
    }
}
