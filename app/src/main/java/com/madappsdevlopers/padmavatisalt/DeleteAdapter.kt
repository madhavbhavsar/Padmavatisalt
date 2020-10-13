package com.madappsdevlopers.padmavatisalt

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.madappsdevlopers.padmavatisalt.DeleteAdapter.DeleteViewHolder
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder
import java.text.SimpleDateFormat
import java.util.*

class DeleteAdapter(options: FirebaseRecyclerOptions<Post?>,
    /**
     * Initialize a [RecyclerView.Adapter] that listens to a Firebase query. See
     * [FirebaseRecyclerOptions] for configuration options.
     *
     * @param options
     */
    private val context2: Context) : FirebaseRecyclerAdapter<Post?, DeleteViewHolder>(options) {
    
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(rholder: DeleteViewHolder, position: Int, model2: Post) {
        
        rholder.remcustomerName.text = model2.customerName
        rholder.remdelAddress.text = model2.delAddress
        rholder.remmobile.text = model2.mobileNo
        rholder.remproductName.text = model2.productName
        rholder.remweight.text = model2.weight
        rholder.rembag.text = model2.bag
        rholder.remdate.text = model2.date
        rholder.rementrynumber.text = model2.entry
        rholder.reason.text = model2.reason
        rholder.rempono.text = model2.pono
        rholder.remdeldate.text = model2.deldate
        rholder.remapproxFreight.text = model2.approxFreight
        rholder.remtotalB.text = model2.totalBag
        rholder.remtotalW.text = model2.totalWeight

        rholder.remnotes.text = model2.notes


        rholder.remproductName2.text = model2.productName2
        if (rholder.remproductName2.length() > 0) {
            rholder.remlinelay2.visibility = View.VISIBLE
            rholder.rembag2.text = model2.bag2
            rholder.remweight2.text = model2.weight2
        }
        rholder.remproductName3.text = model2.productName3
        if (rholder.remproductName3.length() > 0) {
            rholder.remlinelay3.visibility = View.VISIBLE
            rholder.rembag3.text = model2.bag3
            rholder.remweight3.text = model2.weight3
        }
        rholder.remproductName4.text = model2.productName4
        if (rholder.remproductName4.length() > 0) {
            rholder.remlinelay4.visibility = View.VISIBLE
            rholder.rembag4.text = model2.bag4
            rholder.remweight4.text = model2.weight4
        }
        rholder.remproductName5.text = model2.productName5
        if (rholder.remproductName5.length() > 0) {
            rholder.remlinelay5.visibility = View.VISIBLE
            rholder.rembag5.text = model2.bag5
            rholder.remweight5.text = model2.weight5
        }
        rholder.remproductName6.text = model2.productName6
        if (rholder.remproductName6.length() > 0) {
            rholder.remlinelay6.visibility = View.VISIBLE
            rholder.rembag6.text = model2.bag6
            rholder.remweight6.text = model2.weight6
        }
        rholder.remproductName7.text = model2.productName7
        if (rholder.remproductName7.length() > 0) {
            rholder.remlinelay7.visibility = View.VISIBLE
            rholder.rembag7.text = model2.bag7
            rholder.remweight7.text = model2.weight7
        }
        rholder.remproductName8.text = model2.productName8
        if (rholder.remproductName8.length() > 0) {
            rholder.remlinelay8.visibility = View.VISIBLE
            rholder.rembag8.text = model2.bag8
            rholder.remweight8.text = model2.weight8
        }
        rholder.remproductName9.text = model2.productName9
        if (rholder.remproductName9.length() > 0) {
            rholder.remlinelay9.visibility = View.VISIBLE
            rholder.rembag9.text = model2.bag9
            rholder.remweight9.text = model2.weight9
        }
        rholder.remproductName10.text = model2.productName10
        if (rholder.remproductName10.length() > 0) {
            rholder.remlinelay10.visibility = View.VISIBLE
            rholder.rembag10.text = model2.bag10
            rholder.remweight10.text = model2.weight10
        }
        rholder.restore.setOnClickListener {
//            val resdialog = DialogPlus.newDialog(context2)
//                .setGravity(Gravity.CENTER)
//                .setMargin(50, 0, 50, 0)
//                .setContentHolder(ViewHolder(R.layout.content))
//                .setExpanded(false) // This will enable the expand feature, (similar to android L share dialog)
//                .create()
//            val holderView: View = resdialog.holderView as LinearLayout
//            val customerName =
//                holderView.findViewById<AutoCompleteTextView>(R.id.customerName)
//            //   final EditText customerAddress = holderView.findViewById(R.id.customerAddress);
//            val productName =
//                holderView.findViewById<AutoCompleteTextView>(R.id.productName)
//            val mobile = holderView.findViewById<EditText>(R.id.mobileNo)
//            val bag = holderView.findViewById<EditText>(R.id.bag)
//            val weight = holderView.findViewById<EditText>(R.id.weight)
//            val delAddress =
//                holderView.findViewById<AutoCompleteTextView>(R.id.delAddress)
//            val date = holderView.findViewById<TextView>(R.id.date)
//            val entrynumber = holderView.findViewById<TextView>(R.id.entrynumber)
//            val pono = holderView.findViewById<EditText>(R.id.pono)
//            val deldate = holderView.findViewById<TextView>(R.id.deldate)
//            val totalB = holderView.findViewById<TextView>(R.id.totalB)
//            val totalW = holderView.findViewById<TextView>(R.id.totalW)
//            val approxFreight = holderView.findViewById<EditText>(R.id.approxFreight)
//            val productName2 =
//                holderView.findViewById<AutoCompleteTextView>(R.id.productName2)
//            val productName3 =
//                holderView.findViewById<AutoCompleteTextView>(R.id.productName3)
//            val productName4 =
//                holderView.findViewById<AutoCompleteTextView>(R.id.productName4)
//            val productName5 =
//                holderView.findViewById<AutoCompleteTextView>(R.id.productName5)
//            val productName6 =
//                holderView.findViewById<AutoCompleteTextView>(R.id.productName6)
//            val productName7 =
//                holderView.findViewById<AutoCompleteTextView>(R.id.productName7)
//            val productName8 =
//                holderView.findViewById<AutoCompleteTextView>(R.id.productName8)
//            val productName9 =
//                holderView.findViewById<AutoCompleteTextView>(R.id.productName9)
//            val productName10 =
//                holderView.findViewById<AutoCompleteTextView>(R.id.productName10)
//            val bag2 = holderView.findViewById<EditText>(R.id.bag2)
//            val bag3 = holderView.findViewById<EditText>(R.id.bag3)
//            val bag4 = holderView.findViewById<EditText>(R.id.bag4)
//            val bag5 = holderView.findViewById<EditText>(R.id.bag5)
//            val bag6 = holderView.findViewById<EditText>(R.id.bag6)
//            val bag7 = holderView.findViewById<EditText>(R.id.bag7)
//            val bag8 = holderView.findViewById<EditText>(R.id.bag8)
//            val bag9 = holderView.findViewById<EditText>(R.id.bag9)
//            val bag10 = holderView.findViewById<EditText>(R.id.bag10)
//            val weight2 = holderView.findViewById<EditText>(R.id.weight2)
//            val weight3 = holderView.findViewById<EditText>(R.id.weight3)
//            val weight4 = holderView.findViewById<EditText>(R.id.weight4)
//            val weight5 = holderView.findViewById<EditText>(R.id.weight5)
//            val weight6 = holderView.findViewById<EditText>(R.id.weight6)
//            val weight7 = holderView.findViewById<EditText>(R.id.weight7)
//            val weight8 = holderView.findViewById<EditText>(R.id.weight8)
//            val weight9 = holderView.findViewById<EditText>(R.id.weight9)
//            val weight10 = holderView.findViewById<EditText>(R.id.weight10)
//            val pnumber = holderView.findViewById<EditText>(R.id.pnumber)
//            val pnumber2 = holderView.findViewById<EditText>(R.id.pnumber2)
//            val pnumber3 = holderView.findViewById<EditText>(R.id.pnumber3)
//            val pnumber4 = holderView.findViewById<EditText>(R.id.pnumber4)
//            val pnumber5 = holderView.findViewById<EditText>(R.id.pnumber5)
//            val pnumber6 = holderView.findViewById<EditText>(R.id.pnumber6)
//            val pnumber7 = holderView.findViewById<EditText>(R.id.pnumber7)
//            val pnumber8 = holderView.findViewById<EditText>(R.id.pnumber8)
//            val pnumber9 = holderView.findViewById<EditText>(R.id.pnumber9)
//            val pnumber10 = holderView.findViewById<EditText>(R.id.pnumber10)
//            customerName.setText(model2.customerName)
//            // customerAddress.setText(model2.getCustomerAddress());
//            delAddress.setText(model2.delAddress)
//            mobile.setText(model2.mobileNo)
//            productName.setText(model2.productName)
//            weight.setText(model2.weight)
//            bag.setText(model2.bag)
//            date.text = model2.date
//            entrynumber.text = model2.entry
//            pono.setText(model2.pono)
//            deldate.text = model2.deldate
//            pnumber.setText(model2.pnumber)
//            approxFreight.setText(model2.approxFreight)
//            totalB.text = model2.totalBag
//            totalW.text = model2.totalWeight
//            productName2.setText(model2.productName2)
//            if (productName2.length() > 0) {
//                bag2.setText(model2.bag2)
//                weight2.setText(model2.weight2)
//                pnumber2.setText(model2.pnumber2)
//            }
//            productName3.setText(model2.productName3)
//            if (productName3.length() > 0) {
//                bag3.setText(model2.bag3)
//                weight3.setText(model2.weight3)
//                pnumber3.setText(model2.pnumber3)
//            }
//            productName4.setText(model2.productName4)
//            if (productName4.length() > 0) {
//                bag4.setText(model2.bag4)
//                weight4.setText(model2.weight4)
//                pnumber4.setText(model2.pnumber4)
//            }
//            productName5.setText(model2.productName5)
//            if (productName5.length() > 0) {
//                bag5.setText(model2.bag5)
//                weight5.setText(model2.weight5)
//                pnumber5.setText(model2.pnumber5)
//            }
//            productName6.setText(model2.productName6)
//            if (productName6.length() > 0) {
//                bag6.setText(model2.bag6)
//                weight6.setText(model2.weight6)
//                pnumber6.setText(model2.pnumber6)
//            }
//            productName7.setText(model2.productName7)
//            if (productName7.length() > 0) {
//                bag7.setText(model2.bag7)
//                weight7.setText(model2.weight7)
//                pnumber7.setText(model2.pnumber7)
//            }
//            productName8.setText(model2.productName8)
//            if (productName8.length() > 0) {
//                bag8.setText(model2.bag8)
//                weight8.setText(model2.weight8)
//                pnumber8.setText(model2.pnumber8)
//            }
//            productName9.setText(model2.productName9)
//            if (productName9.length() > 0) {
//                bag9.setText(model2.bag9)
//                weight9.setText(model2.weight9)
//                pnumber9.setText(model2.pnumber9)
//            }
//            productName10.setText(model2.productName10)
//            if (productName10.length() > 0) {
//                bag10.setText(model2.bag10)
//                weight10.setText(model2.weight10)
//                pnumber10.setText(model2.pnumber10)
//            }
            
            val resmap: MutableMap<String, Any> = HashMap()
            resmap["customerName"] = model2.customerName.toString()
            //    dismap.put("customerAddress",customerAddress.getText().toString());
            resmap["productName"] = model2.productName.toString()
            resmap["mobileNo"] = model2.mobileNo.toString()
            resmap["weight"] = model2.weight.toString()
            resmap["bag"] = model2.bag.toString()
            resmap["delAddress"] = model2.delAddress.toString()
            resmap["date"] = model2.date.toString()
            resmap["entry"] = model2.entry.toString()
            //dismap.put("drivermobile",drivermobile.getText().toString());
            resmap["pono"] = model2.pono.toString()
            resmap["deldate"] = model2.deldate.toString()
            resmap["pnumber"] = model2.pnumber.toString()
            resmap["totalBag"] = model2.totalBag.toString()
            resmap["totalWeight"] = model2.totalWeight.toString()

            resmap["notes"] = model2.notes.toString()


            resmap["dateid"] = model2.dateid.toString()
            resmap["remainWeight"] = model2.remainWeight.toString()
            resmap["approxFreight"] = model2.approxFreight.toString()
            if (model2.productName2.toString().trim{ it <= ' ' } != "null") {
                resmap["productName2"] = model2.productName2.toString().trim { it <= ' ' }
                resmap["weight2"] = model2.weight2.toString().trim { it <= ' ' }
                resmap["bag2"] = model2.bag2.toString().trim { it <= ' ' }
                resmap["pnumber2"] = model2.pnumber2.toString()
            }
            if (model2.productName3.toString().trim { it <= ' ' } != "null") {
                resmap["productName3"] = model2.productName3.toString().trim { it <= ' ' }
                resmap["weight3"] = model2.weight3.toString().trim { it <= ' ' }
                resmap["bag3"] = model2.bag3.toString().trim { it <= ' ' }
                resmap["pnumber3"] = model2.pnumber3.toString()
            }
            if (model2.productName4.toString().trim { it <= ' ' } != "null") {
                resmap["productName4"] = model2.productName4.toString().trim { it <= ' ' }
                resmap["weight4"] = model2.weight4.toString().trim { it <= ' ' }
                resmap["bag4"] = model2.bag4.toString().trim { it <= ' ' }
                resmap["pnumber4"] = model2.pnumber4.toString()
            }
            if (model2.productName5.toString().trim { it <= ' ' } != "null") {
                resmap["productName5"] = model2.productName5.toString().trim { it <= ' ' }
                resmap["weight5"] = model2.weight5.toString().trim { it <= ' ' }
                resmap["bag5"] =model2.bag5.toString().trim { it <= ' ' }
                resmap["pnumber5"] = model2.pnumber5.toString()
            }
            if (model2.productName6.toString().trim { it <= ' ' } != "null") {
                resmap["productName6"] = model2.productName6.toString().trim { it <= ' ' }
                resmap["weight6"] = model2.weight6.toString().trim { it <= ' ' }
                resmap["bag6"] = model2.bag6.toString().trim { it <= ' ' }
                resmap["pnumber6"] = model2.pnumber6.toString()
            }
            if (model2.productName7.toString().trim { it <= ' ' } != "null") {
                resmap["productName7"] = model2.productName7.toString().trim { it <= ' ' }
                resmap["weight7"] = model2.weight7.toString().trim { it <= ' ' }
                resmap["bag7"] =model2.bag7.toString().trim { it <= ' ' }
                resmap["pnumber7"] =model2.pnumber7.toString()
            }
            if (model2.productName8.toString().trim { it <= ' ' } != "null") {
                resmap["productName8"] = model2.productName8.toString().trim { it <= ' ' }
                resmap["weight8"] = model2.weight8.toString().trim { it <= ' ' }
                resmap["bag8"] = model2.bag8.toString().trim { it <= ' ' }
                resmap["pnumber8"] = model2.pnumber8.toString()
            }
            if (model2.productName9.toString().trim { it <= ' ' } != "null") {
                resmap["productName9"] = model2.productName9.toString().trim { it <= ' ' }
                resmap["weight9"] = model2.weight9.toString().trim { it <= ' ' }
                resmap["bag9"] = model2.bag9.toString().trim { it <= ' ' }
                resmap["pnumber9"] = model2.pnumber9.toString()
            }
            if (model2.productName10.toString().trim { it <= ' ' } != "null") {
                resmap["productName10"] = model2.productName10.toString().trim { it <= ' ' }
                resmap["weight10"] = model2.weight10.toString().trim { it <= ' ' }
                resmap["bag10"] = model2.bag10.toString().trim { it <= ' ' }
                resmap["pnumber10"] = model2.pnumber10.toString()
            }
            //val mudateedd = SimpleDateFormat("yyyyMMdd_HHmmssSS", Locale.getDefault()).format(Date())
            FirebaseDatabase.getInstance().reference.child("Post")
                .child(model2.dateid.toString())
                .updateChildren(resmap)
                .addOnCompleteListener {  }


            FirebaseDatabase.getInstance().reference.child("DeleteList")
                .child(getRef(position).key!!)
                .removeValue()
                .addOnCompleteListener {
                    val intt = Intent(context2, DeleteList::class.java)
                    context2.startActivity(intt)
                }
                .addOnFailureListener { e -> Log.i("errordeletedialogbog", "onFailure :$e") }
            Toast.makeText(context2, "Restored", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeleteViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.deletepost, parent, false)
        return DeleteViewHolder(view)
    }

    inner class DeleteViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var remcustomerName: TextView
        var remcustomerAddress: TextView? = null
        var remproductName: TextView
        var remdelAddress: TextView
        var rembag: TextView
        var remmobile: TextView
        var remdate: TextView
        var remweight: TextView
        var rementrynumber: TextView
        var reason: TextView
        var rempono: TextView
        var remdeldate: TextView
        var restore: Button
        var remproductName2: TextView
        var remproductName3: TextView
        var remproductName4: TextView
        var remproductName5: TextView
        var remproductName6: TextView
        var remproductName7: TextView
        var remproductName8: TextView
        var remproductName9: TextView
        var remproductName10: TextView
        var rembag2: TextView
        var rembag3: TextView
        var rembag4: TextView
        var rembag6: TextView
        var rembag5: TextView
        var rembag7: TextView
        var rembag8: TextView
        var rembag9: TextView
        var rembag10: TextView
        var remweight2: TextView
        var remweight3: TextView
        var remweight4: TextView
        var remweight5: TextView
        var remweight6: TextView
        var remweight7: TextView
        var remweight8: TextView
        var remweight9: TextView
        var remweight10: TextView
        var remlinelay2: LinearLayout
        var remlinelay3: LinearLayout
        var remlinelay4: LinearLayout
        var remlinelay5: LinearLayout
        var remlinelay6: LinearLayout
        var remlinelay7: LinearLayout
        var remlinelay8: LinearLayout
        var remlinelay9: LinearLayout
        var remlinelay10: LinearLayout
        var remapproxFreight: TextView
        var remtotalW: TextView
        var remtotalB: TextView
        var remnotes: TextView

        init {
            remcustomerName = itemView.findViewById(R.id.remcustomerName)
            remproductName = itemView.findViewById(R.id.remproductName)
            //   remcustomerAddress = itemView.findViewById(R.id.remcustomerAddress);
            remdelAddress = itemView.findViewById(R.id.remdelAddress)
            remmobile = itemView.findViewById(R.id.remmobileNo)
            rembag = itemView.findViewById(R.id.rembag)
            remdate = itemView.findViewById(R.id.remdate)
            remweight = itemView.findViewById(R.id.remweight)
            rementrynumber = itemView.findViewById(R.id.rementrynumber)
            reason = itemView.findViewById(R.id.reason)
            rempono = itemView.findViewById(R.id.rempono)
            remdeldate = itemView.findViewById(R.id.remdeldate)
            remtotalB = itemView.findViewById(R.id.remtotalB)
            remtotalW = itemView.findViewById(R.id.remtotalW)
            remapproxFreight = itemView.findViewById(R.id.remapproxFreight)
            remproductName2 = itemView.findViewById(R.id.remproductName2)
            remproductName3 = itemView.findViewById(R.id.remproductName3)
            remproductName4 = itemView.findViewById(R.id.remproductName4)
            remproductName5 = itemView.findViewById(R.id.remproductName5)
            remproductName6 = itemView.findViewById(R.id.remproductName6)
            remproductName7 = itemView.findViewById(R.id.remproductName7)
            remproductName8 = itemView.findViewById(R.id.remproductName8)
            remproductName9 = itemView.findViewById(R.id.remproductName9)
            remproductName10 = itemView.findViewById(R.id.remproductName10)
            remlinelay2 = itemView.findViewById(R.id.remlinelay2)
            remlinelay3 = itemView.findViewById(R.id.remlinelay3)
            remlinelay4 = itemView.findViewById(R.id.remlinelay4)
            remlinelay5 = itemView.findViewById(R.id.remlinelay5)
            remlinelay6 = itemView.findViewById(R.id.remlinelay6)
            remlinelay7 = itemView.findViewById(R.id.remlinelay7)
            remlinelay8 = itemView.findViewById(R.id.remlinelay8)
            remlinelay9 = itemView.findViewById(R.id.remlinelay9)
            remlinelay10 = itemView.findViewById(R.id.remlinelay10)
            rembag2 = itemView.findViewById(R.id.rembag2)
            rembag3 = itemView.findViewById(R.id.rembag3)
            rembag4 = itemView.findViewById(R.id.rembag4)
            rembag5 = itemView.findViewById(R.id.rembag5)
            rembag6 = itemView.findViewById(R.id.rembag6)
            rembag7 = itemView.findViewById(R.id.rembag7)
            rembag8 = itemView.findViewById(R.id.rembag8)
            rembag9 = itemView.findViewById(R.id.rembag9)
            rembag10 = itemView.findViewById(R.id.rembag10)
            remweight2 = itemView.findViewById(R.id.remweight2)
            remweight3 = itemView.findViewById(R.id.remweight3)
            remweight4 = itemView.findViewById(R.id.remweight4)
            remweight5 = itemView.findViewById(R.id.remweight5)
            remweight6 = itemView.findViewById(R.id.remweight6)
            remweight7 = itemView.findViewById(R.id.remweight7)
            remweight8 = itemView.findViewById(R.id.remweight8)
            remweight9 = itemView.findViewById(R.id.remweight9)
            remweight10 = itemView.findViewById(R.id.remweight10)
            restore = itemView.findViewById(R.id.restorebtn)
            remnotes = itemView.findViewById(R.id.remnotes)
        }
    }

}