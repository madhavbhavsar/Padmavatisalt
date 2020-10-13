package com.madappsdevlopers.padmavatisalt

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.madappsdevlopers.padmavatisalt.CustomerAdapter.CusViewHolder
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder
import java.util.*

class CustomerAdapter(
    options: FirebaseRecyclerOptions<Post?>,
    /**
     * Initialize a [RecyclerView.Adapter] that listens to a Firebase query. See
     * [FirebaseRecyclerOptions] for configuration options.
     *
     * @param options
     */
    private val contextcus: Context
) : FirebaseRecyclerAdapter<Post, CusViewHolder>(options) {
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(
        cusholder: CusViewHolder,
        position: Int,
        modelcus: Post
    ) {
        cusholder.cuscustomerName.text = modelcus.customerName
        cusholder.cusmobileNo.text = modelcus.mobileNo
        cusholder.editcus.setOnClickListener {
            val cusdialog = DialogPlus.newDialog(contextcus)
                .setGravity(Gravity.CENTER)
                .setMargin(50, 0, 50, 0)
                .setContentHolder(ViewHolder(R.layout.cuscontent))
                .setExpanded(false) // This will enable the expand feature, (similar to android L share dialog)
                .create()
            val cusholderView: View = cusdialog.holderView as LinearLayout

            val cusscustomerName = cusholderView.findViewById<EditText>(R.id.cusscustomerName)
            val cussmobile = cusholderView.findViewById<EditText>(R.id.cussmobileNo)

            cusscustomerName.setText(modelcus.customerName)
            cussmobile.setText(modelcus.mobileNo)
            val updatecus =
                cusholderView.findViewById<Button>(R.id.updatecus)
            updatecus.setOnClickListener {
                if (cusscustomerName.length() == 0) {
                    Toast.makeText(contextcus, "Enter Name", Toast.LENGTH_SHORT).show()
                } else if (cussmobile.length() <= 9||cussmobile.length()>25) {
                    Toast.makeText(
                        contextcus,
                        "Enter Mobile No. correctly",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    val mapCustomer: MutableMap<String, Any> =
                        HashMap()
                    mapCustomer["customerName"] = cusscustomerName.text.toString()
                    mapCustomer["mobileNo"] = cussmobile.text.toString()
                    //mapCustomer.put("customerAddress",address.getText().toString());
                    FirebaseDatabase.getInstance().reference.child("CustomerList")
                        .child(getRef(position).key!!)
                        .updateChildren(mapCustomer).addOnCompleteListener { cusdialog.dismiss() }
                }
            }
            cusdialog.show()
        }
        cusholder.deletecus.setOnClickListener {
            val dcuslog = DialogPlus.newDialog(contextcus)
                .setGravity(Gravity.CENTER)
                .setMargin(50, 0, 50, 0)
                .setContentHolder(ViewHolder(R.layout.deletecus))
                .setExpanded(false) // This will enable the expand feature, (similar to android L share dialog)
                .create()
            val hcusView: View = dcuslog.holderView as LinearLayout
            val deleteentrycus =
                hcusView.findViewById<Button>(R.id.deleteentrycus)
            val deletenocus =
                hcusView.findViewById<Button>(R.id.deletenocus)
            deletenocus.setOnClickListener {
                val iderr = Intent(contextcus, CustomerEntry::class.java)
                contextcus.startActivity(iderr)
                (contextcus as Activity).overridePendingTransition(0, 0)
                iderr.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                dcuslog.dismiss()
            }
            deleteentrycus.setOnClickListener {
                FirebaseDatabase.getInstance().reference.child("CustomerList")
                    .child(getRef(position).key!!)
                    .removeValue()
                    .addOnCompleteListener {
                        dcuslog.dismiss()
                        val ide = Intent(contextcus, CustomerEntry::class.java)
                        contextcus.startActivity(ide)
                        (contextcus as Activity).overridePendingTransition(0, 0)
                        ide.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    }
            }
            dcuslog.show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CusViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cuspost, parent, false)
        return CusViewHolder(view)
    }

    inner class CusViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var cusmobileNo: TextView
        var cuscustomerName: TextView
        var editcus: Button
        var deletecus: Button

        init {
            cuscustomerName = itemView.findViewById(R.id.cuscustomerName)
            cusmobileNo = itemView.findViewById(R.id.cusmobileNo)
            editcus = itemView.findViewById(R.id.editcus)
            deletecus = itemView.findViewById(R.id.deletecus)
        }
    }

}