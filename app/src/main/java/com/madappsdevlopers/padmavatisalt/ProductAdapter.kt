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
import com.madappsdevlopers.padmavatisalt.ProductAdapter.ProViewHolder
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder
import java.util.*

class ProductAdapter(
    options: FirebaseRecyclerOptions<Post?>,
    /**
     * Initialize a [RecyclerView.Adapter] that listens to a Firebase query. See
     * [FirebaseRecyclerOptions] for configuration options.
     *
     * @param options
     */
    private val contextpro: Context
) : FirebaseRecyclerAdapter<Post, ProViewHolder>(options) {
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(
        proholder: ProViewHolder,
        position: Int,
        promodel: Post
    ) {
        proholder.proproductName.text = promodel.productName
        proholder.propnumber.text = promodel.pnumber
        proholder.editpro.setOnClickListener {
            val prodialog = DialogPlus.newDialog(contextpro)
                .setGravity(Gravity.CENTER)
                .setMargin(50, 0, 50, 0)
                .setContentHolder(ViewHolder(R.layout.procontent))
                .setExpanded(false) // This will enable the expand feature, (similar to android L share dialog)
                .create()
            val proholderView: View = prodialog.holderView as LinearLayout

            val proproductName = proholderView.findViewById<EditText>(R.id.proproductName)
            val propnumber = proholderView.findViewById<EditText>(R.id.propnumber)

            proproductName.setText(promodel.productName)
            propnumber.setText(promodel.pnumber)
            val updatepro =
                proholderView.findViewById<Button>(R.id.updatepro)
            updatepro.setOnClickListener {
                if (proproductName.length() == 0) {
                    Toast.makeText(contextpro, "Enter Product Name", Toast.LENGTH_SHORT)
                        .show()
                } else if (propnumber.length() == 0) {
                    Toast.makeText(contextpro, "Enter weight", Toast.LENGTH_SHORT).show()
                } else {
                    val mapProd: MutableMap<String, Any> =
                        HashMap()
                    mapProd["productName"] = proproductName.text.toString()
                    mapProd["pnumber"] = propnumber.text.toString()
                    //mapCustomer.put("customerAddress",address.getText().toString());
                    FirebaseDatabase.getInstance().reference.child("ProductsList")
                        .child(getRef(position).key!!)
                        .updateChildren(mapProd).addOnCompleteListener { prodialog.dismiss() }
                }
            }
            prodialog.show()
        }
        proholder.deletepro.setOnClickListener {
            val dprolog = DialogPlus.newDialog(contextpro)
                .setGravity(Gravity.CENTER)
                .setMargin(50, 0, 50, 0)
                .setContentHolder(ViewHolder(R.layout.deletecus))
                .setExpanded(false) // This will enable the expand feature, (similar to android L share dialog)
                .create()
            val hcusView: View = dprolog.holderView as LinearLayout
            val deleteentrycus =
                hcusView.findViewById<Button>(R.id.deleteentrycus)
            val deletenocus =
                hcusView.findViewById<Button>(R.id.deletenocus)
            deletenocus.setOnClickListener {
                val ide54rr = Intent(contextpro, ProductEntry::class.java)
                contextpro.startActivity(ide54rr)
                (contextpro as Activity).overridePendingTransition(0, 0)
                ide54rr.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                dprolog.dismiss()
            }
            deleteentrycus.setOnClickListener {
                FirebaseDatabase.getInstance().reference.child("ProductsList")
                    .child(getRef(position).key!!)
                    .removeValue()
                    .addOnCompleteListener {
                        val ide54 = Intent(contextpro, ProductEntry::class.java)
                        contextpro.startActivity(ide54)
                        (contextpro as Activity).overridePendingTransition(0, 0)
                        ide54.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                    }
            }
            dprolog.show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.propost, parent, false)
        return ProViewHolder(view)
    }

    inner class ProViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var proproductName: TextView
        var propnumber: TextView
        var editpro: Button
        var deletepro: Button

        init {
            proproductName = itemView.findViewById(R.id.proproductName)
            propnumber = itemView.findViewById(R.id.propnumber)
            editpro = itemView.findViewById(R.id.editpro)
            deletepro = itemView.findViewById(R.id.deletepro)
        }
    }

}