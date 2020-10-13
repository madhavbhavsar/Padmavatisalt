package com.madappsdevlopers.padmavatisalt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.*
import java.util.ArrayList

class DeleteList : AppCompatActivity() {

    private lateinit var remrecyclerView: RecyclerView
    private var remadapter: DeleteAdapter? = null
    private var abbbcd: LinearLayoutManager? = null

    private var searchhpd: AutoCompleteTextView? = null
    private var qureypd: Query?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete_list)

        searchhpd= findViewById<AutoCompleteTextView>(R.id.searchhpd)

                remrecyclerView = findViewById<RecyclerView>(R.id.recyclerDelete)
                abbbcd = LinearLayoutManager(this)
                abbbcd!!.stackFromEnd = true
                //  mLayoutManager.setReverseLayout(false); // THIS ALSO SETS setStackFromBottom to true
                remrecyclerView.setLayoutManager(abbbcd)
                // recyclerView.setLayoutManager(new LinearLayoutManager(this));
//                val options = FirebaseRecyclerOptions.Builder<Post>()
//                    .setQuery(FirebaseDatabase.getInstance().reference.child("DeleteList"), Post::class.java)
//                    .build()
//                remadapter = DeleteAdapter(options, this)
//                remrecyclerView.setAdapter(remadapter)

        val customerarraylist = ArrayList<String>()
        FirebaseDatabase.getInstance().getReference().child("DeleteList")!!.addValueEventListener(object :
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

                val customerarrayadap = ArrayAdapter(this@DeleteList, android.R.layout.simple_list_item_1, customerarraylist)
                searchhpd!!.setAdapter(customerarrayadap)

            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

        qureypd = FirebaseDatabase.getInstance().getReference().child("DeleteList")
        fnquery(qureypd!!)

        searchhpd!!.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                if (searchhpd!!.text.toString().isEmpty()) {
                    qureypd = FirebaseDatabase.getInstance().reference.child("DeleteList")
                    fnquery(qureypd!!)
                } else {
                    qureypd = FirebaseDatabase.getInstance().reference.child("DeleteList")
                        .orderByChild("customerName").equalTo(searchhpd!!.text.toString())
                    fnquery(qureypd!!)
                }
                return@OnEditorActionListener true
            }
            false
        })




    }
    private fun fnquery(qureypd: Query) {
        val options = FirebaseRecyclerOptions.Builder<Post>()
            .setQuery(qureypd, Post::class.java)
            .build()
        remadapter = DeleteAdapter(options, this@DeleteList)
        remrecyclerView.adapter = remadapter
        remadapter!!.startListening()
    }
//            override fun onStart() {
//                super.onStart()
//                remadapter!!.startListening()
//            }
//
//            override fun onStop() {
//                super.onStop()
//                remadapter!!.stopListening()
//            }

            override fun onBackPressed() {
                remadapter!!.stopListening()
                val i1 = Intent(this, MainActivity::class.java)
                startActivity(i1)
                super.onBackPressed()
            }
        }