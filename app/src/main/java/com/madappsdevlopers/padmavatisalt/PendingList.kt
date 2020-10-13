package com.madappsdevlopers.padmavatisalt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.*
import java.util.ArrayList

class PendingList : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var adapter: PostAdapter? = null
    private var mLayoutManager: LinearLayoutManager? = null

    private var searchhp: AutoCompleteTextView? = null
    private var qureyp: Query?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending_list)

        searchhp = findViewById<AutoCompleteTextView>(R.id.searchhp)

        recyclerView = findViewById<RecyclerView>(R.id.recycler)
        mLayoutManager = LinearLayoutManager(this)
        mLayoutManager!!.stackFromEnd = true
        //  mLayoutManager.setReverseLayout(false); // THIS ALSO SETS setStackFromBottom to true
        recyclerView.setLayoutManager(mLayoutManager)
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        val options = FirebaseRecyclerOptions.Builder<Post>()
//            .setQuery(FirebaseDatabase.getInstance().reference.child("Post"), Post::class.java)
//            .build()
//        adapter = PostAdapter(options, this)
//        recyclerView.setAdapter(adapter)

        val customerarraylist = ArrayList<String>()
        FirebaseDatabase.getInstance().getReference().child("Post")!!.addValueEventListener(object :
            ValueEventListener {
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

                val customerarrayadap = ArrayAdapter(this@PendingList, android.R.layout.simple_list_item_1, customerarraylist)
                searchhp!!.setAdapter(customerarrayadap)

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

        qureyp = FirebaseDatabase.getInstance().getReference().child("Post")
        fnquery(qureyp!!)

        searchhp!!.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (searchhp!!.text.toString().isEmpty()) {
                    qureyp = FirebaseDatabase.getInstance().reference.child("Post")
                    fnquery(qureyp!!)
                } else {
                    qureyp = FirebaseDatabase.getInstance().reference.child("Post")
                        .orderByChild("customerName").equalTo(searchhp!!.text.toString())
                    fnquery(qureyp!!)
                }
                return@OnEditorActionListener true
            }
            false
        })

        searchhp!!.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                //  TODO("Not yet implemented")
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // TODO("Not yet implemented")

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val cccname:String = searchhp!!.text.toString().trim()
              //  println("cccnameee  " +cccname)

                if (cccname.isEmpty() || !customerarraylist.contains(cccname) ){
                //    println("cccnameee  t" )
//                    qq1 = FirebaseDatabase.getInstance().reference.child("CustomerList").orderByChild("customerName")
//                    fnquerya(qq1!!)
                    qureyp = FirebaseDatabase.getInstance().reference.child("Post")
                    fnquery(qureyp!!)
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
                    qureyp = FirebaseDatabase.getInstance().reference.child("Post")
                        .orderByChild("customerName").equalTo(cccname)
                    fnquery(qureyp!!)
//                    val options = FirebaseRecyclerOptions.Builder<Post>()
//                        .setQuery(FirebaseDatabase.getInstance().reference.child("CustomerList").orderByChild("customerName").equalTo(cccname), Post::class.java)
//                        .build()
//                    cusadapter = CustomerAdapter(options, this@CustomerEntry)
//                    recyclerViewcus!!.setAdapter(cusadapter)

                }

            }

        })


    }
    private fun fnquery(qureyp: Query) {
        val options = FirebaseRecyclerOptions.Builder<Post>()
            .setQuery(qureyp, Post::class.java)
            .build()
        adapter = PostAdapter(options, this@PendingList)
        recyclerView.adapter = adapter
        adapter!!.startListening()
    }
//    override fun onStart() {
//        super.onStart()
//        adapter!!.startListening()
//    }
//
//    override fun onStop() {
//        super.onStop()
//        adapter!!.stopListening()
//    }

    override fun onBackPressed() {
        adapter!!.stopListening()
        val i1 = Intent(this, MainActivity::class.java)
        startActivity(i1)
        super.onBackPressed()
    }
}
