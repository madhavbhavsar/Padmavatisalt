package com.madappsdevlopers.padmavatisalt

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*


//abcdecheckout 4-41-am remain link pnumber to product....and
//Required imports 
class NewList : AppCompatActivity() {
    var bill = 0
    var entrynumber: TextView? = null
    private var bag: EditText? = null
    private var weight: EditText? = null
    private var mobile: EditText? = null
    private var pnumber: EditText? = null
    private var pono: EditText? = null
    var notes: EditText? = null
    var actv: AutoCompleteTextView? = null
    var customerName: AutoCompleteTextView? = null
    var productName: AutoCompleteTextView? = null
    var customerAddress: AutoCompleteTextView? = null
    var delAddress: AutoCompleteTextView? = null
    var productName2: AutoCompleteTextView? = null
    var productName3: AutoCompleteTextView? = null
    var productName4: AutoCompleteTextView? = null
    var productName5: AutoCompleteTextView? = null
    var productName6: AutoCompleteTextView? = null
    var productName7: AutoCompleteTextView? = null
    var productName8: AutoCompleteTextView? = null
    var productName9: AutoCompleteTextView? = null
    var productName10: AutoCompleteTextView? = null
    var bag2: EditText? = null
    var weight2: EditText? = null
    var pnumber2: EditText? = null
    var bag3: EditText? = null
    var weight3: EditText? = null
    var pnumber3: EditText? = null
    var bag4: EditText? = null
    var weight4: EditText? = null
    var pnumber4: EditText? = null
    var bag5: EditText? = null
    var weight5: EditText? = null
    var pnumber5: EditText? = null
    var bag6: EditText? = null
    var weight6: EditText? = null
    var pnumber6: EditText? = null
    var bag7: EditText? = null
    var weight7: EditText? = null
    var pnumber7: EditText? = null
    var bag8: EditText? = null
    var weight8: EditText? = null
    var pnumber8: EditText? = null
    var bag9: EditText? = null
    var weight9: EditText? = null
    var pnumber9: EditText? = null
    var bag10: EditText? = null
    var weight10: EditText? = null
    var pnumber10: EditText? = null
    var prroducct2: TextView? = null
    var bagee2: TextView? = null
    var weightee2: TextView? = null
    var prroducct3: TextView? = null
    var bagee3: TextView? = null
    var weightee3: TextView? = null
    var prroducct4: TextView? = null
    var bagee4: TextView? = null
    var weightee4: TextView? = null
    var prroducct5: TextView? = null
    var bagee5: TextView? = null
    var weightee5: TextView? = null
    var prroducct6: TextView? = null
    var bagee6: TextView? = null
    var weightee6: TextView? = null
    var prroducct7: TextView? = null
    var bagee7: TextView? = null
    var weightee7: TextView? = null
    var prroducct8: TextView? = null
    var bagee8: TextView? = null
    var weightee8: TextView? = null
    var prroducct9: TextView? = null
    var bagee9: TextView? = null
    var weightee9: TextView? = null
    var prroducct10: TextView? = null
    var bagee10: TextView? = null
    var weightee10: TextView? = null
    var addbtn: Button? = null
    var addbtn2: Button? = null
    var addbtn3: Button? = null
    var addbtn4: Button? = null
    var addbtn5: Button? = null
    var addbtn6: Button? = null
    var addbtn7: Button? = null
    var addbtn8: Button? = null
    var addbtn9: Button? = null
    var addbtn10: Button? = null
    private var approxFreight: EditText? = null
    var postId: String? = null
    private var date: TextView? = null
    private var deldate: TextView? = null
    private var submit: Button? = null
    private var pendinglist: Button? = null
    private var Post: DatabaseReference? = null
    private var CustomerList: DatabaseReference? = null
    private var ProductsList: DatabaseReference? = null
    private var DeliveryAddressList: DatabaseReference? = null
    private val CustomerAddressList: DatabaseReference? = null
    private var dispatchDatabase: DatabaseReference? = null
    private var Entry: DatabaseReference? = null
    var datePickerDialog: DatePickerDialog? = null

    lateinit var ttt: Thread


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_list)

        Post = FirebaseDatabase.getInstance().reference.child("Post")
        CustomerList = FirebaseDatabase.getInstance().reference.child("CustomerList")
        ProductsList = FirebaseDatabase.getInstance().reference.child("ProductsList")
        Entry = FirebaseDatabase.getInstance().reference.child("Entry")
        DeliveryAddressList = FirebaseDatabase.getInstance().reference.child("DeliveryAddressList")
        //CustomerAddressList = FirebaseDatabase.getInstance().getReference().child("CustomerAddressList");
        dispatchDatabase = FirebaseDatabase.getInstance().reference.child("DispatchList")
        deldate = findViewById<View>(R.id.deldate) as TextView

        //submit.setEnabled(true);
        prroducct2 = findViewById<View>(R.id.prroducct2) as TextView
        productName2 = findViewById<View>(R.id.productName2) as AutoCompleteTextView
        pnumber2 = findViewById<View>(R.id.pnumber2) as EditText
        bagee2 = findViewById<View>(R.id.bagee2) as TextView
        bag2 = findViewById<View>(R.id.bag2) as EditText
        weightee2 = findViewById<View>(R.id.weightee2) as TextView
        weight2 = findViewById<View>(R.id.weight2) as EditText
        addbtn2 = findViewById<View>(R.id.addbtn2) as Button
        prroducct3 = findViewById<View>(R.id.prroducct3) as TextView
        productName3 = findViewById<View>(R.id.productName3) as AutoCompleteTextView
        pnumber3 = findViewById<View>(R.id.pnumber3) as EditText
        bagee3 = findViewById<View>(R.id.bagee3) as TextView
        bag3 = findViewById<View>(R.id.bag3) as EditText
        weightee3 = findViewById<View>(R.id.weightee3) as TextView
        weight3 = findViewById<View>(R.id.weight3) as EditText
        addbtn3 = findViewById<View>(R.id.addbtn3) as Button
        prroducct4 = findViewById<View>(R.id.prroducct4) as TextView
        productName4 = findViewById<View>(R.id.productName4) as AutoCompleteTextView
        pnumber4 = findViewById<View>(R.id.pnumber4) as EditText
        bagee4 = findViewById<View>(R.id.bagee4) as TextView
        bag4 = findViewById<View>(R.id.bag4) as EditText
        weightee4 = findViewById<View>(R.id.weightee4) as TextView
        weight4 = findViewById<View>(R.id.weight4) as EditText
        addbtn4 = findViewById<View>(R.id.addbtn4) as Button
        prroducct5 = findViewById<View>(R.id.prroducct5) as TextView
        productName5 = findViewById<View>(R.id.productName5) as AutoCompleteTextView
        pnumber5 = findViewById<View>(R.id.pnumber5) as EditText
        bagee5 = findViewById<View>(R.id.bagee5) as TextView
        bag5 = findViewById<View>(R.id.bag5) as EditText
        weightee5 = findViewById<View>(R.id.weightee5) as TextView
        weight5 = findViewById<View>(R.id.weight5) as EditText
        addbtn5 = findViewById<View>(R.id.addbtn5) as Button
        prroducct6 = findViewById<View>(R.id.prroducct6) as TextView
        productName6 = findViewById<View>(R.id.productName6) as AutoCompleteTextView
        pnumber6 = findViewById<View>(R.id.pnumber6) as EditText
        bagee6 = findViewById<View>(R.id.bagee6) as TextView
        bag6 = findViewById<View>(R.id.bag6) as EditText
        weightee6 = findViewById<View>(R.id.weightee6) as TextView
        weight6 = findViewById<View>(R.id.weight6) as EditText
        addbtn6 = findViewById<View>(R.id.addbtn6) as Button
        prroducct7 = findViewById<View>(R.id.prroducct7) as TextView
        productName7 = findViewById<View>(R.id.productName7) as AutoCompleteTextView
        pnumber7 = findViewById<View>(R.id.pnumber7) as EditText
        bagee7 = findViewById<View>(R.id.bagee7) as TextView
        bag7 = findViewById<View>(R.id.bag7) as EditText
        weightee7 = findViewById<View>(R.id.weightee7) as TextView
        weight7 = findViewById<View>(R.id.weight7) as EditText
        addbtn7 = findViewById<View>(R.id.addbtn7) as Button
        prroducct8 = findViewById<View>(R.id.prroducct8) as TextView
        productName8 = findViewById<View>(R.id.productName8) as AutoCompleteTextView
        pnumber8 = findViewById<View>(R.id.pnumber8) as EditText
        bagee8 = findViewById<View>(R.id.bagee8) as TextView
        bag8 = findViewById<View>(R.id.bag8) as EditText
        weightee8 = findViewById<View>(R.id.weightee8) as TextView
        weight8 = findViewById<View>(R.id.weight8) as EditText
        addbtn8 = findViewById<View>(R.id.addbtn8) as Button
        prroducct9 = findViewById<View>(R.id.prroducct9) as TextView
        productName9 = findViewById<View>(R.id.productName9) as AutoCompleteTextView
        pnumber9 = findViewById<View>(R.id.pnumber9) as EditText
        bagee9 = findViewById<View>(R.id.bagee9) as TextView
        bag9 = findViewById<View>(R.id.bag9) as EditText
        weightee9 = findViewById<View>(R.id.weightee9) as TextView
        weight9 = findViewById<View>(R.id.weight9) as EditText
        addbtn9 = findViewById<View>(R.id.addbtn9) as Button
        prroducct10 = findViewById<View>(R.id.prroducct10) as TextView
        productName10 = findViewById<View>(R.id.productName10) as AutoCompleteTextView
        pnumber10 = findViewById<View>(R.id.pnumber10) as EditText
        bagee10 = findViewById<View>(R.id.bagee10) as TextView
        bag10 = findViewById<View>(R.id.bag10) as EditText
        weightee10 = findViewById<View>(R.id.weightee10) as TextView
        weight10 = findViewById<View>(R.id.weight10) as EditText
        addbtn10 = findViewById<View>(R.id.addbtn10) as Button
        addbtn = findViewById<View>(R.id.addbtn) as Button
        pono = findViewById<View>(R.id.pono) as EditText
        pnumber = findViewById<View>(R.id.pnumber) as EditText
        entrynumber = findViewById<View>(R.id.entrynumber) as TextView
        customerName = findViewById<View>(R.id.customerName) as AutoCompleteTextView
        productName = findViewById<View>(R.id.productName) as AutoCompleteTextView
        weight = findViewById<View>(R.id.weight) as EditText
        bag = findViewById<View>(R.id.bag) as EditText
        mobile = findViewById<View>(R.id.mobileNo) as EditText
        //customerAddress = (AutoCompleteTextView) findViewById<View>(R.id.customerAddress);
        delAddress = findViewById<View>(R.id.delAddress) as AutoCompleteTextView
        date = findViewById<View>(R.id.date) as TextView
        submit = findViewById<View>(R.id.submit) as Button
        pendinglist = findViewById<View>(R.id.pendinglist) as Button
        approxFreight = findViewById<View>(R.id.approxFreight) as EditText

        notes = findViewById<View>(R.id.notes) as EditText


        somany_focusfunction_edittext()
        somany_focusfunction_autocomplete_edittext()


        ttt = object : Thread() {
            override fun run() {
                while (!isInterrupted) {
                    try {
                        sleep(1000)
                        runOnUiThread {
                            Entry!!.addValueEventListener(object : ValueEventListener {
                                override fun onDataChange(dataSnapshot: DataSnapshot) {
                                    val count: String
                                    count = dataSnapshot.child("entrynoo").value.toString()
                                    //  println("thisissintel $count")
                                    val icot1: Int? = count.toIntOrNull()
                                    //println("thisissintel1121 $icot1")
                                    val onne: Int = 1
                                    val icot = icot1?.plus(onne)


                                    //val count:String = dataSnapshot.child("entrynoo").value.toString()
                                    //count = count+1
                                    //  println("thisissintel $count")
                                    //bill = count.toInt()
                                    //val countt: String = count as Long.toString()
                                    //  entrynumber!!.setText((int) count);
                                    entrynumber!!.text = icot.toString()
                                }

                                override fun onCancelled(databaseError: DatabaseError) {}
                            })

                        }
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
        }
        ttt.start()

        //entrynumber!!.setText("100")
        bag!!.setText("")
        weight!!.setText("")
        addbtn!!.setOnClickListener(View.OnClickListener {
            if (productName!!.length() == 0) {
                Toast.makeText(applicationContext, "Product Empty", Toast.LENGTH_SHORT).show()
            } else {
                bag2!!.setText("")
                weight2!!.setText("")
                productName2!!.setVisibility(View.VISIBLE)
                prroducct2!!.setVisibility(View.VISIBLE)
                bagee2!!.setVisibility(View.VISIBLE)
                bag2!!.setVisibility(View.VISIBLE)
                weightee2!!.setVisibility(View.VISIBLE)
                weight2!!.setVisibility(View.VISIBLE)
                pnumber2!!.setVisibility(View.VISIBLE)
                addbtn2!!.setVisibility(View.VISIBLE)
            }
        })
        addbtn2!!.setOnClickListener(View.OnClickListener {
            if (productName2!!.length() == 0) {
                Toast.makeText(applicationContext, "Product Empty", Toast.LENGTH_SHORT).show()
            } else {
                bag3!!.setText("")
                weight3!!.setText("")
                productName3!!.setVisibility(View.VISIBLE)
                prroducct3!!.setVisibility(View.VISIBLE)
                bagee3!!.setVisibility(View.VISIBLE)
                bag3!!.setVisibility(View.VISIBLE)
                weightee3!!.setVisibility(View.VISIBLE)
                weight3!!.setVisibility(View.VISIBLE)
                pnumber3!!.setVisibility(View.VISIBLE)
                addbtn3!!.setVisibility(View.VISIBLE)
            }
        })
        addbtn3!!.setOnClickListener(View.OnClickListener {
            if (productName3!!.length() == 0) {
                Toast.makeText(applicationContext, "Product Empty", Toast.LENGTH_SHORT).show()
            } else {
                bag4!!.setText("")
                weight4!!.setText("")
                productName4!!.setVisibility(View.VISIBLE)
                prroducct4!!.setVisibility(View.VISIBLE)
                bagee4!!.setVisibility(View.VISIBLE)
                bag4!!.setVisibility(View.VISIBLE)
                weightee4!!.setVisibility(View.VISIBLE)
                weight4!!.setVisibility(View.VISIBLE)
                pnumber4!!.setVisibility(View.VISIBLE)
                addbtn4!!.setVisibility(View.VISIBLE)
            }
        })
        addbtn4!!.setOnClickListener(View.OnClickListener {
            if (productName4!!.length() == 0) {
                Toast.makeText(applicationContext, "Product Empty", Toast.LENGTH_SHORT).show()
            } else {
                bag5!!.setText("")
                weight5!!.setText("")
                productName5!!.setVisibility(View.VISIBLE)
                prroducct5!!.setVisibility(View.VISIBLE)
                bagee5!!.setVisibility(View.VISIBLE)
                bag5!!.setVisibility(View.VISIBLE)
                weightee5!!.setVisibility(View.VISIBLE)
                weight5!!.setVisibility(View.VISIBLE)
                pnumber5!!.setVisibility(View.VISIBLE)
                addbtn5!!.setVisibility(View.VISIBLE)
            }
        })
        addbtn5!!.setOnClickListener(View.OnClickListener {
            if (productName5!!.length() == 0) {
                Toast.makeText(applicationContext, "Product Empty", Toast.LENGTH_SHORT).show()
            } else {
                bag6!!.setText("")
                weight6!!.setText("")
                productName6!!.setVisibility(View.VISIBLE)
                prroducct6!!.setVisibility(View.VISIBLE)
                bagee6!!.setVisibility(View.VISIBLE)
                bag6!!.setVisibility(View.VISIBLE)
                weightee6!!.setVisibility(View.VISIBLE)
                weight6!!.setVisibility(View.VISIBLE)
                pnumber6!!.setVisibility(View.VISIBLE)
                addbtn6!!.setVisibility(View.VISIBLE)
            }
        })
        addbtn6!!.setOnClickListener(View.OnClickListener {
            if (productName6!!.length() == 0) {
                Toast.makeText(applicationContext, "Product Empty", Toast.LENGTH_SHORT).show()
            } else {
                bag7!!.setText("")
                weight7!!.setText("")
                productName7!!.setVisibility(View.VISIBLE)
                prroducct7!!.setVisibility(View.VISIBLE)
                bagee7!!.setVisibility(View.VISIBLE)
                bag7!!.setVisibility(View.VISIBLE)
                weightee7!!.setVisibility(View.VISIBLE)
                weight7!!.setVisibility(View.VISIBLE)
                pnumber7!!.setVisibility(View.VISIBLE)
                addbtn7!!.setVisibility(View.VISIBLE)
            }
        })
        addbtn7!!.setOnClickListener(View.OnClickListener {
            if (productName7!!.length() == 0) {
                Toast.makeText(applicationContext, "Product Empty", Toast.LENGTH_SHORT).show()
            } else {
                bag8!!.setText("")
                weight8!!.setText("")
                productName8!!.setVisibility(View.VISIBLE)
                prroducct8!!.setVisibility(View.VISIBLE)
                bagee8!!.setVisibility(View.VISIBLE)
                bag8!!.setVisibility(View.VISIBLE)
                weightee8!!.setVisibility(View.VISIBLE)
                weight8!!.setVisibility(View.VISIBLE)
                pnumber8!!.setVisibility(View.VISIBLE)
                addbtn8!!.setVisibility(View.VISIBLE)
            }
        })
        addbtn8!!.setOnClickListener(View.OnClickListener {
            if (productName8!!.length() == 0) {
                Toast.makeText(applicationContext, "Product Empty", Toast.LENGTH_SHORT).show()
            } else {
                bag9!!.setText("")
                weight9!!.setText("")
                productName9!!.setVisibility(View.VISIBLE)
                prroducct9!!.setVisibility(View.VISIBLE)
                bagee9!!.setVisibility(View.VISIBLE)
                bag9!!.setVisibility(View.VISIBLE)
                weightee9!!.setVisibility(View.VISIBLE)
                weight9!!.setVisibility(View.VISIBLE)
                pnumber9!!.setVisibility(View.VISIBLE)
                addbtn9!!.setVisibility(View.VISIBLE)
            }
        })
        addbtn9!!.setOnClickListener(View.OnClickListener {
            if (productName9!!.length() == 0) {
                Toast.makeText(applicationContext, "Product Empty", Toast.LENGTH_SHORT).show()
            } else {
                bag10!!.setText("")
                weight10!!.setText("")
                productName10!!.setVisibility(View.VISIBLE)
                prroducct10!!.setVisibility(View.VISIBLE)
                bagee10!!.setVisibility(View.VISIBLE)
                bag10!!.setVisibility(View.VISIBLE)
                weightee10!!.setVisibility(View.VISIBLE)
                weight10!!.setVisibility(View.VISIBLE)
                pnumber10!!.setVisibility(View.VISIBLE)
                addbtn10!!.setVisibility(View.VISIBLE)
            }
        })
        val date_n = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(Date())
        date!!.text = date_n





        deldate!!.text = date_n
        deldate!!.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar[Calendar.YEAR]
            val month = calendar[Calendar.MONTH]
            val day = calendar[Calendar.DAY_OF_MONTH]
            datePickerDialog = DatePickerDialog(this@NewList,
                DatePickerDialog.OnDateSetListener { view, i0, i1, i2 ->
                    val showDate = i2.toString() + "-" + (i1 + 1) + "-" + i0
                    deldate!!.text = showDate
                }, year, month, day
            )
            datePickerDialog!!.datePicker.minDate = System.currentTimeMillis() - 1000
            datePickerDialog!!.show()
        }


        //customerName.addTextChangedListener(textWatcher);
        //productName.addTextChangedListener(textWatcher);
        //customerAddress.addTextChangedListener(textWatcher);
        //delAddress.addTextChangedListener(textWatcher);
        postId = FirebaseDatabase.getInstance().reference.child("Post").push().key
        //   println("maddddddy $postId")


//                val productcount: Long = 0
//                ProductsList!!.addValueEventListener(object : ValueEventListener {
//                    override fun onDataChange(dataSnapshot: DataSnapshot) {
//                        var productcount = dataSnapshot.childrenCount
//                        productcount = productcount + 1
//                        val productnumcount: String = productcount as Int.toString()
//                    }
//
//                    override fun onCancelled(databaseError: DatabaseError) {}
//                })


        val customerarraylist = ArrayList<String>()
        val customermobilearraylist = ArrayList<String>()

        CustomerList!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (dataSnapshot1 in dataSnapshot.children) {
                    val customerarray = dataSnapshot1.child("customerName").value.toString()
                    val customermobilearray = dataSnapshot1.child("mobileNo").value.toString()
                    //System.out.println("thisissintel  " +a101);
                    if (customerarraylist.contains(customerarray)) {
                    } else {
                        customerarraylist.add(customerarray)
                        customermobilearraylist.add(customermobilearray)
                    }
                    //  rowList.add(new RowItem(customerarray));
                }
                //    println("thisissintel23cname  $customerarraylist")
                //    println("thisissintel23mobilename  $customermobilearraylist")
                val customerarrayadap = ArrayAdapter(
                    this@NewList,
                    android.R.layout.simple_list_item_1,
                    customerarraylist
                )
                customerName!!.setAdapter(customerarrayadap)
                customerName!!.onItemClickListener =
                    AdapterView.OnItemClickListener { parent, view, position, id ->
                        val itemposition09 = parent.getItemAtPosition(position).toString()
                        //        println("thisissintel23cnameposit  $itemposition09")
                        val pos = customerarraylist.indexOf(itemposition09)
                        //      println("thisissintel23cnameposit  $pos")
                        mobile!!.setText(customermobilearraylist[pos])
                    }

                //AutoCompleteRowAdapter adapter = new AutoCompleteRowAdapter(NewList.this,rowList);
                //customerName.setAdapter(adapter);
                //lv1.setAdapter(customerarrayadap);


                //System.out.println("thisissintel23index  "+customerarraylist.indexOf(customerName!!.getText().toString().trim()));
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })

        //for (int maad=1; maad<999999999;maad++){}
        val productarray = ""
        val productarraylist = ArrayList<String>()
        val pnumberarray = ""
        val pnumberarraylist = ArrayList<String>()
        ProductsList!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (dataSnapshot1 in dataSnapshot.children) {
                    val productarray = dataSnapshot1.child("productName").value.toString()
                    val pnumberarray = dataSnapshot1.child("pnumber").value.toString()
                    //System.out.println("thisissintel  " +a101);
                    if (productarraylist.contains(productarray)) {
                    } else {
                        productarraylist.add(productarray)
                        pnumberarraylist.add(pnumberarray)
                    }
                }
                //   println("thisissintel23pname  $productarraylist")
                val productarrayadap = ArrayAdapter(
                    this@NewList,
                    android.R.layout.simple_list_item_1,
                    productarraylist
                )
                productName!!.setAdapter(productarrayadap)
                productName2!!.setAdapter(productarrayadap)
                productName3!!.setAdapter(productarrayadap)
                productName4!!.setAdapter(productarrayadap)
                productName5!!.setAdapter(productarrayadap)
                productName6!!.setAdapter(productarrayadap)
                productName7!!.setAdapter(productarrayadap)
                productName8!!.setAdapter(productarrayadap)
                productName9!!.setAdapter(productarrayadap)
                productName10!!.setAdapter(productarrayadap)
                productName!!.onItemClickListener =
                    AdapterView.OnItemClickListener { parent, view, position, id ->
                        val ipos1 = parent.getItemAtPosition(position).toString()
                        //System.out.println("thisissintel23cnameposit  " +itemposition0921);
                        val pos01 = productarraylist.indexOf(ipos1)
                        // System.out.println("thisissintel23cnameposit  " +pos21);
                        pnumber!!.setText(pnumberarraylist[pos01])
                    }
                productName2!!.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
                    val ipos2 = parent.getItemAtPosition(position).toString()
                    val pos02 = productarraylist.indexOf(ipos2)
                    pnumber2!!.setText(pnumberarraylist[pos02])
                })
                productName3!!.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
                    val ipos3 = parent.getItemAtPosition(position).toString()
                    val pos03 = productarraylist.indexOf(ipos3)
                    pnumber3!!.setText(pnumberarraylist[pos03])
                })
                productName4!!.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
                    val ipos4 = parent.getItemAtPosition(position).toString()
                    val pos04 = productarraylist.indexOf(ipos4)
                    pnumber4!!.setText(pnumberarraylist[pos04])
                })
                productName5!!.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
                    val ipos5 = parent.getItemAtPosition(position).toString()
                    val pos05 = productarraylist.indexOf(ipos5)
                    pnumber5!!.setText(pnumberarraylist[pos05])
                })
                productName6!!.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
                    val ipos6 = parent.getItemAtPosition(position).toString()
                    val pos06 = productarraylist.indexOf(ipos6)
                    pnumber6!!.setText(pnumberarraylist[pos06])
                })
                productName7!!.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
                    val ipos7 = parent.getItemAtPosition(position).toString()
                    val pos07 = productarraylist.indexOf(ipos7)
                    pnumber7!!.setText(pnumberarraylist[pos07])
                })
                productName8!!.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
                    val ipos8 = parent.getItemAtPosition(position).toString()
                    val pos08 = productarraylist.indexOf(ipos8)
                    pnumber8!!.setText(pnumberarraylist[pos08])
                })
                productName9!!.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
                    val ipos9 = parent.getItemAtPosition(position).toString()
                    val pos09 = productarraylist.indexOf(ipos9)
                    pnumber9!!.setText(pnumberarraylist[pos09])
                })
                productName10!!.setOnItemClickListener(AdapterView.OnItemClickListener { parent, view, position, id ->
                    val ipos10 = parent.getItemAtPosition(position).toString()
                    val pos010 = productarraylist.indexOf(ipos10)
                    pnumber10!!.setText(pnumberarraylist[pos010])
                })
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
        val deladdarray = ""
        val deladdarraylist = ArrayList<String>()
        DeliveryAddressList!!.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (dataSnapshot1 in dataSnapshot.children) {
                    val deladdarray = dataSnapshot1.child("delAddress").value.toString()
                    //System.out.println("thisissintel  " +a101);
                    if (deladdarraylist.contains(deladdarray)) {
                    } else {
                        deladdarraylist.add(deladdarray)
                    }
                }
                //    println("thisissintel23daddname  $deladdarraylist")
                val deladdarrayadap =
                    ArrayAdapter(this@NewList, android.R.layout.simple_list_item_1, deladdarraylist)
                delAddress!!.setAdapter(deladdarrayadap)
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })


        bag!!.setOnClickListener {
            if (pnumber!!.length() == 0 || weight!!.length() == 0 || pnumber!!.text.toString()
                    .trim { it <= ' ' } == "null" || pnumber!!.text.toString()
                    .trim { it <= ' ' } == "nul" || pnumber!!.text.toString()
                    .trim { it <= ' ' } == "nu" || pnumber!!.text.toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x = pnumber!!.text.toString().trim { it <= ' ' }.toDouble()
                val z = weight!!.text.toString().trim { it <= ' ' }.toDouble()
                val bagno = (z / x) * 1000
                bag!!.setText(Math.round(bagno).toString())
            }
        }
        bag2!!.setOnClickListener(View.OnClickListener {
            if (pnumber2!!.length() == 0 || weight2!!.length() == 0 || pnumber2!!.getText()
                    .toString().trim { it <= ' ' } == "null" || pnumber2!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber2!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber2!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x2 = pnumber2!!.getText().toString().trim { it <= ' ' }.toDouble()
                val z2 = weight2!!.getText().toString().trim { it <= ' ' }.toDouble()
                val bagno2 = (z2 / x2) * 1000
                bag2!!.setText(Math.round(bagno2).toString())
            }
        })
        bag3!!.setOnClickListener(View.OnClickListener {
            if (pnumber3!!.length() == 0 || weight3!!.length() == 0 || pnumber3!!.getText()
                    .toString().trim { it <= ' ' } == "null" || pnumber3!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber3!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber3!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x3 = pnumber3!!.getText().toString().trim { it <= ' ' }.toDouble()
                val z3 = weight3!!.getText().toString().trim { it <= ' ' }.toDouble()
                val bagno3 = (z3 / x3) * 1000
                bag3!!.setText(Math.round(bagno3).toString())
            }
        })
        bag4!!.setOnClickListener(View.OnClickListener {
            if (pnumber4!!.length() == 0 || weight4!!.length() == 0 || pnumber4!!.getText()
                    .toString().trim { it <= ' ' } == "null" || pnumber4!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber4!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber4!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x4 = pnumber4!!.getText().toString().trim { it <= ' ' }.toDouble()
                val z4 = weight4!!.getText().toString().trim { it <= ' ' }.toDouble()
                val bagno4 = (z4 / x4) * 1000
                bag4!!.setText(Math.round(bagno4).toString())
            }
        })
        bag5!!.setOnClickListener(View.OnClickListener {
            if (pnumber5!!.length() == 0 || weight5!!.length() == 0 || pnumber5!!.getText()
                    .toString().trim { it <= ' ' } == "null" || pnumber5!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber5!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber5!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x5 = pnumber5!!.getText().toString().trim { it <= ' ' }.toDouble()
                val z5 = weight5!!.getText().toString().trim { it <= ' ' }.toDouble()
                val bagno5 = (z5 / x5) * 1000
                bag5!!.setText(Math.round(bagno5).toString())
            }
        })
        bag6!!.setOnClickListener(View.OnClickListener {
            if (pnumber6!!.length() == 0 || weight6!!.length() == 0 || pnumber6!!.getText()
                    .toString().trim { it <= ' ' } == "null" || pnumber6!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber6!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber6!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x6 = pnumber6!!.getText().toString().trim { it <= ' ' }.toDouble()
                val z6 = weight6!!.getText().toString().trim { it <= ' ' }.toDouble()
                val bagno6 = (z6 / x6) * 1000
                bag6!!.setText(Math.round(bagno6).toString())
            }
        })
        bag7!!.setOnClickListener(View.OnClickListener {
            if (pnumber7!!.length() == 0 || weight7!!.length() == 0 || pnumber7!!.getText()
                    .toString().trim { it <= ' ' } == "null" || pnumber7!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber7!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber7!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x7 = pnumber7!!.getText().toString().trim { it <= ' ' }.toDouble()
                val z7 = weight7!!.getText().toString().trim { it <= ' ' }.toDouble()
                val bagno7 = (z7 / x7) * 1000
                bag7!!.setText(Math.round(bagno7).toString())
            }
        })
        bag8!!.setOnClickListener(View.OnClickListener {
            if (pnumber8!!.length() == 0 || weight8!!.length() == 0 || pnumber8!!.getText()
                    .toString().trim { it <= ' ' } == "null" || pnumber8!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber8!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber8!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x8 = pnumber8!!.getText().toString().trim { it <= ' ' }.toDouble()
                val z8 = weight8!!.getText().toString().trim { it <= ' ' }.toDouble()
                val bagno8 = (z8 / x8) * 1000
                bag8!!.setText(Math.round(bagno8).toString())
            }
        })
        bag9!!.setOnClickListener(View.OnClickListener {
            if (pnumber9!!.length() == 0 || weight9!!.length() == 0 || pnumber9!!.getText()
                    .toString().trim { it <= ' ' } == "null" || pnumber9!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber9!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber9!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x9 = pnumber9!!.getText().toString().trim { it <= ' ' }.toDouble()
                val z9 = weight9!!.getText().toString().trim { it <= ' ' }.toDouble()
                val bagno9 = (z9 / x9) * 1000
                bag9!!.setText(Math.round(bagno9).toString())
            }
        })
        bag10!!.setOnClickListener(View.OnClickListener {
            if (pnumber10!!.length() == 0 || weight10!!.length() == 0 || pnumber10!!.getText()
                    .toString().trim { it <= ' ' } == "null" || pnumber10!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber10!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber10!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x10 = pnumber10!!.getText().toString().trim { it <= ' ' }.toDouble()
                val z10 = weight10!!.getText().toString().trim { it <= ' ' }.toDouble()
                val bagno10 = (z10 / x10) * 1000
                bag10!!.setText(Math.round(bagno10).toString())
            }
        })
        weight!!.setOnClickListener {
            if (pnumber!!.length() == 0 || bag!!.length() == 0 || pnumber!!.text.toString()
                    .trim { it <= ' ' } == "null" || pnumber!!.text.toString()
                    .trim { it <= ' ' } == "nul" || pnumber!!.text.toString()
                    .trim { it <= ' ' } == "nu" || pnumber!!.text.toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x = pnumber!!.text.toString().trim { it <= ' ' }.toDouble()
                val y = bag!!.text.toString().trim { it <= ' ' }.toDouble()
                val weightinton = x * y / 1000
                weight!!.setText(weightinton.toString())
            }
        }
        weight2!!.setOnClickListener(View.OnClickListener {
            if (pnumber2!!.length() == 0 || bag2!!.length() == 0 || pnumber2!!.getText().toString()
                    .trim { it <= ' ' } == "null" || pnumber2!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber2!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber2!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x2 = pnumber2!!.getText().toString().trim { it <= ' ' }.toDouble()
                val y2 = bag2!!.getText().toString().trim { it <= ' ' }.toDouble()
                val weightinton2 = x2 * y2 / 1000
                weight2!!.setText(weightinton2.toString())
            }
        })
        weight3!!.setOnClickListener(View.OnClickListener {
            if (pnumber3!!.length() == 0 || bag3!!.length() == 0 || pnumber3!!.getText().toString()
                    .trim { it <= ' ' } == "null" || pnumber3!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber3!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber3!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x3 = pnumber3!!.getText().toString().trim { it <= ' ' }.toDouble()
                val y3 = bag3!!.getText().toString().trim { it <= ' ' }.toDouble()
                val weightinton3 = x3 * y3 / 1000
                weight3!!.setText(weightinton3.toString())
            }
        })
        weight4!!.setOnClickListener(View.OnClickListener {
            if (pnumber4!!.length() == 0 || bag4!!.length() == 0 || pnumber4!!.getText().toString()
                    .trim { it <= ' ' } == "null" || pnumber4!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber4!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber4!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x4 = pnumber4!!.getText().toString().trim { it <= ' ' }.toDouble()
                val y4 = bag4!!.getText().toString().trim { it <= ' ' }.toDouble()
                val weightinton4 = x4 * y4 / 1000
                weight4!!.setText(weightinton4.toString())
            }
        })
        weight5!!.setOnClickListener(View.OnClickListener {
            if (pnumber5!!.length() == 0 || bag5!!.length() == 0 || pnumber5!!.getText().toString()
                    .trim { it <= ' ' } == "null" || pnumber5!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber5!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber5!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x5 = pnumber5!!.getText().toString().trim { it <= ' ' }.toDouble()
                val y5 = bag5!!.getText().toString().trim { it <= ' ' }.toDouble()
                val weightinton5 = x5 * y5 / 1000
                weight5!!.setText(weightinton5.toString())
            }
        })
        weight6!!.setOnClickListener(View.OnClickListener {
            if (pnumber6!!.length() == 0 || bag6!!.length() == 0 || pnumber6!!.getText().toString()
                    .trim { it <= ' ' } == "null" || pnumber6!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber6!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber6!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x6 = pnumber6!!.getText().toString().trim { it <= ' ' }.toDouble()
                val y6 = bag6!!.getText().toString().trim { it <= ' ' }.toDouble()
                val weightinton6 = x6 * y6 / 1000
                weight6!!.setText(weightinton6.toString())
            }
        })
        weight7!!.setOnClickListener(View.OnClickListener {
            if (pnumber7!!.length() == 0 || bag7!!.length() == 0 || pnumber7!!.getText().toString()
                    .trim { it <= ' ' } == "null" || pnumber7!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber7!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber7!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x7 = pnumber7!!.getText().toString().trim { it <= ' ' }.toDouble()
                val y7 = bag7!!.getText().toString().trim { it <= ' ' }.toDouble()
                val weightinton7 = x7 * y7 / 1000
                weight7!!.setText(weightinton7.toString())
            }
        })
        weight8!!.setOnClickListener(View.OnClickListener {
            if (pnumber8!!.length() == 0 || bag8!!.length() == 0 || pnumber8!!.getText().toString()
                    .trim { it <= ' ' } == "null" || pnumber8!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber8!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber8!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x8 = pnumber8!!.getText().toString().trim { it <= ' ' }.toDouble()
                val y8 = bag8!!.getText().toString().trim { it <= ' ' }.toDouble()
                val weightinton8 = x8 * y8 / 1000
                weight8!!.setText(weightinton8.toString())
            }
        })
        weight9!!.setOnClickListener(View.OnClickListener {
            if (pnumber9!!.length() == 0 || bag9!!.length() == 0 || pnumber9!!.getText().toString()
                    .trim { it <= ' ' } == "null" || pnumber9!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber9!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber9!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x9 = pnumber9!!.getText().toString().trim { it <= ' ' }.toDouble()
                val y9 = bag9!!.getText().toString().trim { it <= ' ' }.toDouble()
                val weightinton9 = x9 * y9 / 1000
                weight9!!.setText(weightinton9.toString())
            }
        })
        weight10!!.setOnClickListener(View.OnClickListener {
            if (pnumber10!!.length() == 0 || bag10!!.length() == 0 || pnumber10!!.getText()
                    .toString().trim { it <= ' ' } == "null" || pnumber10!!.getText().toString()
                    .trim { it <= ' ' } == "nul" || pnumber10!!.getText().toString()
                    .trim { it <= ' ' } == "nu" || pnumber10!!.getText().toString()
                    .trim { it <= ' ' } == "n"
            ) {
            } else {
                val x10 = pnumber10!!.getText().toString().trim { it <= ' ' }.toDouble()
                val y10 = bag10!!.getText().toString().trim { it <= ' ' }.toDouble()
                val weightinton10 = x10 * y10 / 1000
                weight10!!.setText(weightinton10.toString())
            }
        })
        submit!!.setOnClickListener {

//
            if (entrynumber!!.length() == 0) {
                Toast.makeText(applicationContext, "Internet not Available", Toast.LENGTH_SHORT)
                    .show()
            } else if (customerName!!.length() == 0) {
                err_focusfunction_autocomplete_edittext(customerName!!)
                Toast.makeText(applicationContext, "Enter Name", Toast.LENGTH_SHORT).show()
            } else if (mobile!!.length() > 25 || mobile!!.length() <= 9) {
                err_focusfunction_edittext(mobile!!)
                Toast.makeText(applicationContext, "Enter Mobile No. correctly", Toast.LENGTH_SHORT)
                    .show()
            } else if (productName!!.length() == 0) {
                err_focusfunction_autocomplete_edittext(productName!!)
                Toast.makeText(applicationContext, "Enter Product Name", Toast.LENGTH_SHORT).show()
            } else {

                val kk = Kotclass()
                kk.kooot(
                    "New Order No. - " + entrynumber!!.text.toString(),
                    customerName!!.text.toString()
                )


                if (weight!!.text.toString().trim { it <= ' ' }!!.length == 0) {
                    weight!!.setText("0")
                }
                if (bag!!.text.toString().trim { it <= ' ' }!!.length == 0) {
                    bag!!.setText("0")
                }
                if (weight2!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    weight2!!.setText("0")
                }
                if (bag2!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    bag2!!.setText("0")
                }
                if (weight3!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    weight3!!.setText("0")
                }
                if (bag3!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    bag3!!.setText("0")
                }
                if (weight4!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    weight4!!.setText("0")
                }
                if (bag4!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    bag4!!.setText("0")
                }
                if (weight5!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    weight5!!.setText("0")
                }
                if (bag5!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    bag5!!.setText("0")
                }
                if (weight6!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    weight6!!.setText("0")
                }
                if (bag6!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    bag6!!.setText("0")
                }
                if (weight7!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    weight7!!.setText("0")
                }
                if (bag7!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    bag7!!.setText("0")
                }
                if (weight8!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    weight8!!.setText("0")
                }
                if (bag8!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    bag8!!.setText("0")
                }
                if (weight9!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    weight9!!.setText("0")
                }
                if (bag9!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    bag9!!.setText("0")
                }
                if (weight10!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    weight10!!.setText("0")
                }
                if (bag10!!.getText().toString().trim { it <= ' ' }!!.length == 0) {
                    bag10!!.setText("0")
                }
                val totalW =
                    (weight!!.text.toString().trim { it <= ' ' }.toDouble() + weight3!!.getText()
                        .toString().trim { it <= ' ' }.toDouble() + weight2!!.getText().toString()
                        .trim { it <= ' ' }.toDouble() + weight4!!.getText().toString()
                        .trim { it <= ' ' }.toDouble() + weight5!!.getText().toString()
                        .trim { it <= ' ' }.toDouble() + weight6!!.getText().toString()
                        .trim { it <= ' ' }.toDouble() + weight7!!.getText().toString()
                        .trim { it <= ' ' }.toDouble() + weight8!!.getText().toString()
                        .trim { it <= ' ' }.toDouble() + weight9!!.getText().toString()
                        .trim { it <= ' ' }.toDouble() + weight10!!.getText().toString()
                        .trim { it <= ' ' }.toDouble())
                        .toString()
                val totalB = (bag!!.text.toString().trim { it <= ' ' }.toDouble() + bag2!!.getText()
                    .toString().trim { it <= ' ' }.toDouble() + bag3!!.getText().toString()
                    .trim { it <= ' ' }.toDouble() + bag4!!.getText().toString().trim { it <= ' ' }
                    .toDouble() + bag5!!.getText().toString().trim { it <= ' ' }
                    .toDouble() + bag6!!.getText().toString().trim { it <= ' ' }
                    .toDouble() + bag7!!.getText().toString().trim { it <= ' ' }
                    .toDouble() + bag8!!.getText().toString().trim { it <= ' ' }
                    .toDouble() + bag9!!.getText().toString().trim { it <= ' ' }
                    .toDouble() + bag10!!.getText().toString().trim { it <= ' ' }.toDouble())
                    .toString()


                val mapEntry = HashMap<String, Any>()
                mapEntry["entrynoo"] = entrynumber!!.text.toString().trim { it <= ' ' }
                Entry!!.setValue(mapEntry)
                //postId = FirebaseDatabase.getInstance().getReference().child("Post").push().getKey();

                //final String idd = FirebaseDatabase.getInstance().getReference("Post").push().getKey();
                //FirebaseDatabase.getInstance().getReference("Post").child(id).setValue(Post);
                if (deladdarraylist.contains(delAddress!!.text.toString().trim { it <= ' ' })) {
                } else {
                    val mapDelAddress = HashMap<String, Any>()
                    mapDelAddress["delAddress"] = delAddress!!.text.toString().trim { it <= ' ' }
                    DeliveryAddressList!!.child("D" + entrynumber!!.text.toString())
                        .setValue(mapDelAddress)
                        .addOnCompleteListener { Log.i("completeDeliveryAddList", "oncomplete") }
                        .addOnFailureListener { e ->
                            Log.i(
                                "errorDeliveryAddList",
                                "onFailure :$e"
                            )
                        }
                }
                if (productarraylist.contains(productName!!.text.toString().trim { it <= ' ' })) {
                } else {
                    val mapProduct = HashMap<String, Any>()
                    mapProduct["productName"] = productName!!.text.toString().trim { it <= ' ' }
                    mapProduct["pnumber"] = pnumber!!.text.toString().trim { it <= ' ' }
                    ProductsList!!.child(entrynumber!!.text.toString() + "-1")
                        .setValue(mapProduct)
                        .addOnCompleteListener { Log.i("completeProductList", "oncomplete") }
                        .addOnFailureListener { e -> Log.i("errorProductList", "onFailure :$e") }
                }
                if (productarraylist.contains(
                        productName2!!.getText().toString()
                            .trim { it <= ' ' }) || productName2!!.length() == 0
                ) {
                } else {
                    val mapProduct2 = HashMap<String, Any>()
                    mapProduct2["productName"] =
                        productName2!!.getText().toString().trim { it <= ' ' }
                    mapProduct2["pnumber"] = pnumber2!!.getText().toString().trim { it <= ' ' }
                    ProductsList!!.child(entrynumber!!.text.toString() + "-2").setValue(mapProduct2)
                }
                if (productarraylist.contains(
                        productName3!!.getText().toString()
                            .trim { it <= ' ' }) || productName3!!.length() == 0
                ) {
                } else {
                    val mapProduct3 = HashMap<String, Any>()
                    mapProduct3["productName"] =
                        productName3!!.getText().toString().trim { it <= ' ' }
                    mapProduct3["pnumber"] = pnumber3!!.getText().toString().trim { it <= ' ' }
                    ProductsList!!.child(entrynumber!!.text.toString() + "-3").setValue(mapProduct3)
                }
                if (productarraylist.contains(
                        productName4!!.getText().toString()
                            .trim { it <= ' ' }) || productName4!!.length() == 0
                ) {
                } else {
                    val mapProduct4 = HashMap<String, Any>()
                    mapProduct4["productName"] =
                        productName4!!.getText().toString().trim { it <= ' ' }
                    mapProduct4["pnumber"] = pnumber4!!.getText().toString().trim { it <= ' ' }
                    ProductsList!!.child(entrynumber!!.text.toString() + "-4").setValue(mapProduct4)
                }
                if (productarraylist.contains(
                        productName5!!.getText().toString()
                            .trim { it <= ' ' }) || productName5!!.length() == 0
                ) {
                } else {
                    val mapProduct5 = HashMap<String, Any>()
                    mapProduct5["productName"] =
                        productName5!!.getText().toString().trim { it <= ' ' }
                    mapProduct5["pnumber"] = pnumber5!!.getText().toString().trim { it <= ' ' }
                    ProductsList!!.child(entrynumber!!.text.toString() + "-5").setValue(mapProduct5)
                }
                if (productarraylist.contains(
                        productName6!!.getText().toString()
                            .trim { it <= ' ' }) || productName6!!.length() == 0
                ) {
                } else {
                    val mapProduct6 = HashMap<String, Any>()
                    mapProduct6["productName"] =
                        productName6!!.getText().toString().trim { it <= ' ' }
                    mapProduct6["pnumber"] = pnumber6!!.getText().toString().trim { it <= ' ' }
                    ProductsList!!.child(entrynumber!!.text.toString() + "-6").setValue(mapProduct6)
                }
                if (productarraylist.contains(
                        productName7!!.getText().toString()
                            .trim { it <= ' ' }) || productName7!!.length() == 0
                ) {
                } else {
                    val mapProduct7 = HashMap<String, Any>()
                    mapProduct7["productName"] =
                        productName7!!.getText().toString().trim { it <= ' ' }
                    mapProduct7["pnumber"] = pnumber7!!.getText().toString().trim { it <= ' ' }
                    ProductsList!!.child(entrynumber!!.text.toString() + "-7").setValue(mapProduct7)
                }
                if (productarraylist.contains(
                        productName8!!.getText().toString()
                            .trim { it <= ' ' }) || productName8!!.length() == 0
                ) {
                } else {
                    val mapProduct8 = HashMap<String, Any>()
                    mapProduct8["productName"] =
                        productName8!!.getText().toString().trim { it <= ' ' }
                    mapProduct8["pnumber"] = pnumber8!!.getText().toString().trim { it <= ' ' }
                    ProductsList!!.child(entrynumber!!.text.toString() + "-8").setValue(mapProduct8)
                }
                if (productarraylist.contains(
                        productName9!!.getText().toString()
                            .trim { it <= ' ' }) || productName9!!.length() == 0
                ) {
                } else {
                    val mapProduct9 = HashMap<String, Any>()
                    mapProduct9["productName"] =
                        productName9!!.getText().toString().trim { it <= ' ' }
                    mapProduct9["pnumber"] = pnumber9!!.getText().toString().trim { it <= ' ' }
                    ProductsList!!.child(entrynumber!!.text.toString() + "-9").setValue(mapProduct9)
                }
                if (productarraylist.contains(
                        productName10!!.getText().toString()
                            .trim { it <= ' ' }) || productName10!!.length() == 0
                ) {
                } else {
                    val mapProduct10 = HashMap<String, Any>()
                    mapProduct10["productName"] =
                        productName10!!.getText().toString().trim { it <= ' ' }
                    mapProduct10["pnumber"] = pnumber10!!.getText().toString().trim { it <= ' ' }
                    ProductsList!!.child(entrynumber!!.text.toString() + "-10")
                        .setValue(mapProduct10)
                }
                if (customerarraylist.contains(customerName!!.text.toString().trim { it <= ' ' })) {
                } else {
                    val mapCustomer = HashMap<String, Any?>()
                    mapCustomer["customerName"] = customerName!!.text.toString().trim { it <= ' ' }
                    mapCustomer["mobileNo"] = mobile!!.text.toString().trim { it <= ' ' }
                    mapCustomer["customerId"] = postId
                    //mapCustomer.put("customerAddress",address!!.getText().toString().trim());
                    CustomerList!!.child("C" + entrynumber!!.text.toString())
                        .setValue(mapCustomer)
                        .addOnCompleteListener { Log.i("completeCustomerList", "oncomplete") }
                        .addOnFailureListener { e -> Log.i("errorCustomerList", "onFailure :$e") }
                }
                //save totalbag total weight     3152020 0402
                // String id = FirebaseDatabase.getInstance().getReference().child("Post").push().getKey();
                val map = HashMap<String, Any?>()
                map["entry"] = entrynumber!!.text.toString().trim { it <= ' ' }
                map["customerName"] = customerName!!.text.toString().trim { it <= ' ' }
                map["productName"] = productName!!.text.toString().trim { it <= ' ' }
                map["weight"] = weight!!.text.toString().trim { it <= ' ' }
                map["bag"] = bag!!.text.toString().trim { it <= ' ' }
                map["mobileNo"] = mobile!!.text.toString().trim { it <= ' ' }
                // map.put("customerAddress",customerAddress!!.getText().toString().trim());
                map["delAddress"] = delAddress!!.text.toString().trim { it <= ' ' }
                map["date"] = date!!.text.toString().trim { it <= ' ' }
                map["pono"] = pono!!.text.toString().trim { it <= ' ' }
                //map.put("postId",FirebaseDatabase.getInstance().getReference().child("Post").getRef().getKey());
                map["postId"] = postId
                map["deldate"] = deldate!!.text.toString().trim { it <= ' ' }
                map["pnumber"] = pnumber!!.text.toString().trim { it <= ' ' }
                map["approxFreight"] = approxFreight!!.text.toString().trim { it <= ' ' }
                map["notes"] = notes!!.text.toString().trim { it <= ' ' }
                map["totalWeight"] = totalW
                map["remainWeight"] = totalW
                map["totalBag"] = totalB
                if (productName2!!.getText().toString().trim { it <= ' ' }!!.length > 0) {
                    map["productName2"] = productName2!!.getText().toString().trim { it <= ' ' }
                    map["weight2"] = weight2!!.getText().toString().trim { it <= ' ' }
                    map["bag2"] = bag2!!.getText().toString().trim { it <= ' ' }
                    map["pnumber2"] = pnumber2!!.getText().toString().trim { it <= ' ' }
                }
                if (productName3!!.getText().toString().trim { it <= ' ' }!!.length > 0) {
                    map["productName3"] = productName3!!.getText().toString().trim { it <= ' ' }
                    map["weight3"] = weight3!!.getText().toString().trim { it <= ' ' }
                    map["bag3"] = bag3!!.getText().toString().trim { it <= ' ' }
                    map["pnumber3"] = pnumber3!!.getText().toString().trim { it <= ' ' }
                }
                if (productName4!!.getText().toString().trim { it <= ' ' }!!.length > 0) {
                    map["productName4"] = productName4!!.getText().toString().trim { it <= ' ' }
                    map["weight4"] = weight4!!.getText().toString().trim { it <= ' ' }
                    map["bag4"] = bag4!!.getText().toString().trim { it <= ' ' }
                    map["pnumber4"] = pnumber4!!.getText().toString().trim { it <= ' ' }
                }
                if (productName5!!.getText().toString().trim { it <= ' ' }!!.length > 0) {
                    map["productName5"] = productName5!!.getText().toString().trim { it <= ' ' }
                    map["weight5"] = weight5!!.getText().toString().trim { it <= ' ' }
                    map["bag5"] = bag5!!.getText().toString().trim { it <= ' ' }
                    map["pnumber5"] = pnumber5!!.getText().toString().trim { it <= ' ' }
                }
                if (productName6!!.getText().toString().trim { it <= ' ' }!!.length > 0) {
                    map["productName6"] = productName6!!.getText().toString().trim { it <= ' ' }
                    map["weight6"] = weight6!!.getText().toString().trim { it <= ' ' }
                    map["bag6"] = bag6!!.getText().toString().trim { it <= ' ' }
                    map["pnumber6"] = pnumber6!!.getText().toString().trim { it <= ' ' }
                }
                if (productName7!!.getText().toString().trim { it <= ' ' }!!.length > 0) {
                    map["productName7"] = productName7!!.getText().toString().trim { it <= ' ' }
                    map["weight7"] = weight7!!.getText().toString().trim { it <= ' ' }
                    map["bag7"] = bag7!!.getText().toString().trim { it <= ' ' }
                    map["pnumber7"] = pnumber7!!.getText().toString().trim { it <= ' ' }
                }
                if (productName8!!.getText().toString().trim { it <= ' ' }!!.length > 0) {
                    map["productName8"] = productName8!!.getText().toString().trim { it <= ' ' }
                    map["weight8"] = weight8!!.getText().toString().trim { it <= ' ' }
                    map["bag8"] = bag8!!.getText().toString().trim { it <= ' ' }
                    map["pnumber8"] = pnumber8!!.getText().toString().trim { it <= ' ' }
                }
                if (productName9!!.getText().toString().trim { it <= ' ' }!!.length > 0) {
                    map["productName9"] = productName9!!.getText().toString().trim { it <= ' ' }
                    map["weight9"] = weight9!!.getText().toString().trim { it <= ' ' }
                    map["bag9"] = bag9!!.getText().toString().trim { it <= ' ' }
                    map["pnumber9"] = pnumber9!!.getText().toString().trim { it <= ' ' }
                }
                if (productName10!!.getText().toString().trim { it <= ' ' }!!.length > 0) {
                    map["productName10"] = productName10!!.getText().toString().trim { it <= ' ' }
                    map["weight10"] = weight10!!.getText().toString().trim { it <= ' ' }
                    map["bag10"] = bag10!!.getText().toString().trim { it <= ' ' }
                    map["pnumber10"] = pnumber10!!.getText().toString().trim { it <= ' ' }
                }

                val mudatee =
                    SimpleDateFormat("yyyyMMdd_HHmmssSS", Locale.getDefault()).format(Date())
                map["dateid"] = mudatee.toString()
                Post!!.child(mudatee.toString())
                    .setValue(map)
                    .addOnCompleteListener { Log.i("complete", "onComplete :") }
                    .addOnFailureListener { e -> Log.i("error", "onFailure :$e") }

//


//save 1-6-2020 21-51
                Toast.makeText(applicationContext, "Entry Saved", Toast.LENGTH_SHORT).show()

                val imad = Intent(this@NewList, NewList::class.java)
                startActivity(imad)
                overridePendingTransition(0, 0)
                imad.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)

//                    final String strtit = "New Order No. - " +entrynumber!!.getText().toString();
//                    final String strmessag = customerName!!.getText().toString();
//
            }
        }
        pendinglist!!.setOnClickListener {
            //ttt.interrupt()
            fpList()
        }
    }

    // private TextWatcher textWatcher = new TextWatcher() {

    fun fpList() {
        val intent = Intent(this, PendingList::class.java)
        startActivity(intent)
    }

    override fun onBackPressed() {

        val i = Intent(this@NewList, MainActivity::class.java)
        startActivity(i)
        overridePendingTransition(0, 0)
        i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
        finish()
        super.onBackPressed()
    }

    private fun somany_focusfunction_edittext() {
        focusfunction_edittext(mobile!!)
        focusfunction_edittext(approxFreight!!)
        focusfunction_edittext(pono!!)
        focusfunction_edittext(notes!!)



        focusfunction_edittext(bag!!)
        focusfunction_edittext(bag2!!)
        focusfunction_edittext(bag3!!)
        focusfunction_edittext(bag4!!)
        focusfunction_edittext(bag5!!)
        focusfunction_edittext(bag6!!)
        focusfunction_edittext(bag7!!)
        focusfunction_edittext(bag8!!)
        focusfunction_edittext(bag9!!)
        focusfunction_edittext(bag10!!)

        focusfunction_edittext(weight!!)
        focusfunction_edittext(weight2!!)
        focusfunction_edittext(weight3!!)
        focusfunction_edittext(weight4!!)
        focusfunction_edittext(weight5!!)
        focusfunction_edittext(weight6!!)
        focusfunction_edittext(weight7!!)
        focusfunction_edittext(weight8!!)
        focusfunction_edittext(weight9!!)
        focusfunction_edittext(weight10!!)

        focusfunction_edittext(pnumber!!)
        focusfunction_edittext(pnumber2!!)
        focusfunction_edittext(pnumber3!!)
        focusfunction_edittext(pnumber4!!)
        focusfunction_edittext(pnumber5!!)
        focusfunction_edittext(pnumber6!!)
        focusfunction_edittext(pnumber7!!)
        focusfunction_edittext(pnumber8!!)
        focusfunction_edittext(pnumber9!!)
        focusfunction_edittext(pnumber10!!)
    }

    private fun somany_focusfunction_autocomplete_edittext() {
        focusfunction_autocomplete_edittext(customerName!!)
        focusfunction_autocomplete_edittext(delAddress!!)
        focusfunction_autocomplete_edittext(productName!!)
        focusfunction_autocomplete_edittext(productName10!!)
        focusfunction_autocomplete_edittext(productName2!!)
        focusfunction_autocomplete_edittext(productName3!!)
        focusfunction_autocomplete_edittext(productName4!!)
        focusfunction_autocomplete_edittext(productName5!!)
        focusfunction_autocomplete_edittext(productName6!!)
        focusfunction_autocomplete_edittext(productName7!!)
        focusfunction_autocomplete_edittext(productName8!!)
        focusfunction_autocomplete_edittext(productName9!!)
    }

    private fun focusfunction_edittext(ed:EditText) {
        ed!!.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                ed!!.background = ActivityCompat.getDrawable(
                    applicationContext,
                    R.drawable.edittext_border
                )
            } else {
                ed!!.background = ActivityCompat.getDrawable(
                    applicationContext,
                    R.drawable.left_edittext_border
                )
            }
        }
    }

    private fun focusfunction_autocomplete_edittext(actved:AutoCompleteTextView) {
        actved!!.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                actved!!.background = ActivityCompat.getDrawable(
                    applicationContext,
                    R.drawable.edittext_border
                )
            } else {
                actved!!.background = ActivityCompat.getDrawable(
                    applicationContext,
                    R.drawable.left_edittext_border
                )
            }
        }
    }

    private fun err_focusfunction_edittext(ed:EditText) {
//        ed!!.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
//            if (hasFocus) {
//                ed!!.background = ActivityCompat.getDrawable(
//                    (activity as AppCompatActivity).applicationContext,
//                    R.drawable.edittext_border
//                )
//            } else {
//                ed!!.background = ActivityCompat.getDrawable(
//                    (activity as AppCompatActivity).applicationContext,
//                    R.drawable.left_edittext_border
//                )
//            }
//        }

        ed!!.background = ActivityCompat.getDrawable(
           applicationContext,
            R.drawable.err_edittext_border
        )
    }

    private fun err_focusfunction_autocomplete_edittext(actved:AutoCompleteTextView) {
        actved!!.background = ActivityCompat.getDrawable(
            applicationContext,
            R.drawable.err_edittext_border
        )
    }
}


