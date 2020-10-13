package com.madappsdevlopers.padmavatisalt

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.content.Context
import android.content.Intent
import android.text.Editable
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.OnFailureListener
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.madappsdevlopers.padmavatisalt.PostAdapter.PostViewHolder
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder
import java.text.SimpleDateFormat
import java.util.*

class PostAdapter(
    options: FirebaseRecyclerOptions<Post?>,
    /**
     * Initialize a [RecyclerView.Adapter] that listens to a Firebase query. See
     * [FirebaseRecyclerOptions] for configuration options.
     *
     * @param options
     */
    private val context: Context
) : FirebaseRecyclerAdapter<Post?, PostViewHolder?>(options) {
    val td: ArrayList<*> = ArrayList<Any?>()

    //17-6-2020 1603 save
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int, model: Post) {
        holder.customerName.text = model.customerName
        //holder.customerAddress.setText(model.getCustomerAddress());
        holder.delAddress.text = model.delAddress
        holder.mobile.text = model.mobileNo
        holder.productName.text = model.productName
        holder.weight.text = model.weight
        holder.bag.text = model.bag
        holder.date.text = model.date
        holder.entrynumber.text = model.entry
        holder.pono.text = model.pono
        holder.deldate.text = model.deldate
        holder.totalB.text = model.totalBag
        holder.totalW.text = model.totalWeight
        holder.approxFreight.text = model.approxFreight
        holder.notes.text = model.notes

        holder.totalW1.text = model.dispatchWeight
        if (holder.totalW1.length() > 0) {
            holder.totalWname1.visibility = View.VISIBLE
            holder.totalW1.visibility = View.VISIBLE
            holder.totalWww1.visibility = View.VISIBLE
        }
        holder.totalW2.text = model.remainWeight
        if (holder.totalW2.length() > 0) {
            holder.totalWname2.visibility = View.VISIBLE
            holder.totalW2.visibility = View.VISIBLE
            holder.totalWww2.visibility = View.VISIBLE
        }


        if (holder.pono.text.toString().length > 0) {
            holder.pono.visibility = View.VISIBLE
            holder.pononame.visibility = View.VISIBLE
        }
        holder.productName2.text = model.productName2
        if (holder.productName2.text.toString().trim { it <= ' ' }.length > 0) {
            holder.linelay2.visibility = View.VISIBLE
            //  holder.bag2.setVisibility(View.VISIBLE);
            holder.bag2.text = model.bag2
            holder.weight2.text = model.weight2
        }
        holder.productName3.text = model.productName3
        if (holder.productName3.length() > 0) {
            holder.linelay3.visibility = View.VISIBLE
            holder.bag3.text = model.bag3
            holder.weight3.text = model.weight3
        }
        holder.productName4.text = model.productName4
        if (holder.productName4.length() > 0) {
            holder.linelay4.visibility = View.VISIBLE
            holder.bag4.text = model.bag4
            holder.weight4.text = model.weight4
        }
        holder.productName5.text = model.productName5
        if (holder.productName5.length() > 0) {
            holder.linelay5.visibility = View.VISIBLE
            holder.bag5.text = model.bag5
            holder.weight5.text = model.weight5
        }
        holder.productName6.text = model.productName6
        if (holder.productName6.length() > 0) {
            holder.linelay6.visibility = View.VISIBLE
            holder.bag6.text = model.bag6
            holder.weight6.text = model.weight6
        }
        holder.productName7.text = model.productName7
        if (holder.productName7.length() > 0) {
            holder.linelay7.visibility = View.VISIBLE
            holder.bag7.text = model.bag7
            holder.weight7.text = model.weight7
        }
        holder.productName8.text = model.productName8
        if (holder.productName8.length() > 0) {
            holder.linelay8.visibility = View.VISIBLE
            holder.bag8.text = model.bag8
            holder.weight8.text = model.weight8
        }
        holder.productName9.text = model.productName9
        if (holder.productName9.length() > 0) {
            holder.linelay9.visibility = View.VISIBLE
            holder.bag9.text = model.bag9
            holder.weight9.text = model.weight9
        }
        holder.productName10.text = model.productName10
        if (holder.productName10.length() > 0) {
            holder.linelay10.visibility = View.VISIBLE
            holder.bag10.text = model.bag10
            holder.weight10.text = model.weight10
        }
        holder.delete.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val dlog = DialogPlus.newDialog(context)
                    .setGravity(Gravity.CENTER)
                    .setMargin(50, 0, 50, 0)
                    .setContentHolder(ViewHolder(R.layout.deletepage))
                    .setExpanded(false) // This will enable the expand feature, (similar to android L share dialog)
                    .create()
                val hView: View = dlog.holderView as LinearLayout
                val reason = hView.findViewById<EditText>(R.id.reason)
                val del = hView.findViewById<Button>(R.id.deleteentry)
                del.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if (reason.length() >= 0) {
//                            val deledialog = DialogPlus.newDialog(context)
//                                .setGravity(Gravity.CENTER)
//                                .setMargin(50, 0, 50, 0)
//                                .setContentHolder(ViewHolder(R.layout.content))
//                                .setExpanded(false) // This will enable the expand feature, (similar to android L share dialog)
//                                .create()
//                            val holderView: View = deledialog.holderView as LinearLayout
//                            val customerName = holderView.findViewById<AutoCompleteTextView>(R.id.customerName)
//                            // final EditText customerAddress = holderView.findViewById(R.id.customerAddress);
//                           val productName = holderView.findViewById<AutoCompleteTextView>(R.id.productName)
//                            val mobile = holderView.findViewById<EditText>(R.id.mobileNo)
//                            val bag = holderView.findViewById<EditText>(R.id.bag)
//                            val weight = holderView.findViewById<EditText>(R.id.weight)
//                            val delAddress = holderView.findViewById<AutoCompleteTextView>(R.id.delAddress)
//                            val date = holderView.findViewById<TextView>(R.id.date)
//                            val entrynumber = holderView.findViewById<TextView>(R.id.entrynumber)
//                            val pono = holderView.findViewById<EditText>(R.id.pono)
//                            val deldate = holderView.findViewById<TextView>(R.id.deldate)
//                            val totalB = holderView.findViewById<TextView>(R.id.totalB)
//                            val totalW = holderView.findViewById<TextView>(R.id.totalW)
//                            val approxFreight = holderView.findViewById<EditText>(R.id.approxFreight)
//                            val pnumber = holderView.findViewById<EditText>(R.id.pnumber)
//                            val pnumber2 = holderView.findViewById<EditText>(R.id.pnumber2)
//                            val pnumber3 = holderView.findViewById<EditText>(R.id.pnumber3)
//                            val pnumber4 = holderView.findViewById<EditText>(R.id.pnumber4)
//                            val pnumber5 = holderView.findViewById<EditText>(R.id.pnumber5)
//                            val pnumber6 = holderView.findViewById<EditText>(R.id.pnumber6)
//                            val pnumber7 = holderView.findViewById<EditText>(R.id.pnumber7)
//                            val pnumber8 = holderView.findViewById<EditText>(R.id.pnumber8)
//                            val pnumber9 = holderView.findViewById<EditText>(R.id.pnumber9)
//                            val pnumber10 = holderView.findViewById<EditText>(R.id.pnumber10)
//                            val productName2 = holderView.findViewById<AutoCompleteTextView>(R.id.productName2)
//                            val productName3 = holderView.findViewById<AutoCompleteTextView>(R.id.productName3)
//                            val productName4 = holderView.findViewById<AutoCompleteTextView>(R.id.productName4)
//                            val productName5 = holderView.findViewById<AutoCompleteTextView>(R.id.productName5)
//                            val productName6 = holderView.findViewById<AutoCompleteTextView>(R.id.productName6)
//                            val productName7 = holderView.findViewById<AutoCompleteTextView>(R.id.productName7)
//                            val productName8 = holderView.findViewById<AutoCompleteTextView>(R.id.productName8)
//                            val productName9 = holderView.findViewById<AutoCompleteTextView>(R.id.productName9)
//                            val productName10 = holderView.findViewById<AutoCompleteTextView>(R.id.productName10)
//                            val bag2 = holderView.findViewById<EditText>(R.id.bag2)
//                            val bag3 = holderView.findViewById<EditText>(R.id.bag3)
//                            val bag4 = holderView.findViewById<EditText>(R.id.bag4)
//                            val bag5 = holderView.findViewById<EditText>(R.id.bag5)
//                            val bag6 = holderView.findViewById<EditText>(R.id.bag6)
//                            val bag7 = holderView.findViewById<EditText>(R.id.bag7)
//                            val bag8 = holderView.findViewById<EditText>(R.id.bag8)
//                            val bag9 = holderView.findViewById<EditText>(R.id.bag9)
//                            val bag10 = holderView.findViewById<EditText>(R.id.bag10)
//                            val weight2 = holderView.findViewById<EditText>(R.id.weight2)
//                            val weight3 = holderView.findViewById<EditText>(R.id.weight3)
//                            val weight4 = holderView.findViewById<EditText>(R.id.weight4)
//                            val weight5 = holderView.findViewById<EditText>(R.id.weight5)
//                            val weight6 = holderView.findViewById<EditText>(R.id.weight6)
//                            val weight7 = holderView.findViewById<EditText>(R.id.weight7)
//                            val weight8 = holderView.findViewById<EditText>(R.id.weight8)
//                            val weight9 = holderView.findViewById<EditText>(R.id.weight9)
//                            val weight10 = holderView.findViewById<EditText>(R.id.weight10)
//                            customerName.setText(model.getCustomerName())
//                            // customerAddress.setText(model.getCustomerAddress());
//                            delAddress.setText(model.getDelAddress())
//                            mobile.setText(model.getMobileNo())
//                            productName.setText(model.getProductName())
//                            weight.setText(model.getWeight())
//                            bag.setText(model.getBag())
//                            date.text = model.getDate()
//                            entrynumber.text = model.getEntry()
//                            pono.setText(model.getPono())
//                            deldate.text = model.getDeldate()
//                            pnumber.setText(model.getPnumber())
//                            totalB.text = model.getTotalBag()
//                            totalW.text = model.getTotalWeight()
//                            approxFreight.setText(model.getApproxFreight())
//                            productName2.setText(model.getProductName2())
//                            if (productName2.length() > 0) {
//                                bag2.setText(model.getBag2())
//                                weight2.setText(model.getWeight2())
//                                pnumber2.setText(model.getPnumber2())
//                            }
//                            productName3.setText(model.getProductName3())
//                            if (productName3.length() > 0) {
//                                bag3.setText(model.getBag3())
//                                weight3.setText(model.getWeight3())
//                                pnumber3.setText(model.getPnumber3())
//                            }
//                            productName4.setText(model.getProductName4())
//                            if (productName4.length() > 0) {
//                                bag4.setText(model.getBag4())
//                                weight4.setText(model.getWeight4())
//                                pnumber4.setText(model.getPnumber4())
//                            }
//                            productName5.setText(model.getProductName5())
//                            if (productName5.length() > 0) {
//                                bag5.setText(model.getBag5())
//                                weight5.setText(model.getWeight5())
//                                pnumber5.setText(model.getPnumber5())
//                            }
//                            productName6.setText(model.getProductName6())
//                            if (productName6.length() > 0) {
//                                bag6.setText(model.getBag6())
//                                weight6.setText(model.getWeight6())
//                                pnumber6.setText(model.getPnumber6())
//                            }
//                            productName7.setText(model.getProductName7())
//                            if (productName7.length() > 0) {
//                                bag7.setText(model.getBag7())
//                                weight7.setText(model.getWeight7())
//                                pnumber7.setText(model.getPnumber7())
//                            }
//                            productName8.setText(model.getProductName8())
//                            if (productName8.length() > 0) {
//                                bag8.setText(model.getBag8())
//                                weight8.setText(model.getWeight8())
//                                pnumber8.setText(model.getPnumber8())
//                            }
//                            productName9.setText(model.getProductName9())
//                            if (productName9.length() > 0) {
//                                bag9.setText(model.getBag9())
//                                weight9.setText(model.getWeight9())
//                                pnumber9.setText(model.getPnumber9())
//                            }
//                            productName10.setText(model.getProductName10())
//                            if (productName10.length() > 0) {
//                                bag10.setText(model.getBag10())
//                                weight10.setText(model.getWeight10())
//                                pnumber10.setText(model.getPnumber10())
//                            }
                            val dismap1: MutableMap<String, Any> = HashMap()
                            dismap1["customerName"] = model.customerName.toString()
                            //    dismap.put("customerAddress",customerAddress.getText().toString());
                            dismap1["productName"] = model.productName.toString()
                            dismap1["mobileNo"] = model.mobileNo.toString()
                            dismap1["weight"] = model.weight.toString()
                            dismap1["bag"] = model.bag.toString()
                            dismap1["delAddress"] = model.delAddress.toString()
                            dismap1["date"] = model.date.toString()
                            dismap1["entry"] = model.entry.toString()
                            dismap1["reason"] = reason.text.toString()
                            //dismap.put("drivermobile",drivermobile.getText().toString());
                            dismap1["pono"] = model.pono.toString()
                            dismap1["deldate"] = model.deldate.toString()
                            dismap1["pnumber"] = model.pnumber.toString()
                            dismap1["totalBag"] = model.totalBag.toString()
                            dismap1["totalWeight"] = model.totalWeight.toString()
                            dismap1["remainWeight"] = model.remainWeight.toString()
                            dismap1["dateid"] = model.dateid.toString()
                            dismap1["notes"] = model.notes.toString()

                            dismap1["approxFreight"] = model.approxFreight.toString()
                            if (model.productName2.toString().trim { it <= ' ' } != "null") {
                                dismap1["productName2"] =
                                    model.productName2.toString().trim { it <= ' ' }
                                dismap1["weight2"] = model.weight2.toString().trim { it <= ' ' }
                                dismap1["bag2"] = model.bag2.toString().trim { it <= ' ' }
                                dismap1["pnumber2"] = model.pnumber2.toString()
                            }
                            if (model.productName3.toString().trim { it <= ' ' } != "null") {
                                dismap1["productName3"] =
                                    model.productName3.toString().trim { it <= ' ' }
                                dismap1["weight3"] = model.weight3.toString().trim { it <= ' ' }
                                dismap1["bag3"] = model.bag3.toString().trim { it <= ' ' }
                                dismap1["pnumber3"] = model.pnumber3.toString()
                            }
                            if (model.productName4.toString().trim { it <= ' ' } != "null") {
                                dismap1["productName4"] =
                                    model.productName4.toString().trim { it <= ' ' }
                                dismap1["weight4"] = model.weight4.toString().trim { it <= ' ' }
                                dismap1["bag4"] = model.bag4.toString().trim { it <= ' ' }
                                dismap1["pnumber4"] = model.pnumber4.toString()
                            }
                            if (model.productName5.toString().trim { it <= ' ' } != "null") {
                                dismap1["productName5"] =
                                    model.productName5.toString().trim { it <= ' ' }
                                dismap1["weight5"] = model.weight5.toString().trim { it <= ' ' }
                                dismap1["bag5"] = model.bag5.toString().trim { it <= ' ' }
                                dismap1["pnumber5"] = model.pnumber5.toString()
                            }
                            if (model.productName6.toString().trim { it <= ' ' } != "null") {
                                dismap1["productName6"] =
                                    model.productName6.toString().trim { it <= ' ' }
                                dismap1["weight6"] = model.weight6.toString().trim { it <= ' ' }
                                dismap1["bag6"] = model.bag6.toString().trim { it <= ' ' }
                                dismap1["pnumber6"] = model.pnumber6.toString()
                            }
                            if (model.productName7.toString().trim { it <= ' ' } != "null") {
                                dismap1["productName7"] =
                                    model.productName7.toString().trim { it <= ' ' }
                                dismap1["weight7"] = model.weight7.toString().trim { it <= ' ' }
                                dismap1["bag7"] = model.bag7.toString().trim { it <= ' ' }
                                dismap1["pnumber7"] = model.pnumber7.toString()
                            }
                            if (model.productName8.toString().trim { it <= ' ' } != "null") {
                                dismap1["productName8"] =
                                    model.productName8.toString().trim { it <= ' ' }
                                dismap1["weight8"] = model.weight8.toString().trim { it <= ' ' }
                                dismap1["bag8"] = model.bag8.toString().trim { it <= ' ' }
                                dismap1["pnumber8"] = model.pnumber8.toString()
                            }
                            if (model.productName9.toString().trim { it <= ' ' } != "null") {
                                dismap1["productName9"] =
                                    model.productName9.toString().trim { it <= ' ' }
                                dismap1["weight9"] = model.weight9.toString().trim { it <= ' ' }
                                dismap1["bag9"] = model.bag9.toString().trim { it <= ' ' }
                                dismap1["pnumber9"] = model.pnumber9.toString()
                            }
                            if (model.productName10.toString().trim { it <= ' ' } != "null") {
                                dismap1["productName10"] =
                                    model.productName10.toString().trim { it <= ' ' }
                                dismap1["weight10"] = model.weight10.toString().trim { it <= ' ' }
                                dismap1["bag10"] = model.bag10.toString().trim { it <= ' ' }
                                dismap1["pnumber10"] = model.pnumber10.toString()
                            }
                            val mudateeddd =
                                SimpleDateFormat("yyyyMMdd_HHmmssSS", Locale.getDefault()).format(
                                    Date()
                                )
                            FirebaseDatabase.getInstance().reference.child("DeleteList")
                                .child(mudateeddd.toString())
                                .setValue(dismap1)
                                .addOnCompleteListener {

                                    dlog.dismiss()
                                    //  deledialog.dismiss()

                                }
                            FirebaseDatabase.getInstance().reference.child("Post")
                                .child((getRef(position).key)!!)
                                .removeValue().addOnCompleteListener {

                                    val intt = Intent(context, PendingList::class.java)
                                    context.startActivity(intt)
                                }

                                .addOnFailureListener(OnFailureListener { e ->
                                    Log.i(
                                        "errordeletedialogbog",
                                        "onFailure :$e"
                                    )
                                })
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
                        } else { //remain
                            Toast.makeText(
                                context,
                                "Please enter proper reason",
                                Toast.LENGTH_SHORT
                            ).show()
                        } //
                        // Map<String,Object> dismap = new HashMap<>();
                        // dismap.put("customerName",customerName.getText().toString());
                    }
                })
                dlog.show()
            }
        })
        holder.edit.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val dialog = DialogPlus.newDialog(context)
                    .setGravity(Gravity.CENTER)
                    .setMargin(50, 0, 50, 0)
                    .setContentHolder(ViewHolder(R.layout.content))
                    .setExpanded(false) // This will enable the expand feature, (similar to android L share dialog)
                    .create()
                val holderView: View = dialog.holderView as LinearLayout
                val customerName = holderView.findViewById<AutoCompleteTextView>(R.id.customerName)
                //  final EditText customerAddress = holderView.findViewById(R.id.customerAddress);
                val productName = holderView.findViewById<AutoCompleteTextView>(R.id.productName)
                val mobile = holderView.findViewById<EditText>(R.id.mobileNo)
                val bag = holderView.findViewById<EditText>(R.id.bag)
                val date = holderView.findViewById<TextView>(R.id.date)
                val weight = holderView.findViewById<EditText>(R.id.weight)
                val delAddress = holderView.findViewById<AutoCompleteTextView>(R.id.delAddress)
                val pono = holderView.findViewById<EditText>(R.id.pono)
                val deldate = holderView.findViewById<TextView>(R.id.deldate)
                val entrynumber = holderView.findViewById<TextView>(R.id.entrynumber)
                val pnumber = holderView.findViewById<EditText>(R.id.pnumber)
                val totalB = holderView.findViewById<TextView>(R.id.totalB)
                val totalW = holderView.findViewById<TextView>(R.id.totalW)
                val approxFreight = holderView.findViewById<EditText>(R.id.approxFreight)

                val notes = holderView.findViewById<EditText>(R.id.notes)

                val addbtn = holderView.findViewById<Button>(R.id.addbtn)
                val productName2 = holderView.findViewById<AutoCompleteTextView>(R.id.productName2)
                val productName3 = holderView.findViewById<AutoCompleteTextView>(R.id.productName3)
                val productName4 = holderView.findViewById<AutoCompleteTextView>(R.id.productName4)
                val productName5 = holderView.findViewById<AutoCompleteTextView>(R.id.productName5)
                val productName6 = holderView.findViewById<AutoCompleteTextView>(R.id.productName6)
                val productName7 = holderView.findViewById<AutoCompleteTextView>(R.id.productName7)
                val productName8 = holderView.findViewById<AutoCompleteTextView>(R.id.productName8)
                val productName9 = holderView.findViewById<AutoCompleteTextView>(R.id.productName9)
                val productName10 =
                    holderView.findViewById<AutoCompleteTextView>(R.id.productName10)
                val bag2 = holderView.findViewById<EditText>(R.id.bag2)
                val bag3 = holderView.findViewById<EditText>(R.id.bag3)
                val bag4 = holderView.findViewById<EditText>(R.id.bag4)
                val bag5 = holderView.findViewById<EditText>(R.id.bag5)
                val bag6 = holderView.findViewById<EditText>(R.id.bag6)
                val bag7 = holderView.findViewById<EditText>(R.id.bag7)
                val bag8 = holderView.findViewById<EditText>(R.id.bag8)
                val bag9 = holderView.findViewById<EditText>(R.id.bag9)
                val bag10 = holderView.findViewById<EditText>(R.id.bag10)
                val weight2 = holderView.findViewById<EditText>(R.id.weight2)
                val weight3 = holderView.findViewById<EditText>(R.id.weight3)
                val weight4 = holderView.findViewById<EditText>(R.id.weight4)
                val weight5 = holderView.findViewById<EditText>(R.id.weight5)
                val weight6 = holderView.findViewById<EditText>(R.id.weight6)
                val weight7 = holderView.findViewById<EditText>(R.id.weight7)
                val weight8 = holderView.findViewById<EditText>(R.id.weight8)
                val weight9 = holderView.findViewById<EditText>(R.id.weight9)
                val weight10 = holderView.findViewById<EditText>(R.id.weight10)
                val pnumber2 = holderView.findViewById<EditText>(R.id.pnumber2)
                val pnumber3 = holderView.findViewById<EditText>(R.id.pnumber3)
                val pnumber4 = holderView.findViewById<EditText>(R.id.pnumber4)
                val pnumber5 = holderView.findViewById<EditText>(R.id.pnumber5)
                val pnumber6 = holderView.findViewById<EditText>(R.id.pnumber6)
                val pnumber7 = holderView.findViewById<EditText>(R.id.pnumber7)
                val pnumber8 = holderView.findViewById<EditText>(R.id.pnumber8)
                val pnumber9 = holderView.findViewById<EditText>(R.id.pnumber9)
                val pnumber10 = holderView.findViewById<EditText>(R.id.pnumber10)
                val bagee2 = holderView.findViewById<TextView>(R.id.bagee2)
                val bagee3 = holderView.findViewById<TextView>(R.id.bagee3)
                val bagee4 = holderView.findViewById<TextView>(R.id.bagee4)
                val bagee5 = holderView.findViewById<TextView>(R.id.bagee5)
                val bagee6 = holderView.findViewById<TextView>(R.id.bagee6)
                val bagee7 = holderView.findViewById<TextView>(R.id.bagee7)
                val bagee8 = holderView.findViewById<TextView>(R.id.bagee8)
                val bagee9 = holderView.findViewById<TextView>(R.id.bagee9)
                val bagee10 = holderView.findViewById<TextView>(R.id.bagee10)
                val prroducct2 = holderView.findViewById<TextView>(R.id.prroducct2)
                val prroducct3 = holderView.findViewById<TextView>(R.id.prroducct3)
                val prroducct4 = holderView.findViewById<TextView>(R.id.prroducct4)
                val prroducct5 = holderView.findViewById<TextView>(R.id.prroducct5)
                val prroducct6 = holderView.findViewById<TextView>(R.id.prroducct6)
                val prroducct7 = holderView.findViewById<TextView>(R.id.prroducct7)
                val prroducct8 = holderView.findViewById<TextView>(R.id.prroducct8)
                val prroducct9 = holderView.findViewById<TextView>(R.id.prroducct9)
                val prroducct10 = holderView.findViewById<TextView>(R.id.prroducct10)
                val weightee2 = holderView.findViewById<TextView>(R.id.weightee2)
                val weightee3 = holderView.findViewById<TextView>(R.id.weightee3)
                val weightee4 = holderView.findViewById<TextView>(R.id.weightee4)
                val weightee5 = holderView.findViewById<TextView>(R.id.weightee5)
                val weightee6 = holderView.findViewById<TextView>(R.id.weightee6)
                val weightee7 = holderView.findViewById<TextView>(R.id.weightee7)
                val weightee8 = holderView.findViewById<TextView>(R.id.weightee8)
                val weightee9 = holderView.findViewById<TextView>(R.id.weightee9)
                val weightee10 = holderView.findViewById<TextView>(R.id.weightee10)


                // final Button addbtn = holderView.findViewById(R.id.addbtn);
                val addbtn2 = holderView.findViewById<Button>(R.id.addbtn2)
                val addbtn3 = holderView.findViewById<Button>(R.id.addbtn3)
                val addbtn4 = holderView.findViewById<Button>(R.id.addbtn4)
                val addbtn5 = holderView.findViewById<Button>(R.id.addbtn5)
                val addbtn6 = holderView.findViewById<Button>(R.id.addbtn6)
                val addbtn7 = holderView.findViewById<Button>(R.id.addbtn7)
                val addbtn8 = holderView.findViewById<Button>(R.id.addbtn8)
                val addbtn9 = holderView.findViewById<Button>(R.id.addbtn9)
                val addbtn10 = holderView.findViewById<Button>(R.id.addbtn10)

                val customerarraylist01 = ArrayList<String>()

                val customermobilearraylist01 = ArrayList<String>()
                val clistee = FirebaseDatabase.getInstance().reference.child("CustomerList")
                clistee.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (dataSnapshot1: DataSnapshot in dataSnapshot.children) {
                            val customerarray01 =
                                dataSnapshot1.child("customerName").value.toString()
                            val customermobilearray01 =
                                dataSnapshot1.child("mobileNo").value.toString()
                            //System.out.println("thisissintel  " +a101);
                            if (customerarraylist01.contains(customerarray01)) {
                            } else {
                                customerarraylist01.add(customerarray01)
                                customermobilearraylist01.add(customermobilearray01)
                            }
                            //  rowList.add(new RowItem(customerarray));
                        }
                        //System.out.println("thisissintel23cname  " +customerarraylist01);System.out.println("thisissintel23mobilename  " +customermobilearraylist);
                        val customerarrayadap01 = ArrayAdapter(
                            context,
                            android.R.layout.simple_list_item_1,
                            customerarraylist01
                        )
                        customerName.setAdapter(customerarrayadap01)
                        customerName.onItemClickListener =
                            object : AdapterView.OnItemClickListener {
                                override fun onItemClick(
                                    parent: AdapterView<*>,
                                    view: View,
                                    position: Int,
                                    id: Long
                                ) {
                                    val itemposition09: String =
                                        parent.getItemAtPosition(position).toString()
                                    //    println("thisissintel23cnameposit  $itemposition09")
                                    val pos: Int = customerarraylist01.indexOf(itemposition09)
                                    //     println("thisissintel23cnameposit  $pos")
                                    mobile.setText(customermobilearraylist01.get(pos))
                                }
                            }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {}
                })
                val productarray = ""
                val productarraylist = ArrayList<String>()
                val pnumberarray = ""
                val pnumberarraylist = ArrayList<String>()
                val prroductList = FirebaseDatabase.getInstance().reference.child("ProductsList")
                prroductList.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (dataSnapshot1: DataSnapshot in dataSnapshot.children) {
                            val productarray = dataSnapshot1.child("productName").value.toString()
                            val pnumberarray = dataSnapshot1.child("pnumber").value.toString()
                            //System.out.println("thisissintel  " +a101);
                            if (productarraylist.contains(productarray)) {
                            } else {
                                productarraylist.add(productarray)
                                pnumberarraylist.add(pnumberarray)
                            }
                        }
                        //  println("thisissintel23pname  $productarraylist")
                        val productarrayadap = ArrayAdapter(
                            context,
                            android.R.layout.simple_list_item_1,
                            productarraylist
                        )
                        productName.setAdapter(productarrayadap)
                        productName2.setAdapter(productarrayadap)
                        productName3.setAdapter(productarrayadap)
                        productName4.setAdapter(productarrayadap)
                        productName5.setAdapter(productarrayadap)
                        productName6.setAdapter(productarrayadap)
                        productName7.setAdapter(productarrayadap)
                        productName8.setAdapter(productarrayadap)
                        productName9.setAdapter(productarrayadap)
                        productName10.setAdapter(productarrayadap)
                        productName.onItemClickListener = object : AdapterView.OnItemClickListener {
                            override fun onItemClick(
                                parent: AdapterView<*>,
                                view: View,
                                position: Int,
                                id: Long
                            ) {
                                val itemposition0921: String =
                                    parent.getItemAtPosition(position).toString()
                                //System.out.println("thisissintel23cnameposit  " +itemposition0921);
                                val pos21: Int = productarraylist.indexOf(itemposition0921)
                                // System.out.println("thisissintel23cnameposit  " +pos21);
                                pnumber.setText(pnumberarraylist.get(pos21))
                            }
                        }
                        productName2.onItemClickListener =
                            object : AdapterView.OnItemClickListener {
                                override fun onItemClick(
                                    parent: AdapterView<*>,
                                    view: View,
                                    position: Int,
                                    id: Long
                                ) {
                                    val ipos2: String =
                                        parent.getItemAtPosition(position).toString()
                                    val pos02: Int = productarraylist.indexOf(ipos2)
                                    pnumber2.setText(pnumberarraylist.get(pos02))
                                }
                            }
                        productName3.onItemClickListener =
                            object : AdapterView.OnItemClickListener {
                                override fun onItemClick(
                                    parent: AdapterView<*>,
                                    view: View,
                                    position: Int,
                                    id: Long
                                ) {
                                    val ipos3: String =
                                        parent.getItemAtPosition(position).toString()
                                    val pos03: Int = productarraylist.indexOf(ipos3)
                                    pnumber3.setText(pnumberarraylist.get(pos03))
                                }
                            }
                        productName4.onItemClickListener =
                            object : AdapterView.OnItemClickListener {
                                override fun onItemClick(
                                    parent: AdapterView<*>,
                                    view: View,
                                    position: Int,
                                    id: Long
                                ) {
                                    val ipos4: String =
                                        parent.getItemAtPosition(position).toString()
                                    val pos04: Int = productarraylist.indexOf(ipos4)
                                    pnumber4.setText(pnumberarraylist.get(pos04))
                                }
                            }
                        productName5.onItemClickListener =
                            object : AdapterView.OnItemClickListener {
                                override fun onItemClick(
                                    parent: AdapterView<*>,
                                    view: View,
                                    position: Int,
                                    id: Long
                                ) {
                                    val ipos5: String =
                                        parent.getItemAtPosition(position).toString()
                                    val pos05: Int = productarraylist.indexOf(ipos5)
                                    pnumber5.setText(pnumberarraylist.get(pos05))
                                }
                            }
                        productName6.onItemClickListener =
                            object : AdapterView.OnItemClickListener {
                                override fun onItemClick(
                                    parent: AdapterView<*>,
                                    view: View,
                                    position: Int,
                                    id: Long
                                ) {
                                    val ipos6: String =
                                        parent.getItemAtPosition(position).toString()
                                    val pos06: Int = productarraylist.indexOf(ipos6)
                                    pnumber6.setText(pnumberarraylist.get(pos06))
                                }
                            }
                        productName7.onItemClickListener =
                            object : AdapterView.OnItemClickListener {
                                override fun onItemClick(
                                    parent: AdapterView<*>,
                                    view: View,
                                    position: Int,
                                    id: Long
                                ) {
                                    val ipos7: String =
                                        parent.getItemAtPosition(position).toString()
                                    val pos07: Int = productarraylist.indexOf(ipos7)
                                    pnumber7.setText(pnumberarraylist.get(pos07))
                                }
                            }
                        productName8.onItemClickListener =
                            object : AdapterView.OnItemClickListener {
                                override fun onItemClick(
                                    parent: AdapterView<*>,
                                    view: View,
                                    position: Int,
                                    id: Long
                                ) {
                                    val ipos8: String =
                                        parent.getItemAtPosition(position).toString()
                                    val pos08: Int = productarraylist.indexOf(ipos8)
                                    pnumber8.setText(pnumberarraylist.get(pos08))
                                }
                            }
                        productName9.onItemClickListener =
                            object : AdapterView.OnItemClickListener {
                                override fun onItemClick(
                                    parent: AdapterView<*>,
                                    view: View,
                                    position: Int,
                                    id: Long
                                ) {
                                    val ipos9: String =
                                        parent.getItemAtPosition(position).toString()
                                    val pos09: Int = productarraylist.indexOf(ipos9)
                                    pnumber9.setText(pnumberarraylist.get(pos09))
                                }
                            }
                        productName10.onItemClickListener =
                            object : AdapterView.OnItemClickListener {
                                override fun onItemClick(
                                    parent: AdapterView<*>,
                                    view: View,
                                    position: Int,
                                    id: Long
                                ) {
                                    val ipos10: String =
                                        parent.getItemAtPosition(position).toString()
                                    val pos010: Int = productarraylist.indexOf(ipos10)
                                    pnumber10.setText(pnumberarraylist.get(pos010))
                                }
                            }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {}
                })
                val deladdarray01 = ""
                val deladdarraylist01 = ArrayList<String>()
                val deeladdList =
                    FirebaseDatabase.getInstance().reference.child("DeliveryAddressList")
                deeladdList.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        for (dataSnapshot1: DataSnapshot in dataSnapshot.children) {
                            val deladdarray01 = dataSnapshot1.child("delAddress").value.toString()
                            //System.out.println("thisissintel  " +a101);
                            if (deladdarraylist01.contains(deladdarray01)) {
                            } else {
                                deladdarraylist01.add(deladdarray01)
                            }
                        }
                        //   println("thisissintel23daddname  $deladdarraylist01")
                        val deladdarrayadap01 = ArrayAdapter(
                            context,
                            android.R.layout.simple_list_item_1,
                            deladdarraylist01
                        )
                        delAddress.setAdapter(deladdarrayadap01)
                    }

                    override fun onCancelled(databaseError: DatabaseError) {}
                })
                bag.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber.length() == 0) || (weight.length() == 0) || (pnumber.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x = pnumber.text.toString().trim { it <= ' ' }.toDouble()
                            val z = weight.text.toString().trim { it <= ' ' }.toDouble()
                            val bagno = (z / x) * 1000
                            bag.setText(Math.round(bagno).toString())
                        }
                    }
                })
                bag2.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber2.length() == 0) || (weight2.length() == 0) || (pnumber2.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber2.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber2.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber2.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x2 = pnumber2.text.toString().trim { it <= ' ' }.toDouble()
                            val z2 = weight2.text.toString().trim { it <= ' ' }.toDouble()
                            val bagno2 = (z2 / x2) * 1000
                            bag2.setText(Math.round(bagno2).toString())
                        }
                    }
                })
                bag3.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber3.length() == 0) || (weight3.length() == 0) || (pnumber3.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber3.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber3.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber3.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x3 = pnumber3.text.toString().trim { it <= ' ' }.toDouble()
                            val z3 = weight3.text.toString().trim { it <= ' ' }.toDouble()
                            val bagno3 = (z3 / x3) * 1000
                            bag3.setText(Math.round(bagno3).toString())
                        }
                    }
                })
                bag4.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber4.length() == 0) || (weight4.length() == 0) || (pnumber4.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber4.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber4.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber4.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x4 = pnumber4.text.toString().trim { it <= ' ' }.toDouble()
                            val z4 = weight4.text.toString().trim { it <= ' ' }.toDouble()
                            val bagno4 = (z4 / x4) * 1000
                            bag4.setText(Math.round(bagno4).toString())
                        }
                    }
                })
                bag5.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber5.length() == 0) || (weight5.length() == 0) || (pnumber5.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber5.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber5.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber5.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x5 = pnumber5.text.toString().trim { it <= ' ' }.toDouble()
                            val z5 = weight5.text.toString().trim { it <= ' ' }.toDouble()
                            val bagno5 = (z5 / x5) * 1000
                            bag5.setText(Math.round(bagno5).toString())
                        }
                    }
                })
                bag6.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber6.length() == 0) || (weight6.length() == 0) || (pnumber6.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber6.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber6.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber6.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x6 = pnumber6.text.toString().trim { it <= ' ' }.toDouble()
                            val z6 = weight6.text.toString().trim { it <= ' ' }.toDouble()
                            val bagno6 = (z6 / x6) * 1000
                            bag6.setText(Math.round(bagno6).toString())
                        }
                    }
                })
                bag7.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber7.length() == 0) || (weight7.length() == 0) || (pnumber7.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber7.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber7.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber7.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x7 = pnumber7.text.toString().trim { it <= ' ' }.toDouble()
                            val z7 = weight7.text.toString().trim { it <= ' ' }.toDouble()
                            val bagno7 = (z7 / x7) * 1000
                            bag7.setText(Math.round(bagno7).toString())
                        }
                    }
                })
                bag8.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber8.length() == 0) || (weight8.length() == 0) || (pnumber8.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber8.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber8.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber8.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x8 = pnumber8.text.toString().trim { it <= ' ' }.toDouble()
                            val z8 = weight8.text.toString().trim { it <= ' ' }.toDouble()
                            val bagno8 = (z8 / x8) * 1000
                            bag8.setText(Math.round(bagno8).toString())
                        }
                    }
                })
                bag9.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber9.length() == 0) || (weight9.length() == 0) || (pnumber9.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber9.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber9.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber9.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x9 = pnumber9.text.toString().trim { it <= ' ' }.toDouble()
                            val z9 = weight9.text.toString().trim { it <= ' ' }.toDouble()
                            val bagno9 = (z9 / x9) * 1000
                            bag9.setText(Math.round(bagno9).toString())
                        }
                    }
                })
                bag10.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber10.length() == 0) || (weight10.length() == 0) || (pnumber10.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber10.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber10.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber10.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x10 = pnumber10.text.toString().trim { it <= ' ' }.toDouble()
                            val z10 = weight10.text.toString().trim { it <= ' ' }.toDouble()
                            val bagno10 = (z10 / x10) * 1000
                            bag10.setText(Math.round(bagno10).toString())
                        }
                    }
                })
                weight.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber.length() == 0) || (bag.length() == 0) || (pnumber.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x = pnumber.text.toString().trim { it <= ' ' }.toDouble()
                            val y = bag.text.toString().trim { it <= ' ' }.toDouble()
                            val weightinton = (x * y) / 1000
                            weight.setText(weightinton.toString())
                        }
                    }
                })
                weight2.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber2.length() == 0) || (bag2.length() == 0) || (pnumber2.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber2.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber2.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber2.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x2 = pnumber2.text.toString().trim { it <= ' ' }.toDouble()
                            val y2 = bag2.text.toString().trim { it <= ' ' }.toDouble()
                            val weightinton2 = (x2 * y2) / 1000
                            weight2.setText(weightinton2.toString())
                        }
                    }
                })
                weight3.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber3.length() == 0) || (bag3.length() == 0) || (pnumber3.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber3.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber3.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber3.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x3 = pnumber3.text.toString().trim { it <= ' ' }.toDouble()
                            val y3 = bag3.text.toString().trim { it <= ' ' }.toDouble()
                            val weightinton3 = (x3 * y3) / 1000
                            weight3.setText(weightinton3.toString())
                        }
                    }
                })
                weight4.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber4.length() == 0) || (bag4.length() == 0) || (pnumber4.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber4.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber4.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber4.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x4 = pnumber4.text.toString().trim { it <= ' ' }.toDouble()
                            val y4 = bag4.text.toString().trim { it <= ' ' }.toDouble()
                            val weightinton4 = (x4 * y4) / 1000
                            weight4.setText(weightinton4.toString())
                        }
                    }
                })
                weight5.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber5.length() == 0) || (bag5.length() == 0) || (pnumber5.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber5.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber5.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber5.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x5 = pnumber5.text.toString().trim { it <= ' ' }.toDouble()
                            val y5 = bag5.text.toString().trim { it <= ' ' }.toDouble()
                            val weightinton5 = (x5 * y5) / 1000
                            weight5.setText(weightinton5.toString())
                        }
                    }
                })
                weight6.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber6.length() == 0) || (bag6.length() == 0) || (pnumber6.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber6.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber6.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber6.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x6 = pnumber6.text.toString().trim { it <= ' ' }.toDouble()
                            val y6 = bag6.text.toString().trim { it <= ' ' }.toDouble()
                            val weightinton6 = (x6 * y6) / 1000
                            weight6.setText(weightinton6.toString())
                        }
                    }
                })
                weight7.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber7.length() == 0) || (bag7.length() == 0) || (pnumber7.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber7.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber7.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber7.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x7 = pnumber7.text.toString().trim { it <= ' ' }.toDouble()
                            val y7 = bag7.text.toString().trim { it <= ' ' }.toDouble()
                            val weightinton7 = (x7 * y7) / 1000
                            weight7.setText(weightinton7.toString())
                        }
                    }
                })
                weight8.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber8.length() == 0) || (bag8.length() == 0) || (pnumber8.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber8.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber8.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber8.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x8 = pnumber8.text.toString().trim { it <= ' ' }.toDouble()
                            val y8 = bag8.text.toString().trim { it <= ' ' }.toDouble()
                            val weightinton8 = (x8 * y8) / 1000
                            weight8.setText(weightinton8.toString())
                        }
                    }
                })
                weight9.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber9.length() == 0) || (bag9.length() == 0) || (pnumber9.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber9.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber9.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber9.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x9 = pnumber9.text.toString().trim { it <= ' ' }.toDouble()
                            val y9 = bag9.text.toString().trim { it <= ' ' }.toDouble()
                            val weightinton9 = (x9 * y9) / 1000
                            weight9.setText(weightinton9.toString())
                        }
                    }
                })
                weight10.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if ((pnumber10.length() == 0) || (bag10.length() == 0) || (pnumber10.text.toString()
                                .trim { it <= ' ' } == "null") || (pnumber10.text.toString()
                                .trim { it <= ' ' } == "nul") || (pnumber10.text.toString()
                                .trim { it <= ' ' } == "nu") || (pnumber10.text.toString()
                                .trim { it <= ' ' } == "n")
                        ) {
                        } else {
                            val x10 = pnumber10.text.toString().trim { it <= ' ' }.toDouble()
                            val y10 = bag10.text.toString().trim { it <= ' ' }.toDouble()
                            val weightinton10 = (x10 * y10) / 1000
                            weight10.setText(weightinton10.toString())
                        }
                    }
                })
                entrynumber.text = model.entry
                customerName.setText(model.customerName)
                date.text = model.date
                //  customerAddress.setText(model.getCustomerAddress());
                delAddress.setText(model.delAddress)
                mobile.setText(model.mobileNo)
                productName.setText(model.productName)
                weight.setText(model.weight)
                bag.setText(model.bag)
                pono.setText(model.pono)
                deldate.text = model.deldate
                pnumber.setText(model.pnumber)
                totalB.text = model.totalBag
                totalW.text = model.totalWeight
                notes.setText(model.notes)
                approxFreight.setText(model.approxFreight)
                deldate.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        val calendar = Calendar.getInstance()
                        val year = calendar[Calendar.YEAR]
                        val month = calendar[Calendar.MONTH]
                        val day = calendar[Calendar.DAY_OF_MONTH]
                        val datePickerDialog =
                            DatePickerDialog(context, object : OnDateSetListener {
                                override fun onDateSet(
                                    view: DatePicker,
                                    i0: Int,
                                    i1: Int,
                                    i2: Int
                                ) {
                                    val showDate = i2.toString() + "-" + (i1 + 1) + "-" + i0
                                    deldate.text = showDate
                                }
                            }, year, month, day)
                        datePickerDialog.datePicker.minDate = System.currentTimeMillis() - 1000
                        datePickerDialog.show()
                    }
                })
                productName2.setText(model.productName2)
                if (productName2.length() > 0) {
                    productName2.visibility = View.VISIBLE
                    prroducct2.visibility = View.VISIBLE
                    bagee2.visibility = View.VISIBLE
                    bag2.visibility = View.VISIBLE
                    weightee2.visibility = View.VISIBLE
                    weight2.visibility = View.VISIBLE
                    pnumber2.visibility = View.VISIBLE
                    addbtn2.visibility = View.VISIBLE
                    bag2.setText(model.bag2)
                    weight2.setText(model.weight2)
                    pnumber2.setText(model.pnumber2)
                }
                productName3.setText(model.productName3)
                if (productName3.length() > 0) {
                    productName3.visibility = View.VISIBLE
                    prroducct3.visibility = View.VISIBLE
                    bagee3.visibility = View.VISIBLE
                    bag3.visibility = View.VISIBLE
                    weightee3.visibility = View.VISIBLE
                    weight3.visibility = View.VISIBLE
                    pnumber3.visibility = View.VISIBLE
                    addbtn3.visibility = View.VISIBLE
                    pnumber3.setText(model.pnumber3)
                    bag3.setText(model.bag3)
                    weight3.setText(model.weight3)
                }
                productName4.setText(model.productName4)
                if (productName4.length() > 0) {
                    productName4.visibility = View.VISIBLE
                    prroducct4.visibility = View.VISIBLE
                    bagee4.visibility = View.VISIBLE
                    bag4.visibility = View.VISIBLE
                    weightee4.visibility = View.VISIBLE
                    weight4.visibility = View.VISIBLE
                    pnumber4.visibility = View.VISIBLE
                    addbtn4.visibility = View.VISIBLE
                    pnumber4.setText(model.pnumber4)
                    bag4.setText(model.bag4)
                    weight4.setText(model.weight4)
                }
                productName5.setText(model.productName5)
                if (productName5.length() > 0) {
                    productName5.visibility = View.VISIBLE
                    prroducct5.visibility = View.VISIBLE
                    bagee5.visibility = View.VISIBLE
                    bag5.visibility = View.VISIBLE
                    weightee5.visibility = View.VISIBLE
                    weight5.visibility = View.VISIBLE
                    pnumber5.visibility = View.VISIBLE
                    addbtn5.visibility = View.VISIBLE
                    pnumber5.setText(model.pnumber5)
                    bag5.setText(model.bag5)
                    weight5.setText(model.weight5)
                }
                productName6.setText(model.productName6)
                if (productName6.length() > 0) {
                    productName6.visibility = View.VISIBLE
                    prroducct6.visibility = View.VISIBLE
                    bagee6.visibility = View.VISIBLE
                    bag6.visibility = View.VISIBLE
                    weightee6.visibility = View.VISIBLE
                    weight6.visibility = View.VISIBLE
                    pnumber6.visibility = View.VISIBLE
                    addbtn6.visibility = View.VISIBLE
                    pnumber6.setText(model.pnumber6)
                    bag6.setText(model.bag6)
                    weight6.setText(model.weight6)
                }
                productName7.setText(model.productName7)
                if (productName7.length() > 0) {
                    productName7.visibility = View.VISIBLE
                    prroducct7.visibility = View.VISIBLE
                    bagee7.visibility = View.VISIBLE
                    bag7.visibility = View.VISIBLE
                    weightee7.visibility = View.VISIBLE
                    weight7.visibility = View.VISIBLE
                    pnumber7.visibility = View.VISIBLE
                    addbtn7.visibility = View.VISIBLE
                    pnumber7.setText(model.pnumber7)
                    bag7.setText(model.bag7)
                    weight7.setText(model.weight7)
                }
                productName8.setText(model.productName8)
                if (productName8.length() > 0) {
                    productName8.visibility = View.VISIBLE
                    prroducct8.visibility = View.VISIBLE
                    bagee8.visibility = View.VISIBLE
                    bag8.visibility = View.VISIBLE
                    weightee8.visibility = View.VISIBLE
                    weight8.visibility = View.VISIBLE
                    pnumber8.visibility = View.VISIBLE
                    addbtn8.visibility = View.VISIBLE
                    pnumber8.setText(model.pnumber8)
                    bag8.setText(model.bag8)
                    weight8.setText(model.weight8)
                }
                productName9.setText(model.productName9)
                if (productName9.length() > 0) {
                    productName9.visibility = View.VISIBLE
                    prroducct9.visibility = View.VISIBLE
                    bagee9.visibility = View.VISIBLE
                    bag9.visibility = View.VISIBLE
                    weightee9.visibility = View.VISIBLE
                    weight9.visibility = View.VISIBLE
                    pnumber9.visibility = View.VISIBLE
                    addbtn9.visibility = View.VISIBLE
                    pnumber9.setText(model.pnumber9)
                    bag9.setText(model.bag9)
                    weight9.setText(model.weight9)
                }
                productName10.setText(model.productName10)
                if (productName10.length() > 0) {
                    productName10.visibility = View.VISIBLE
                    prroducct10.visibility = View.VISIBLE
                    bagee10.visibility = View.VISIBLE
                    bag10.visibility = View.VISIBLE
                    weightee10.visibility = View.VISIBLE
                    weight10.visibility = View.VISIBLE
                    pnumber10.visibility = View.VISIBLE
                    addbtn10.visibility = View.VISIBLE
                    pnumber10.setText(model.pnumber10)
                    bag10.setText(model.bag10)
                    weight10.setText(model.weight10)
                }
                addbtn.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if (productName.length() == 0) {
                            Toast.makeText(context, "Product Empty", Toast.LENGTH_SHORT).show()
                        } else {
                            productName2.visibility = View.VISIBLE
                            prroducct2.visibility = View.VISIBLE
                            bagee2.visibility = View.VISIBLE
                            bag2.visibility = View.VISIBLE
                            weightee2.visibility = View.VISIBLE
                            weight2.visibility = View.VISIBLE
                            pnumber2.visibility = View.VISIBLE
                            addbtn2.visibility = View.VISIBLE
                        }
                    }
                })
                addbtn2.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if (productName2.length() == 0) {
                            Toast.makeText(context, "Product Empty", Toast.LENGTH_SHORT).show()
                        } else {
                            productName3.visibility = View.VISIBLE
                            prroducct3.visibility = View.VISIBLE
                            bagee3.visibility = View.VISIBLE
                            bag3.visibility = View.VISIBLE
                            weightee3.visibility = View.VISIBLE
                            weight3.visibility = View.VISIBLE
                            pnumber3.visibility = View.VISIBLE
                            addbtn3.visibility = View.VISIBLE
                        }
                    }
                })
                addbtn3.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if (productName3.length() == 0) {
                            Toast.makeText(context, "Product Empty", Toast.LENGTH_SHORT).show()
                        } else {
                            productName4.visibility = View.VISIBLE
                            prroducct4.visibility = View.VISIBLE
                            bagee4.visibility = View.VISIBLE
                            bag4.visibility = View.VISIBLE
                            weightee4.visibility = View.VISIBLE
                            weight4.visibility = View.VISIBLE
                            pnumber4.visibility = View.VISIBLE
                            addbtn4.visibility = View.VISIBLE
                        }
                    }
                })
                addbtn4.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if (productName4.length() == 0) {
                            Toast.makeText(context, "Product Empty", Toast.LENGTH_SHORT).show()
                        } else {
                            productName5.visibility = View.VISIBLE
                            prroducct5.visibility = View.VISIBLE
                            bagee5.visibility = View.VISIBLE
                            bag5.visibility = View.VISIBLE
                            weightee5.visibility = View.VISIBLE
                            weight5.visibility = View.VISIBLE
                            pnumber5.visibility = View.VISIBLE
                            addbtn5.visibility = View.VISIBLE
                        }
                    }
                })
                addbtn5.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if (productName5.length() == 0) {
                            Toast.makeText(context, "Product Empty", Toast.LENGTH_SHORT).show()
                        } else {
                            productName6.visibility = View.VISIBLE
                            prroducct6.visibility = View.VISIBLE
                            bagee6.visibility = View.VISIBLE
                            bag6.visibility = View.VISIBLE
                            weightee6.visibility = View.VISIBLE
                            weight6.visibility = View.VISIBLE
                            pnumber6.visibility = View.VISIBLE
                            addbtn6.visibility = View.VISIBLE
                        }
                    }
                })
                addbtn6.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if (productName6.length() == 0) {
                            Toast.makeText(context, "Product Empty", Toast.LENGTH_SHORT).show()
                        } else {
                            productName7.visibility = View.VISIBLE
                            prroducct7.visibility = View.VISIBLE
                            bagee7.visibility = View.VISIBLE
                            bag7.visibility = View.VISIBLE
                            weightee7.visibility = View.VISIBLE
                            weight7.visibility = View.VISIBLE
                            pnumber7.visibility = View.VISIBLE
                            addbtn7.visibility = View.VISIBLE
                        }
                    }
                })
                addbtn7.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if (productName7.length() == 0) {
                            Toast.makeText(context, "Product Empty", Toast.LENGTH_SHORT).show()
                        } else {
                            productName8.visibility = View.VISIBLE
                            prroducct8.visibility = View.VISIBLE
                            bagee8.visibility = View.VISIBLE
                            bag8.visibility = View.VISIBLE
                            weightee8.visibility = View.VISIBLE
                            weight8.visibility = View.VISIBLE
                            pnumber8.visibility = View.VISIBLE
                            addbtn8.visibility = View.VISIBLE
                        }
                    }
                })
                addbtn8.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if (productName8.length() == 0) {
                            Toast.makeText(context, "Product Empty", Toast.LENGTH_SHORT).show()
                        } else {
                            productName9.visibility = View.VISIBLE
                            prroducct9.visibility = View.VISIBLE
                            bagee9.visibility = View.VISIBLE
                            bag9.visibility = View.VISIBLE
                            weightee9.visibility = View.VISIBLE
                            weight9.visibility = View.VISIBLE
                            pnumber9.visibility = View.VISIBLE
                            addbtn9.visibility = View.VISIBLE
                        }
                    }
                })
                addbtn9.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if (productName9.length() == 0) {
                            Toast.makeText(context, "Product Empty", Toast.LENGTH_SHORT).show()
                        } else {
                            productName10.visibility = View.VISIBLE
                            prroducct10.visibility = View.VISIBLE
                            bagee10.visibility = View.VISIBLE
                            bag10.visibility = View.VISIBLE
                            weightee10.visibility = View.VISIBLE
                            weight10.visibility = View.VISIBLE
                            pnumber10.visibility = View.VISIBLE
                            addbtn10.visibility = View.VISIBLE
                        }
                    }
                })
                //save 28 5 2020 18;17
                val update = holderView.findViewById<Button>(R.id.update)
                update.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {
                        if (entrynumber.length() == 0) {
                            Toast.makeText(context, "Internet not Available", Toast.LENGTH_SHORT)
                                .show()
                        } else if (customerName.length() == 0) {
                            Toast.makeText(context, "Enter Name", Toast.LENGTH_SHORT).show()
                        } else if (mobile.length() > 25 || mobile.length() <= 9) {
                            Toast.makeText(
                                context,
                                "Enter Mobile No. correctly",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else if (productName.length() == 0) {
                            Toast.makeText(context, "Enter Product Name", Toast.LENGTH_SHORT).show()
                        } //else if (delAddress.length() == 0) {
                        else {

                            val kk = Kotclass()
                            kk.kooot(
                                "Edited Order No. - " + model.entry,
                                model.customerName.toString()
                            )

                            if (weight.text.toString().trim { it <= ' ' }.length == 0) {
                                weight.setText("0")
                            }
                            if (bag.text.toString().trim { it <= ' ' }.length == 0) {
                                bag.setText("0")
                            }
                            if (weight2.text.toString().trim { it <= ' ' }.length == 0) {
                                weight2.setText("0")
                            }
                            if (bag2.text.toString().trim { it <= ' ' }.length == 0) {
                                bag2.setText("0")
                            }
                            if (weight3.text.toString().trim { it <= ' ' }.length == 0) {
                                weight3.setText("0")
                            }
                            if (bag3.text.toString().trim { it <= ' ' }.length == 0) {
                                bag3.setText("0")
                            }
                            if (weight4.text.toString().trim { it <= ' ' }.length == 0) {
                                weight4.setText("0")
                            }
                            if (bag4.text.toString().trim { it <= ' ' }.length == 0) {
                                bag4.setText("0")
                            }
                            if (weight5.text.toString().trim { it <= ' ' }.length == 0) {
                                weight5.setText("0")
                            }
                            if (bag5.text.toString().trim { it <= ' ' }.length == 0) {
                                bag5.setText("0")
                            }
                            if (weight6.text.toString().trim { it <= ' ' }.length == 0) {
                                weight6.setText("0")
                            }
                            if (bag6.text.toString().trim { it <= ' ' }.length == 0) {
                                bag6.setText("0")
                            }
                            if (weight7.text.toString().trim { it <= ' ' }.length == 0) {
                                weight7.setText("0")
                            }
                            if (bag7.text.toString().trim { it <= ' ' }.length == 0) {
                                bag7.setText("0")
                            }
                            if (weight8.text.toString().trim { it <= ' ' }.length == 0) {
                                weight8.setText("0")
                            }
                            if (bag8.text.toString().trim { it <= ' ' }.length == 0) {
                                bag8.setText("0")
                            }
                            if (weight9.text.toString().trim { it <= ' ' }.length == 0) {
                                weight9.setText("0")
                            }
                            if (bag9.text.toString().trim { it <= ' ' }.length == 0) {
                                bag9.setText("0")
                            }
                            if (weight10.text.toString().trim { it <= ' ' }.length == 0) {
                                weight10.setText("0")
                            }
                            if (bag10.text.toString().trim { it <= ' ' }.length == 0) {
                                bag10.setText("0")
                            }
                            val totalW = (weight.text.toString().trim { it <= ' ' }
                                .toDouble() + weight3.text.toString().trim { it <= ' ' }
                                .toDouble() + weight2.text.toString().trim { it <= ' ' }
                                .toDouble() + weight4.text.toString().trim { it <= ' ' }
                                .toDouble() + weight5.text.toString().trim { it <= ' ' }
                                .toDouble() + weight6.text.toString().trim { it <= ' ' }
                                .toDouble() + weight7.text.toString().trim { it <= ' ' }
                                .toDouble() + weight8.text.toString().trim { it <= ' ' }
                                .toDouble() + weight9.text.toString().trim { it <= ' ' }
                                .toDouble() + weight10.text.toString().trim { it <= ' ' }
                                .toDouble())
                                .toString()
                            val totalB = (bag.text.toString().trim { it <= ' ' }
                                .toDouble() + bag2.text.toString().trim { it <= ' ' }
                                .toDouble() + bag3.text.toString().trim { it <= ' ' }
                                .toDouble() + bag4.text.toString().trim { it <= ' ' }
                                .toDouble() + bag5.text.toString().trim { it <= ' ' }
                                .toDouble() + bag6.text.toString().trim { it <= ' ' }
                                .toDouble() + bag7.text.toString().trim { it <= ' ' }
                                .toDouble() + bag8.text.toString().trim { it <= ' ' }
                                .toDouble() + bag9.text.toString().trim { it <= ' ' }
                                .toDouble() + bag10.text.toString().trim { it <= ' ' }.toDouble())
                                .toString()
                            if (model.delAddress != delAddress.text.toString()) {
                                val mapDelAddress: MutableMap<String, Any> = HashMap()
                                mapDelAddress["delAddress"] = delAddress.text.toString()
                                FirebaseDatabase.getInstance().reference.child("DeliveryAddressList")
                                    .child((getRef(position).key)!!)
                                    .updateChildren(mapDelAddress)
                            }
                            val map: MutableMap<String, Any> = HashMap()
                            map["customerName"] = customerName.text.toString()
                            //   map.put("customerAddress",customerAddress.getText().toString());
                            map["productName"] = productName.text.toString()
                            map["mobileNo"] = mobile.text.toString()
                            map["weight"] = weight.text.toString()
                            map["bag"] = bag.text.toString()
                            map["delAddress"] = delAddress.text.toString()
                            map["pono"] = pono.text.toString()
                            map["deldate"] = deldate.text.toString()
                            map["pnumber"] = pnumber.text.toString()
                            map["approxFreight"] = approxFreight.text.toString()

                            map["notes"] = notes.text.toString()

                            map["totalWeight"] = totalW
                            map["remainWeight"] = totalW
                            map["totalBag"] = totalB
                            if (productName2.text.toString().trim { it <= ' ' }.length > 0) {
                                map["productName2"] =
                                    productName2.text.toString().trim { it <= ' ' }
                                map["weight2"] = weight2.text.toString().trim { it <= ' ' }
                                map["bag2"] = bag2.text.toString().trim { it <= ' ' }
                                map["pnumber2"] = pnumber2.text.toString()

                                //  HashMap<String, Object> mapProduct2 = new HashMap<>();
                                //   mapProduct2.put("productName", productName2.getText().toString().trim());
                                //   mapProduct2.put("pnumber", pnumber2.getText().toString().trim());

                                //FirebaseDatabase.getInstance().getReference().child("ProductsList").child(entrynumber.getText().toString() + "-2").updateChildren(mapProduct2);
                            }
                            if (productName3.text.toString().trim { it <= ' ' }.length > 0) {
                                map["productName3"] =
                                    productName3.text.toString().trim { it <= ' ' }
                                map["weight3"] = weight3.text.toString().trim { it <= ' ' }
                                map["bag3"] = bag3.text.toString().trim { it <= ' ' }
                                map["pnumber3"] = pnumber3.text.toString()

                                //  HashMap<String, Object> mapProduct3 = new HashMap<>();
                                //  mapProduct3.put("productName", productName3.getText().toString().trim());
                                //  mapProduct3.put("pnumber", pnumber3.getText().toString().trim());

                                //FirebaseDatabase.getInstance().getReference().child("ProductsList").child(entrynumber.getText().toString() + "-3").updateChildren(mapProduct3);
                            }
                            if (productName4.text.toString().trim { it <= ' ' }.length > 0) {
                                map["productName4"] =
                                    productName4.text.toString().trim { it <= ' ' }
                                map["weight4"] = weight4.text.toString().trim { it <= ' ' }
                                map["bag4"] = bag4.text.toString().trim { it <= ' ' }
                                map["pnumber4"] = pnumber4.text.toString()

                                // HashMap<String, Object> mapProduct4 = new HashMap<>();
                                // mapProduct4.put("productName", productName4.getText().toString().trim());
                                // mapProduct4.put("pnumber", pnumber4.getText().toString().trim());

                                //FirebaseDatabase.getInstance().getReference().child("ProductsList").child(entrynumber.getText().toString() + "-4").updateChildren(mapProduct4);
                            }
                            if (productName5.text.toString().trim { it <= ' ' }.length > 0) {
                                map["productName5"] =
                                    productName5.text.toString().trim { it <= ' ' }
                                map["weight5"] = weight5.text.toString().trim { it <= ' ' }
                                map["bag5"] = bag5.text.toString().trim { it <= ' ' }
                                map["pnumber5"] = pnumber5.text.toString()

                                // HashMap<String, Object> mapProduct5 = new HashMap<>();
                                //  mapProduct5.put("productName", productName5.getText().toString().trim());
                                //  mapProduct5.put("pnumber", pnumber5.getText().toString().trim());

                                //FirebaseDatabase.getInstance().getReference().child("ProductsList").child(entrynumber.getText().toString() + "-5").updateChildren(mapProduct5);
                            }
                            if (productName6.text.toString().trim { it <= ' ' }.length > 0) {
                                map["productName6"] =
                                    productName6.text.toString().trim { it <= ' ' }
                                map["weight6"] = weight6.text.toString().trim { it <= ' ' }
                                map["bag6"] = bag6.text.toString().trim { it <= ' ' }
                                map["pnumber6"] = pnumber6.text.toString()

                                //  HashMap<String, Object> mapProduct6 = new HashMap<>();
                                //  mapProduct6.put("productName", productName6.getText().toString().trim());
                                //  mapProduct6.put("pnumber", pnumber6.getText().toString().trim());

                                //FirebaseDatabase.getInstance().getReference().child("ProductsList").child(entrynumber.getText().toString() + "-6").updateChildren(mapProduct6);
                            }
                            if (productName7.text.toString().trim { it <= ' ' }.length > 0) {
                                map["productName7"] =
                                    productName7.text.toString().trim { it <= ' ' }
                                map["weight7"] = weight7.text.toString().trim { it <= ' ' }
                                map["bag7"] = bag7.text.toString().trim { it <= ' ' }
                                map["pnumber7"] = pnumber7.text.toString()

                                //  HashMap<String, Object> mapProduct7 = new HashMap<>();
                                //  mapProduct7.put("productName", productName7.getText().toString().trim());
                                //   mapProduct7.put("pnumber", pnumber7.getText().toString().trim());

                                //FirebaseDatabase.getInstance().getReference().child("ProductsList").child(entrynumber.getText().toString() + "-7").updateChildren(mapProduct7);
                            }
                            if (productName8.text.toString().trim { it <= ' ' }.length > 0) {
                                map["productName8"] =
                                    productName8.text.toString().trim { it <= ' ' }
                                map["weight8"] = weight8.text.toString().trim { it <= ' ' }
                                map["bag8"] = bag8.text.toString().trim { it <= ' ' }
                                map["pnumber8"] = pnumber8.text.toString()

                                //HashMap<String, Object> mapProduct8 = new HashMap<>();
                                // mapProduct8.put("productName", productName8.getText().toString().trim());
                                //  mapProduct8.put("pnumber", pnumber8.getText().toString().trim());

                                //FirebaseDatabase.getInstance().getReference().child("ProductsList").child(entrynumber.getText().toString() + "-8").updateChildren(mapProduct8);
                            }
                            if (productName9.text.toString().trim { it <= ' ' }.length > 0) {
                                map["productName9"] =
                                    productName9.text.toString().trim { it <= ' ' }
                                map["weight9"] = weight9.text.toString().trim { it <= ' ' }
                                map["bag9"] = bag9.text.toString().trim { it <= ' ' }
                                map["pnumber9"] = pnumber9.text.toString()
                                //29-5-2020...2.26...
                                // HashMap<String, Object> mapProduct9 = new HashMap<>();
                                //  mapProduct9.put("productName", productName9.getText().toString().trim());
                                //   mapProduct9.put("pnumber", pnumber9.getText().toString().trim());

                                //FirebaseDatabase.getInstance().getReference().child("ProductsList").child(entrynumber.getText().toString() + "-9").updateChildren(mapProduct9);
                            }
                            if (productName10.text.toString().trim { it <= ' ' }.length > 0) {
                                map["productName10"] =
                                    productName10.text.toString().trim { it <= ' ' }
                                map["weight10"] = weight10.text.toString().trim { it <= ' ' }
                                map["bag10"] = bag10.text.toString().trim { it <= ' ' }
                                map["pnumber10"] = pnumber10.text.toString()

                                //  HashMap<String, Object> mapProduct10 = new HashMap<>();
                                //  mapProduct10.put("productName", productName10.getText().toString().trim());
                                //  mapProduct10.put("pnumber", pnumber10.getText().toString().trim());

                                //FirebaseDatabase.getInstance().getReference().child("ProductsList").child(entrynumber.getText().toString() + "-10").updateChildren(mapProduct10);
                            }
                            FirebaseDatabase.getInstance().reference.child("Post")
                                .child((getRef(position).key)!!)
                                .updateChildren(map)
                                .addOnCompleteListener {
                                    dialog.dismiss()
                                }
                        }
                    }
                })
                dialog.show()
            }
        })

        holder.dispatch.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val drivermobiledialog = DialogPlus.newDialog(context)
                    .setGravity(Gravity.CENTER)
                    .setMargin(50, 0, 50, 0)
                    .setContentHolder(ViewHolder(R.layout.driverdetail))
                    .setExpanded(false) // This will enable the expand feature, (similar to android L share dialog)
                    .create()
                val hdriverView: View = drivermobiledialog.holderView as LinearLayout
                val drivermobile = hdriverView.findViewById<EditText>(R.id.drivermobile)
                val transportername = hdriverView.findViewById<EditText>(R.id.transportername)
                val vehicleno = hdriverView.findViewById<EditText>(R.id.vehicleno)
                val actualFreight = hdriverView.findViewById<EditText>(R.id.actualFreight)
                val advance = hdriverView.findViewById<EditText>(R.id.advance)

                val rremainweight = hdriverView.findViewById<TextView>(R.id.rremainweight)
                rremainweight.text = model.remainWeight.toString()

                val dispatchweight = hdriverView.findViewById<EditText>(R.id.dispatchweight)
                dispatchweight.text =
                    Editable.Factory.getInstance().newEditable(model.remainWeight.toString())

                val dispatchentry = hdriverView.findViewById<Button>(R.id.dispatchentry)
                dispatchentry.isEnabled = true
                dispatchentry.setOnClickListener(object : View.OnClickListener {
                    override fun onClick(v: View) {

//                        dispatchentry.isEnabled = false
//                        dispatchentry.text = "Loading..."


                        if (transportername.length() == 0) {
                            Toast.makeText(context, "Enter Transporter Name", Toast.LENGTH_SHORT)
                                .show()
                        } else if (drivermobile.length() > 25 || drivermobile.length() <= 9) {
                            Toast.makeText(
                                context,
                                "Enter Driver Mobile correctly",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else if (vehicleno.length() == 0) {
                            Toast.makeText(context, "Enter Vehicle number", Toast.LENGTH_SHORT)
                                .show()
                        } else if (actualFreight.length() == 0) {
                            Toast.makeText(context, "Enter Actual Freight", Toast.LENGTH_SHORT)
                                .show()
                        } else if (advance.length() == 0) {
                            Toast.makeText(context, "Enter Advance", Toast.LENGTH_SHORT).show()
                        } else if (dispatchweight.text.toString()
                                .toDouble() > model.remainWeight.toString()
                                .toDouble() || dispatchweight.text.toString()
                                .toDouble() < 0.0 || dispatchweight.length() == 0 || dispatchweight.text.toString() == "0" || dispatchweight.text.toString() == "0.0"
                        ) {
                            Toast.makeText(context, "Enter Dispatch Weight", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            val kk = Kotclass()
                            kk.kooot(
                                "Dispatched Order No. - " + model.entry,
                                model.customerName.toString()
                            )
                            val date_nn =
                                SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(Date())

//                            val disdialog = DialogPlus.newDialog(context)
//                                .setGravity(Gravity.CENTER)
//                                .setMargin(50, 0, 50, 0)
//                                .setContentHolder(ViewHolder(R.layout.content))
//                                .setExpanded(false) // This will enable the expand feature, (similar to android L share dialog)
//                                .create()
//                            val holderView: View = disdialog.holderView as LinearLayout
//                            val customerName = holderView.findViewById<EditText>(R.id.customerName)
//                            // final EditText customerAddress = holderView.findViewById(R.id.customerAddress);
//                            val productName = holderView.findViewById<EditText>(R.id.productName)
//                            val mobile = holderView.findViewById<EditText>(R.id.mobileNo)
//                            val bag = holderView.findViewById<EditText>(R.id.bag)
//                            val weight = holderView.findViewById<EditText>(R.id.weight)
//                            val delAddress = holderView.findViewById<EditText>(R.id.delAddress)
//                            val date = holderView.findViewById<TextView>(R.id.date)
//                            val entrynumber = holderView.findViewById<TextView>(R.id.entrynumber)
//                            val pono = holderView.findViewById<EditText>(R.id.pono)
//                            val deldate = holderView.findViewById<TextView>(R.id.deldate)
//                            val totalB = holderView.findViewById<TextView>(R.id.totalB)
//                            val totalW = holderView.findViewById<TextView>(R.id.totalW)
//                            val pnumber = holderView.findViewById<EditText>(R.id.pnumber)
//                            val pnumber2 = holderView.findViewById<EditText>(R.id.pnumber2)
//                            val pnumber3 = holderView.findViewById<EditText>(R.id.pnumber3)
//                            val pnumber4 = holderView.findViewById<EditText>(R.id.pnumber4)
//                            val pnumber5 = holderView.findViewById<EditText>(R.id.pnumber5)
//                            val pnumber6 = holderView.findViewById<EditText>(R.id.pnumber6)
//                            val pnumber7 = holderView.findViewById<EditText>(R.id.pnumber7)
//                            val pnumber8 = holderView.findViewById<EditText>(R.id.pnumber8)
//                            val pnumber9 = holderView.findViewById<EditText>(R.id.pnumber9)
//                            val pnumber10 = holderView.findViewById<EditText>(R.id.pnumber10)
//                            val productName2 = holderView.findViewById<AutoCompleteTextView>(R.id.productName2)
//                            val productName3 = holderView.findViewById<AutoCompleteTextView>(R.id.productName3)
//                            val productName4 = holderView.findViewById<AutoCompleteTextView>(R.id.productName4)
//                            val productName5 = holderView.findViewById<AutoCompleteTextView>(R.id.productName5)
//                            val productName6 = holderView.findViewById<AutoCompleteTextView>(R.id.productName6)
//                            val productName7 = holderView.findViewById<AutoCompleteTextView>(R.id.productName7)
//                            val productName8 = holderView.findViewById<AutoCompleteTextView>(R.id.productName8)
//                            val productName9 = holderView.findViewById<AutoCompleteTextView>(R.id.productName9)
//                            val productName10 = holderView.findViewById<AutoCompleteTextView>(R.id.productName10)
//                            val bag2 = holderView.findViewById<EditText>(R.id.bag2)
//                            val bag3 = holderView.findViewById<EditText>(R.id.bag3)
//                            val bag4 = holderView.findViewById<EditText>(R.id.bag4)
//                            val bag5 = holderView.findViewById<EditText>(R.id.bag5)
//                            val bag6 = holderView.findViewById<EditText>(R.id.bag6)
//                            val bag7 = holderView.findViewById<EditText>(R.id.bag7)
//                            val bag8 = holderView.findViewById<EditText>(R.id.bag8)
//                            val bag9 = holderView.findViewById<EditText>(R.id.bag9)
//                            val bag10 = holderView.findViewById<EditText>(R.id.bag10)
//                            val weight2 = holderView.findViewById<EditText>(R.id.weight2)
//                            val weight3 = holderView.findViewById<EditText>(R.id.weight3)
//                            val weight4 = holderView.findViewById<EditText>(R.id.weight4)
//                            val weight5 = holderView.findViewById<EditText>(R.id.weight5)
//                            val weight6 = holderView.findViewById<EditText>(R.id.weight6)
//                            val weight7 = holderView.findViewById<EditText>(R.id.weight7)
//                            val weight8 = holderView.findViewById<EditText>(R.id.weight8)
//                            val weight9 = holderView.findViewById<EditText>(R.id.weight9)
//                            val weight10 = holderView.findViewById<EditText>(R.id.weight10)
//                            val date_nn = SimpleDateFormat("dd-MMM-yyyy", Locale.getDefault()).format(Date())
//                            customerName.setText(model.getCustomerName())
//                            // customerAddress.setText(model.getCustomerAddress());
//                            delAddress.setText(model.getDelAddress())
//                            mobile.setText(model.getMobileNo())
//                            productName.setText(model.getProductName())
//                            weight.setText(model.getWeight())
//                            bag.setText(model.getBag())
//                            date.text = model.getDate()
//                            entrynumber.text = model.getEntry()
//                            pono.setText(model.getPono())
//                            deldate.text = model.getDeldate()
//                            pnumber.setText(model.getPnumber())
//                            totalB.text = model.getTotalBag()
//                            totalW.text = model.getTotalWeight()
//                            productName2.setText(model.getProductName2())
//                            if (productName2.length() > 0) {
//                                bag2.setText(model.getBag2())
//                                weight2.setText(model.getWeight2())
//                                pnumber2.setText(model.getPnumber2())
//                            }
//                            productName3.setText(model.getProductName3())
//                            if (productName3.length() > 0) {
//                                bag3.setText(model.getBag3())
//                                weight3.setText(model.getWeight3())
//                                pnumber3.setText(model.getPnumber3())
//                            }
//                            productName4.setText(model.getProductName4())
//                            if (productName4.length() > 0) {
//                                bag4.setText(model.getBag4())
//                                weight4.setText(model.getWeight4())
//                                pnumber4.setText(model.getPnumber4())
//                            }
//                            productName5.setText(model.getProductName5())
//                            if (productName5.length() > 0) {
//                                bag5.setText(model.getBag5())
//                                weight5.setText(model.getWeight5())
//                                pnumber5.setText(model.getPnumber5())
//                            }
//                            productName6.setText(model.getProductName6())
//                            if (productName6.length() > 0) {
//                                bag6.setText(model.getBag6())
//                                weight6.setText(model.getWeight6())
//                                pnumber6.setText(model.getPnumber6())
//                            }
//                            productName7.setText(model.getProductName7())
//                            if (productName7.length() > 0) {
//                                bag7.setText(model.getBag7())
//                                weight7.setText(model.getWeight7())
//                                pnumber7.setText(model.getPnumber7())
//                            }
//                            productName8.setText(model.getProductName8())
//                            if (productName8.length() > 0) {
//                                bag8.setText(model.getBag8())
//                                weight8.setText(model.getWeight8())
//                                pnumber8.setText(model.getPnumber8())
//                            }
//                            productName9.setText(model.getProductName9())
//                            if (productName9.length() > 0) {
//                                bag9.setText(model.getBag9())
//                                weight9.setText(model.getWeight9())
//                                pnumber9.setText(model.getPnumber9())
//                            }
//                            productName10.setText(model.getProductName10())
//                            if (productName10.length() > 0) {
//                                bag10.setText(model.getBag10())
//                                weight10.setText(model.getWeight10())
//                                pnumber10.setText(model.getPnumber10())
//                            }


                            //    println("thisismaddd"+dispatchweight.text.toString())

                            val v1: Double? = dispatchweight.text.toString().toDoubleOrNull()
                            val v2: Double? = model.remainWeight.toString().toDoubleOrNull()
                            val tw: Double? = model.totalWeight.toString().toDoubleOrNull()

                            var v3: Double = v2!! - v1!!
                            //     println("thisismadd"+v1+v2+v3)

                            if (v3.equals(0.0)) {

                                //       println("thisismadd"+"success")
                                val dismap: MutableMap<String, Any> = HashMap()
                                dismap["customerName"] = model.customerName.toString()
                                //    dismap.put("customerAddress",customerAddress.getText().toString());
                                dismap["productName"] = model.productName.toString()
                                dismap["mobileNo"] = model.mobileNo.toString()
                                dismap["weight"] = model.weight.toString()
                                dismap["bag"] = model.bag.toString()
                                dismap["delAddress"] = model.delAddress.toString()
                                dismap["date"] = model.date.toString()
                                dismap["entry"] = model.entry.toString()
                                dismap["drivermobile"] =
                                    drivermobile.text.toString().trim { it <= ' ' }
                                dismap["pono"] = model.pono.toString()
                                dismap["deldate"] = model.deldate.toString()
                                dismap["pnumber"] = model.pnumber.toString()
                                dismap["dispatchdate"] = date_nn
                                dismap["totalWeight"] = model.totalWeight.toString()
                                dismap["dispatchWeight"] = v1.toString()
                                dismap["remainWeight"] = v2.toString()
                                dismap["dateid"] = model.dateid.toString()

                                dismap["notes"] = model.notes.toString()



                                dismap["totalBag"] = model.totalBag.toString()
                                //dismap.put("totalFreight",totalFreight);
                                dismap["transportername"] =
                                    transportername.text.toString().trim { it <= ' ' }
                                dismap["actualFreight"] =
                                    actualFreight.text.toString().trim { it <= ' ' }
                                dismap["advance"] = advance.text.toString().trim { it <= ' ' }
                                dismap["vehicleno"] = vehicleno.text.toString().trim { it <= ' ' }
                                if (model.productName2.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName2"] =
                                        model.productName2.toString().trim { it <= ' ' }
                                    dismap["weight2"] = model.weight2.toString().trim { it <= ' ' }
                                    dismap["bag2"] = model.bag2.toString().trim { it <= ' ' }
                                    dismap["pnumber2"] = model.pnumber2.toString()
                                }
                                if (model.productName3.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName3"] =
                                        model.productName3.toString().trim { it <= ' ' }
                                    dismap["weight3"] = model.weight3.toString().trim { it <= ' ' }
                                    dismap["bag3"] = model.bag3.toString().trim { it <= ' ' }
                                    dismap["pnumber3"] = model.pnumber3.toString()
                                }
                                if (model.productName4.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName4"] =
                                        model.productName4.toString().trim { it <= ' ' }
                                    dismap["weight4"] = model.weight4.toString().trim { it <= ' ' }
                                    dismap["bag4"] = model.bag4.toString().trim { it <= ' ' }
                                    dismap["pnumber4"] = model.pnumber4.toString()
                                }
                                if (model.productName5.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName5"] =
                                        model.productName5.toString().trim { it <= ' ' }
                                    dismap["weight5"] = model.weight5.toString().trim { it <= ' ' }
                                    dismap["bag5"] = model.bag5.toString().trim { it <= ' ' }
                                    dismap["pnumber5"] = model.pnumber5.toString()
                                }
                                if (model.productName6.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName6"] =
                                        model.productName6.toString().trim { it <= ' ' }
                                    dismap["weight6"] = model.weight6.toString().trim { it <= ' ' }
                                    dismap["bag6"] = model.bag6.toString().trim { it <= ' ' }
                                    dismap["pnumber6"] = model.pnumber6.toString()
                                }
                                if (model.productName7.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName7"] =
                                        model.productName7.toString().trim { it <= ' ' }
                                    dismap["weight7"] = model.weight7.toString().trim { it <= ' ' }
                                    dismap["bag7"] = model.bag7.toString().trim { it <= ' ' }
                                    dismap["pnumber7"] = model.pnumber7.toString()
                                }
                                if (model.productName8.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName8"] =
                                        model.productName8.toString().trim { it <= ' ' }
                                    dismap["weight8"] = model.weight8.toString().trim { it <= ' ' }
                                    dismap["bag8"] = model.bag8.toString().trim { it <= ' ' }
                                    dismap["pnumber8"] = model.pnumber8.toString()
                                }
                                if (model.productName9.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName9"] =
                                        model.productName9.toString().trim { it <= ' ' }
                                    dismap["weight9"] = model.weight9.toString().trim { it <= ' ' }
                                    dismap["bag9"] = model.bag9.toString().trim { it <= ' ' }
                                    dismap["pnumber9"] = model.pnumber9.toString()
                                }
                                if (model.productName10.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName10"] =
                                        model.productName10.toString().trim { it <= ' ' }
                                    dismap["weight10"] =
                                        model.weight10.toString().trim { it <= ' ' }
                                    dismap["bag10"] = model.bag10.toString().trim { it <= ' ' }
                                    dismap["pnumber10"] = model.pnumber10.toString()
                                }
                                val mudateedd = SimpleDateFormat(
                                    "yyyyMMdd_HHmmssSS",
                                    Locale.getDefault()
                                ).format(Date())
                                FirebaseDatabase.getInstance().reference.child("DispatchList")
                                    .child(mudateedd.toString())
                                    .setValue(dismap)
                                    .addOnCompleteListener {

                                        //  disdialog.dismiss()
                                        drivermobiledialog.dismiss()
                                    }

                                FirebaseDatabase.getInstance().reference.child("Post")
                                    .child((getRef(position).key)!!)
                                    .removeValue().addOnCompleteListener {
                                        val intt = Intent(context, PendingList::class.java)
                                        context.startActivity(intt)
                                    }

                                    .addOnFailureListener(object : OnFailureListener {
                                        override fun onFailure(e: Exception) {
                                            Log.i("errordeletedialogbog", "onFailure :$e")
                                        }
                                    })
                                Toast.makeText(context, "Dispatched", Toast.LENGTH_SHORT).show()

                            } else {
                                //      println("thisismadd"+"failed")

                                var rw: Double = v2!! - v1!!
                                var dw: Double = tw!! - rw!!
                                val remainW: MutableMap<String, Any> = HashMap()
                                remainW["remainWeight"] = rw.toString()
                                remainW["dispatchWeight"] = dw.toString()
                                FirebaseDatabase.getInstance().reference.child("Post")
                                    .child((getRef(position).key)!!)
                                    .updateChildren(remainW)


                                val dismap: MutableMap<String, Any> = HashMap()
                                dismap["customerName"] = model.customerName.toString()
                                //    dismap.put("customerAddress",customerAddress.getText().toString());
                                dismap["productName"] = model.productName.toString()
                                dismap["mobileNo"] = model.mobileNo.toString()
                                dismap["weight"] = model.weight.toString()
                                dismap["bag"] = model.bag.toString()
                                dismap["delAddress"] = model.delAddress.toString()
                                dismap["date"] = model.date.toString()
                                dismap["entry"] = model.entry.toString()
                                dismap["drivermobile"] =
                                    drivermobile.text.toString().trim { it <= ' ' }
                                dismap["pono"] = model.pono.toString()
                                dismap["deldate"] = model.deldate.toString()
                                dismap["pnumber"] = model.pnumber.toString()
                                dismap["dispatchdate"] = date_nn
                                dismap["dateid"] = model.dateid.toString()
                                dismap["totalWeight"] = model.totalWeight.toString()
                                //dismap["dateid"] = model.dateid.toString()
                                dismap["dispatchWeight"] = v1.toString()
                                dismap["remainWeight"] = rw.toString()
                                dismap["totalBag"] = model.totalBag.toString()

                                dismap["notes"] = model.notes.toString()


                                //dismap.put("totalFreight",totalFreight);
                                dismap["transportername"] =
                                    transportername.text.toString().trim { it <= ' ' }
                                dismap["actualFreight"] =
                                    actualFreight.text.toString().trim { it <= ' ' }
                                dismap["advance"] = advance.text.toString().trim { it <= ' ' }
                                dismap["vehicleno"] = vehicleno.text.toString().trim { it <= ' ' }
                                if (model.productName2.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName2"] =
                                        model.productName2.toString().trim { it <= ' ' }
                                    dismap["weight2"] = model.weight2.toString().trim { it <= ' ' }
                                    dismap["bag2"] = model.bag2.toString().trim { it <= ' ' }
                                    dismap["pnumber2"] = model.pnumber2.toString()
                                }
                                if (model.productName3.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName3"] =
                                        model.productName3.toString().trim { it <= ' ' }
                                    dismap["weight3"] = model.weight3.toString().trim { it <= ' ' }
                                    dismap["bag3"] = model.bag3.toString().trim { it <= ' ' }
                                    dismap["pnumber3"] = model.pnumber3.toString()
                                }
                                if (model.productName4.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName4"] =
                                        model.productName4.toString().trim { it <= ' ' }
                                    dismap["weight4"] = model.weight4.toString().trim { it <= ' ' }
                                    dismap["bag4"] = model.bag4.toString().trim { it <= ' ' }
                                    dismap["pnumber4"] = model.pnumber4.toString()
                                }
                                if (model.productName5.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName5"] =
                                        model.productName5.toString().trim { it <= ' ' }
                                    dismap["weight5"] = model.weight5.toString().trim { it <= ' ' }
                                    dismap["bag5"] = model.bag5.toString().trim { it <= ' ' }
                                    dismap["pnumber5"] = model.pnumber5.toString()
                                }
                                if (model.productName6.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName6"] =
                                        model.productName6.toString().trim { it <= ' ' }
                                    dismap["weight6"] = model.weight6.toString().trim { it <= ' ' }
                                    dismap["bag6"] = model.bag6.toString().trim { it <= ' ' }
                                    dismap["pnumber6"] = model.pnumber6.toString()
                                }
                                if (model.productName7.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName7"] =
                                        model.productName7.toString().trim { it <= ' ' }
                                    dismap["weight7"] = model.weight7.toString().trim { it <= ' ' }
                                    dismap["bag7"] = model.bag7.toString().trim { it <= ' ' }
                                    dismap["pnumber7"] = model.pnumber7.toString()
                                }
                                if (model.productName8.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName8"] =
                                        model.productName8.toString().trim { it <= ' ' }
                                    dismap["weight8"] = model.weight8.toString().trim { it <= ' ' }
                                    dismap["bag8"] = model.bag8.toString().trim { it <= ' ' }
                                    dismap["pnumber8"] = model.pnumber8.toString()
                                }
                                if (model.productName9.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName9"] =
                                        model.productName9.toString().trim { it <= ' ' }
                                    dismap["weight9"] = model.weight9.toString().trim { it <= ' ' }
                                    dismap["bag9"] = model.bag9.toString().trim { it <= ' ' }
                                    dismap["pnumber9"] = model.pnumber9.toString()
                                }
                                if (model.productName10.toString().trim { it <= ' ' } != "null") {
                                    dismap["productName10"] =
                                        model.productName10.toString().trim { it <= ' ' }
                                    dismap["weight10"] =
                                        model.weight10.toString().trim { it <= ' ' }
                                    dismap["bag10"] = model.bag10.toString().trim { it <= ' ' }
                                    dismap["pnumber10"] = model.pnumber10.toString()
                                }
                                val mudateeddmm = SimpleDateFormat(
                                    "yyyyMMdd_HHmmssSS",
                                    Locale.getDefault()
                                ).format(Date())
                                FirebaseDatabase.getInstance().reference.child("DispatchList")
                                    .child(mudateeddmm.toString())
                                    .setValue(dismap)
                                    .addOnCompleteListener {

                                        //  disdialog.dismiss()
                                        drivermobiledialog.dismiss()
                                    }

//                            FirebaseDatabase.getInstance().reference.child("Post")
//                                .child((getRef(position).key)!!)
//                                .removeValue().addOnCompleteListener{
//                                    val intt = Intent(context, PendingList::class.java)
//                                    context.startActivity(intt)
//                                }
//
//                                .addOnFailureListener(object : OnFailureListener {
//                                    override fun onFailure(e: Exception) {
//                                        Log.i("errordeletedialogbog", "onFailure :$e")
//                                    }
//                                })
                                Toast.makeText(context, "Dispatched", Toast.LENGTH_SHORT).show()

                            }

                            //
                        }
                        //else{//remain
                        //     Toast.makeText(context,"Please enter driver mobile number",Toast.LENGTH_SHORT).show();
                        // }//
                        // Map<String,Object> dismap = new HashMap<>();
                        // dismap.put("customerName",customerName.getText().toString());
                    }
                })
                drivermobiledialog.show()
            }
        })

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.post1, parent, false)
        return PostViewHolder(view)
        //return null;
    }

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var customerName: TextView
        var customerAddress: TextView? = null
        var productName: TextView
        var delAddress: TextView
        var bag: TextView
        var mobile: TextView
        var date: TextView
        var weight: TextView
        var entrynumber: TextView
        var pononame: TextView
        var pono: TextView
        var deldate: TextView
        var approxFreight: TextView
        var totalB: TextView
        var totalW: TextView
        var productName2: TextView
        var productName3: TextView
        var productName4: TextView
        var productName5: TextView
        var productName6: TextView
        var productName7: TextView
        var productName8: TextView
        var productName9: TextView
        var productName10: TextView
        var bag2: TextView
        var bag3: TextView
        var bag4: TextView
        var bag6: TextView
        var bag5: TextView
        var bag7: TextView
        var bag8: TextView
        var bag9: TextView
        var bag10: TextView
        var weight2: TextView
        var weight3: TextView
        var weight4: TextView
        var weight5: TextView
        var weight6: TextView
        var weight7: TextView
        var weight8: TextView
        var weight9: TextView
        var weight10: TextView
        var edit: Button
        var delete: Button
        var dispatch: Button
        var myid: String? = null
        var linelay2: LinearLayout
        var linelay3: LinearLayout
        var linelay4: LinearLayout
        var linelay5: LinearLayout
        var linelay6: LinearLayout
        var linelay7: LinearLayout
        var linelay8: LinearLayout
        var linelay9: LinearLayout
        var linelay10: LinearLayout

        var totalWname1: TextView
        var totalW1: TextView
        var totalWww1: TextView
        var totalWname2: TextView
        var totalW2: TextView
        var totalWww2: TextView
        var notes: TextView


        init {
            pononame = itemView.findViewById(R.id.pononame)
            customerName = itemView.findViewById(R.id.customerName)
            productName = itemView.findViewById(R.id.productName)
            // customerAddress = itemView.findViewById(R.id.customerAddress);
            delAddress = itemView.findViewById(R.id.delAddress)
            mobile = itemView.findViewById(R.id.mobileNo)
            bag = itemView.findViewById(R.id.bag)
            date = itemView.findViewById(R.id.date)
            weight = itemView.findViewById(R.id.weight)
            entrynumber = itemView.findViewById(R.id.entrynumber)
            pono = itemView.findViewById(R.id.pono)
            deldate = itemView.findViewById(R.id.deldate)
            totalB = itemView.findViewById(R.id.totalB)
            totalW = itemView.findViewById(R.id.totalW)

            totalWname1 = itemView.findViewById(R.id.totalWname1)
            totalW1 = itemView.findViewById(R.id.totalW1)
            totalWww1 = itemView.findViewById(R.id.totalWww1)
            totalWname2 = itemView.findViewById(R.id.totalWname2)
            totalW2 = itemView.findViewById(R.id.totalW2)
            totalWww2 = itemView.findViewById(R.id.totalWww2)


            notes = itemView.findViewById(R.id.notes)

            approxFreight = itemView.findViewById(R.id.approxFreight)
            productName2 = itemView.findViewById(R.id.productName2)
            productName3 = itemView.findViewById(R.id.productName3)
            productName4 = itemView.findViewById(R.id.productName4)
            productName5 = itemView.findViewById(R.id.productName5)
            productName6 = itemView.findViewById(R.id.productName6)
            productName7 = itemView.findViewById(R.id.productName7)
            productName8 = itemView.findViewById(R.id.productName8)
            productName9 = itemView.findViewById(R.id.productName9)
            productName10 = itemView.findViewById(R.id.productName10)
            linelay2 = itemView.findViewById(R.id.linelay2)
            linelay3 = itemView.findViewById(R.id.linelay3)
            linelay4 = itemView.findViewById(R.id.linelay4)
            linelay5 = itemView.findViewById(R.id.linelay5)
            linelay6 = itemView.findViewById(R.id.linelay6)
            linelay7 = itemView.findViewById(R.id.linelay7)
            linelay8 = itemView.findViewById(R.id.linelay8)
            linelay9 = itemView.findViewById(R.id.linelay9)
            linelay10 = itemView.findViewById(R.id.linelay10)
            bag2 = itemView.findViewById(R.id.bag2)
            bag3 = itemView.findViewById(R.id.bag3)
            bag4 = itemView.findViewById(R.id.bag4)
            bag5 = itemView.findViewById(R.id.bag5)
            bag6 = itemView.findViewById(R.id.bag6)
            bag7 = itemView.findViewById(R.id.bag7)
            bag8 = itemView.findViewById(R.id.bag8)
            bag9 = itemView.findViewById(R.id.bag9)
            bag10 = itemView.findViewById(R.id.bag10)
            weight2 = itemView.findViewById(R.id.weight2)
            weight3 = itemView.findViewById(R.id.weight3)
            weight4 = itemView.findViewById(R.id.weight4)
            weight5 = itemView.findViewById(R.id.weight5)
            weight6 = itemView.findViewById(R.id.weight6)
            weight7 = itemView.findViewById(R.id.weight7)
            weight8 = itemView.findViewById(R.id.weight8)
            weight9 = itemView.findViewById(R.id.weight9)
            weight10 = itemView.findViewById(R.id.weight10)
            edit = itemView.findViewById(R.id.edit)
            delete = itemView.findViewById(R.id.delete)
            dispatch = itemView.findViewById(R.id.dispatchbutton)
        }
    }

}