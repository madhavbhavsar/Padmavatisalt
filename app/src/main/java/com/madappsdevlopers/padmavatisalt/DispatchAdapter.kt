package com.madappsdevlopers.padmavatisalt

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.print.PrintAttributes
import android.print.PrintManager
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.itextpdf.text.*
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfWriter
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import com.madappsdevlopers.padmavatisalt.DispatchAdapter.DisViewHolder
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception
import java.util.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.getSystemService


class DispatchAdapter(
    options: FirebaseRecyclerOptions<Post?>,
    /**
     * Initialize a [RecyclerView.Adapter] that listens to a Firebase query. See
     * [FirebaseRecyclerOptions] for configuration options.
     *
     * @param options
     */
    private val context1: Context
) : FirebaseRecyclerAdapter<Post?, DisViewHolder>(options) {
    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun onBindViewHolder(
        dholder: DisViewHolder,
        position: Int,
        model1: Post
    ) {
        // dholder.discustomerAddress.setText(model1.getCustomerAddress());
        dholder.discustomerName.text = model1.customerName
        dholder.disdelAddress.text = model1.delAddress
        dholder.dismobile.text = model1.mobileNo
        dholder.disproductName.text = model1.productName
        dholder.disweight.text = model1.weight
        dholder.disbag.text = model1.bag
        dholder.disdate.text = model1.date
        dholder.disentrynumber.text = model1.entry
        dholder.disdrivermobile.text = model1.drivermobile
        dholder.dispono.text = model1.pono
        dholder.disdeldate.text = model1.deldate
        dholder.distotalB.text = model1.totalBag
        dholder.distotalW.text = model1.totalWeight
        dholder.distotalW1.text = model1.dispatchWeight

        dholder.disactualFreight.text = model1.actualFreight

        dholder.disnotes.text = model1.notes
        dholder.disadvance.text = model1.advance

        //dholder.distotalFreight.setText(model1.getTotalFreight());
        dholder.distransportername.text = model1.transportername
        dholder.disvehicleno.text = model1.vehicleno
        dholder.disdispatchdate.text = model1.dispatchdate
        dholder.disproductName2.text = model1.productName2

        if (dholder.dispono.text.toString().length > 0) {
            dholder.dispono.visibility = View.VISIBLE
            dholder.dispononame.visibility = View.VISIBLE
        }

        if (dholder.disproductName2.length() > 0) {
            dholder.dislinelay2.visibility = View.VISIBLE
            dholder.disbag2.text = model1.bag2
            dholder.disweight2.text = model1.weight2
        }
        dholder.disproductName3.text = model1.productName3
        if (dholder.disproductName3.length() > 0) {
            dholder.dislinelay3.visibility = View.VISIBLE
            dholder.disbag3.text = model1.bag3
            dholder.disweight3.text = model1.weight3
        }
        dholder.disproductName4.text = model1.productName4
        if (dholder.disproductName4.length() > 0) {
            dholder.dislinelay4.visibility = View.VISIBLE
            dholder.disbag4.text = model1.bag4
            dholder.disweight4.text = model1.weight4
        }
        dholder.disproductName5.text = model1.productName5
        if (dholder.disproductName5.length() > 0) {
            dholder.dislinelay5.visibility = View.VISIBLE
            dholder.disbag5.text = model1.bag5
            dholder.disweight5.text = model1.weight5
        }
        dholder.disproductName6.text = model1.productName6
        if (dholder.disproductName6.length() > 0) {
            dholder.dislinelay6.visibility = View.VISIBLE
            dholder.disbag6.text = model1.bag6
            dholder.disweight6.text = model1.weight6
        }
        dholder.disproductName7.text = model1.productName7
        if (dholder.disproductName7.length() > 0) {
            dholder.dislinelay7.visibility = View.VISIBLE
            dholder.disbag7.text = model1.bag7
            dholder.disweight7.text = model1.weight7
        }
        dholder.disproductName8.text = model1.productName8
        if (dholder.disproductName8.length() > 0) {
            dholder.dislinelay8.visibility = View.VISIBLE
            dholder.disbag8.text = model1.bag8
            dholder.disweight8.text = model1.weight8
        }
        dholder.disproductName9.text = model1.productName9
        if (dholder.disproductName9.length() > 0) {
            dholder.dislinelay9.visibility = View.VISIBLE
            dholder.disbag9.text = model1.bag9
            dholder.disweight9.text = model1.weight9
        }
        dholder.disproductName10.text = model1.productName10
        if (dholder.disproductName10.length() > 0) {
            dholder.dislinelay10.visibility = View.VISIBLE
            dholder.disbag10.text = model1.bag10
            dholder.disweight10.text = model1.weight10
        }



        Dexter.withActivity(context1 as Activity)
            .withPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
            .withListener(object :PermissionListener{
                override fun onPermissionGranted(response: PermissionGrantedResponse?) {
                    dholder.printbtn.setOnClickListener{
                        var body2 = ""
                        var body3 = ""
                        var body4 = ""
                        var body5 = ""
                        var body6 = ""
                        var body7 = ""
                        var body8 = ""
                        var body9 = ""
                        var body10 = ""
                        var body11 = ""
                        var boody = ""

                        if (dholder.dispono.length() > 0) {
                            boody = "\nP.O.No. - "+dholder.dispono.text.toString()
                        }

                        val body1 = "Dispatched\n"
                        val boddy = "\nOrder No. - " + dholder.disentrynumber.text.toString() +boody+
                                "\nOrder Date - " + dholder.disdate.text.toString() +
                                "\nName - " + dholder.discustomerName.text.toString() +
                                "\nMobile - " + dholder.dismobile.text.toString() +
                                "\n"

                        if (dholder.disproductName.length() > 0) {
                            body2 =
                                "(1). " + dholder.disproductName.text.toString() +
                                        "    " + dholder.disbag.text
                                    .toString() + " Bags    " + dholder.disweight.text
                                    .toString() + " Ton" + "\n"
                        }
                        if (dholder.disproductName2.length() > 0) {
                            body3 =
                                "(2). " + dholder.disproductName2.text.toString() +
                                        "    " + dholder.disbag2.text
                                    .toString() + " Bags" + "    " + dholder.disweight2.text
                                    .toString() + " Ton" + "\n"
                        }
                        if (dholder.disproductName3.length() > 0) {
                            body4 =
                                "(3). " + dholder.disproductName3.text.toString()  +
                                        "    " + dholder.disbag3.text
                                    .toString() + " Bags" + "    " + dholder.disweight3.text
                                    .toString() + " Ton" + "\n"
                        }
                        if (dholder.disproductName4.length() > 0) {
                            body5 =
                                "(4). "  + dholder.disproductName4.text.toString() +
                                        "    " + dholder.disbag4.text
                                    .toString() + " Bags" + "    " + dholder.disweight4.text
                                    .toString() + " Ton" + "\n"
                        }
                        if (dholder.disproductName5.length() > 0) {
                            body6 =
                                "(5). "  + dholder.disproductName5.text.toString() +
                                        "    " + dholder.disbag5.text
                                    .toString() + " Bags" + "    " + dholder.disweight5.text
                                    .toString() + " Ton" + "\n"
                        }
                        if (dholder.disproductName6.length() > 0) {
                            body7 =
                                "(6). "  + dholder.disproductName6.text.toString() +
                                        "    " + dholder.disbag6.text
                                    .toString() + " Bags" + "    " + dholder.disweight6.text
                                    .toString() + " Ton" + "\n"
                        }
                        if (dholder.disproductName7.length() > 0) {
                            body8 =
                                "(7). "  + dholder.disproductName7.text.toString() +
                                        "    " + dholder.disbag7.text
                                    .toString() + " Bags" + "    " + dholder.disweight7.text
                                    .toString() + " Ton" + "\n"
                        }
                        if (dholder.disproductName8.length() > 0) {
                            body9 =
                                "(8). "  + dholder.disproductName8.text.toString() +
                                        "    " + dholder.disbag8.text
                                    .toString() + " Bags" + "    " + dholder.disweight8.text
                                    .toString() + " Ton" + "\n"
                        }
                        if (dholder.disproductName9.length() > 0) {
                            body10 =
                                "(9). "  + dholder.disproductName9.text.toString()+
                                        "    " + dholder.disbag9.text
                                    .toString() + " Bags" + "    " + dholder.disweight9.text
                                    .toString() + " Ton" + "\n"
                        }
                        if (dholder.disproductName10.length() > 0) {
                            body11 = "(10). "  + dholder.disproductName10.text
                                .toString()  +
                                    "    " + dholder.disbag10.text
                                .toString() + " Bags" + "    " + dholder.disweight10.text
                                .toString() + " Ton" + "\n"
                        }
//                        if (dholder.disdelAddress.length() > 0) {
//                            val bodydel = "\nDelivery Address - "+dholder.disdelAddress.text.toString()
//                        }
                        val body12 = "\nTotal Bag - " + dholder.distotalB.text.toString()  + " Bags" +
                                "\nTotal Weight - " + dholder.distotalW.text.toString()  + " Tons" +
                                "\nDispatched Weight - " + dholder.distotalW1.text.toString()  + " Tons" +

                                "\nDelivery Date - " + dholder.disdeldate.text.toString() +
                                "\nDel. Add.- " + dholder.disdelAddress.text.toString() +

                                "\nActual Freight - "  + dholder.disactualFreight.text.toString()  +
                                "\nAdvance - " + dholder.disadvance.text.toString() +
                                // "\nTotal Freight - "+"*"+dholder.distotalFreight.getText().toString()+"*"+
                                "\nTransporter Name - " + dholder.distransportername.text.toString() +
                                "\nVehicle No. - " + dholder.disvehicleno.text.toString() +
                                "\nDriver Mobile - "  + dholder.disdrivermobile.text.toString()  +
                                "\nDispatch Date.- " + dholder.disdispatchdate.text.toString() +

                                "\n"

                        //  "\nTotal Bags - "+ dholder.distotalB.getText().toString()+"\nTransporter Name - "+dholder.distransportername.getText().toString()+
                        val productbody = "\nProduct List\n"+body2 + body3 + body4 + body5 + body6 + body7 + body8 + body9 + body10 + body11
                        val remainbody = body12

                        val mainBody =
                            body1 + boddy

                        //createPDFFile(Common.getAppPath(context1)+"test_pdf.pdf",mainBody,productbody,remainbody)

                        createPDFFile(Common.getAppPath(context1)+"Order_"+dholder.disentrynumber.text.toString()+".pdf",mainBody,productbody,remainbody,dholder)




                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?
                ) {

                }

                override fun onPermissionDenied(response: PermissionDeniedResponse?) {

                }

            })
            .check()


        dholder.sharebtn.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            var body2 = ""
            var body3 = ""
            var body4 = ""
            var body5 = ""
            var body6 = ""
            var body7 = ""
            var body8 = ""
            var body9 = ""
            var body10 = ""
            var body11 = ""
            var boody = ""
            val body1 = "Dispatched\n"
            val boddy = "\nOrder No. - " + dholder.disentrynumber.text
                .toString() + "\t\t\tOrder Date - " + dholder.disdate.text.toString() +
                    "\nDel. Add.- " + dholder.disdelAddress.text
                .toString() + "\nDispatch Date.- " + dholder.disdispatchdate.text
                .toString() +
                    "\n" +
                    "\n" + "Product List " + "\n"
            if (dholder.dispono.length() > 0) {
                boody = """

                P.O.No. - ${dholder.dispono.text}
                """.trimIndent()
            }
            if (dholder.disproductName.length() > 0) {
                val qw = 25 - dholder.disproductName.length()
                var spc = ""
                for (i in 1 until qw) {
                    spc += " "
                }
                body2 =
                    "(1). " + "*" + dholder.disproductName.text.toString() + "*" + spc +
                            "\t" + dholder.disbag.text
                        .toString() + " Bags" + "\t\t" + dholder.disweight.text
                        .toString() + " Ton" + "\n"
            }
            if (dholder.disproductName2.length() > 0) {
                val qw2 = 25 - dholder.disproductName2.length()
                var spc2 = ""
                for (i2 in 1 until qw2) {
                    spc2 += " "
                }
                body3 =
                    "(2). " + "*" + dholder.disproductName2.text.toString() + "*" + spc2 +
                            "\t" + dholder.disbag2.text
                        .toString() + " Bags" + "\t\t" + dholder.disweight2.text
                        .toString() + " Ton" + "\n"
            }
            if (dholder.disproductName3.length() > 0) {
                val qw3 = 25 - dholder.disproductName3.length()
                var spc3 = ""
                for (i3 in 1 until qw3) {
                    spc3 += " "
                }
                body4 =
                    "(3). " + "*" + dholder.disproductName3.text.toString() + "*" + spc3 +
                            "\t" + dholder.disbag3.text
                        .toString() + " Bags" + "\t\t" + dholder.disweight3.text
                        .toString() + " Ton" + "\n"
            }
            if (dholder.disproductName4.length() > 0) {
                val qw4 = 25 - dholder.disproductName4.length()
                var spc4 = ""
                for (i4 in 1 until qw4) {
                    spc4 += " "
                }
                body5 =
                    "(4). " + "*" + dholder.disproductName4.text.toString() + "*" + spc4 +
                            "\t" + dholder.disbag4.text
                        .toString() + " Bags" + "\t\t" + dholder.disweight4.text
                        .toString() + " Ton" + "\n"
            }
            if (dholder.disproductName5.length() > 0) {
                val qw5 = 25 - dholder.disproductName5.length()
                var spc5 = ""
                for (i5 in 1 until qw5) {
                    spc5 += " "
                }
                body6 =
                    "(5). " + "*" + dholder.disproductName5.text.toString() + "*" + spc5 +
                            "\t" + dholder.disbag5.text
                        .toString() + " Bags" + "\t\t" + dholder.disweight5.text
                        .toString() + " Ton" + "\n"
            }
            if (dholder.disproductName6.length() > 0) {
                val qw6 = 25 - dholder.disproductName6.length()
                var spc6 = ""
                for (i6 in 1 until qw6) {
                    spc6 += " "
                }
                body7 =
                    "(6). " + "*" + dholder.disproductName6.text.toString() + "*" + spc6 +
                            "\t" + dholder.disbag6.text
                        .toString() + " Bags" + "\t\t" + dholder.disweight6.text
                        .toString() + " Ton" + "\n"
            }
            if (dholder.disproductName7.length() > 0) {
                val qw7 = 25 - dholder.disproductName7.length()
                var spc7 = ""
                for (i7 in 1 until qw7) {
                    spc7 += " "
                }
                body8 =
                    "(7). " + "*" + dholder.disproductName7.text.toString() + "*" + spc7 +
                            "\t" + dholder.disbag7.text
                        .toString() + " Bags" + "\t\t" + dholder.disweight7.text
                        .toString() + " Ton" + "\n"
            }
            if (dholder.disproductName8.length() > 0) {
                val qw8 = 25 - dholder.disproductName8.length()
                var spc8 = ""
                for (i8 in 1 until qw8) {
                    spc8 += " "
                }
                body9 =
                    "(8). " + "*" + dholder.disproductName8.text.toString() + "*" + spc8 +
                            "\t" + dholder.disbag8.text
                        .toString() + " Bags" + "\t\t" + dholder.disweight8.text
                        .toString() + " Ton" + "\n"
            }
            if (dholder.disproductName9.length() > 0) {
                val qw9 = 25 - dholder.disproductName9.length()
                var spc9 = ""
                for (i9 in 1 until qw9) {
                    spc9 += " "
                }
                body10 =
                    "(9). " + "*" + dholder.disproductName9.text.toString() + "*" + spc9 +
                            "\t" + dholder.disbag9.text
                        .toString() + " Bags" + "\t\t" + dholder.disweight9.text
                        .toString() + " Ton" + "\n"
            }
            if (dholder.disproductName10.length() > 0) {
                val qw10 = 25 - dholder.disproductName10.length()
                var spc10 = ""
                for (i10 in 1 until qw10) {
                    spc10 += " "
                }
                body11 = "(10). " + "*" + dholder.disproductName10.text
                    .toString() + "*" + spc10 +
                        "\t" + dholder.disbag10.text
                    .toString() + " Bags" + "\t\t" + dholder.disweight10.text
                    .toString() + " Ton" + "\n"
            }
            val body12 = "\nTotal Weight - " +"*"+ dholder.distotalW.text.toString() + "*" + " *Tons*" + "\nDispatched Weight - " +"*"+ dholder.distotalW1.text.toString() + "*" + " *Tons*" +
                    "\nActual Freight - " + "*" + dholder.disactualFreight.text
                .toString() + "*" +  // "\nTotal Freight - "+"*"+dholder.distotalFreight.getText().toString()+"*"+
                    "\nDriver Mobile - " + "*" + dholder.disdrivermobile.text
                .toString() + "*" +
                    "\nVehicle No. - " + dholder.disvehicleno.text.toString() + "\n"

            //  "\nTotal Bags - "+ dholder.distotalB.getText().toString()+"\nTransporter Name - "+dholder.distransportername.getText().toString()+
            val mainBody =
                body1 + boddy + body2 + body3 + body4 + body5 + body6 + body7 + body8 + body9 + body10 + body11 + body12
            val subb = "PSPL Dispatch Details"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, subb)
            shareIntent.putExtra(Intent.EXTRA_TEXT, mainBody)
            context1.startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
        dholder.undispatched.setOnClickListener {
            val unddislog = DialogPlus.newDialog(context1)
                .setGravity(Gravity.CENTER)
                .setMargin(50, 0, 50, 0)
                .setContentHolder(ViewHolder(R.layout.undisbtn))
                .setExpanded(false) // This will enable the expand feature, (similar to android L share dialog)
                .create()
            val unndis: View = unddislog.holderView as LinearLayout
            val undisyes =
                unndis.findViewById<Button>(R.id.undisyes)
            val undisno =
                unndis.findViewById<Button>(R.id.undisno)

            var rwpost : String ="0.0"
            FirebaseDatabase.getInstance().reference.child("Post").child(model1.dateid.toString())
                .addValueEventListener(object : ValueEventListener{
                    override fun onCancelled(error: DatabaseError) {

                    }

                    override fun onDataChange(snapshot: DataSnapshot) {
                        rwpost = snapshot.child("remainWeight").value.toString()
                       // println("undisssbtnremvalue"+rwpost)
                    }

                })
            if (rwpost =="null"){
               // println("thisisnulll"+"nulll")
                rwpost = "0.0"
            }
            undisyes.setOnClickListener {
//                val undisdialog = DialogPlus.newDialog(context1)
//                    .setGravity(Gravity.CENTER)
//                    .setMargin(50, 0, 50, 0)
//                    .setContentHolder(ViewHolder(R.layout.content))
//                    .setExpanded(false) // This will enable the expand feature, (similar to android L share dialog)
//                    .create()
//                val holderView: View =
//                    undisdialog.holderView as LinearLayout
//                val customerName =
//                    holderView.findViewById<AutoCompleteTextView>(R.id.customerName)
//                //   final EditText customerAddress = holderView.findViewById(R.id.customerAddress);
//                val productName =
//                    holderView.findViewById<AutoCompleteTextView>(R.id.productName)
//                val mobile = holderView.findViewById<EditText>(R.id.mobileNo)
//                val bag = holderView.findViewById<EditText>(R.id.bag)
//                val weight = holderView.findViewById<EditText>(R.id.weight)
//                val delAddress =
//                    holderView.findViewById<AutoCompleteTextView>(R.id.delAddress)
//                val date = holderView.findViewById<TextView>(R.id.date)
//                val entrynumber =
//                    holderView.findViewById<TextView>(R.id.entrynumber)
//                val pono = holderView.findViewById<EditText>(R.id.pono)
//                val deldate = holderView.findViewById<TextView>(R.id.deldate)
//                val totalW = holderView.findViewById<TextView>(R.id.totalW)
//                val totalB = holderView.findViewById<TextView>(R.id.totalB)
//                val productName2 =
//                    holderView.findViewById<AutoCompleteTextView>(R.id.productName2)
//                val productName3 =
//                    holderView.findViewById<AutoCompleteTextView>(R.id.productName3)
//                val productName4 =
//                    holderView.findViewById<AutoCompleteTextView>(R.id.productName4)
//                val productName5 =
//                    holderView.findViewById<AutoCompleteTextView>(R.id.productName5)
//                val productName6 =
//                    holderView.findViewById<AutoCompleteTextView>(R.id.productName6)
//                val productName7 =
//                    holderView.findViewById<AutoCompleteTextView>(R.id.productName7)
//                val productName8 =
//                    holderView.findViewById<AutoCompleteTextView>(R.id.productName8)
//                val productName9 =
//                    holderView.findViewById<AutoCompleteTextView>(R.id.productName9)
//                val productName10 =
//                    holderView.findViewById<AutoCompleteTextView>(R.id.productName10)
//                val bag2 = holderView.findViewById<EditText>(R.id.bag2)
//                val bag3 = holderView.findViewById<EditText>(R.id.bag3)
//                val bag4 = holderView.findViewById<EditText>(R.id.bag4)
//                val bag5 = holderView.findViewById<EditText>(R.id.bag5)
//                val bag6 = holderView.findViewById<EditText>(R.id.bag6)
//                val bag7 = holderView.findViewById<EditText>(R.id.bag7)
//                val bag8 = holderView.findViewById<EditText>(R.id.bag8)
//                val bag9 = holderView.findViewById<EditText>(R.id.bag9)
//                val bag10 = holderView.findViewById<EditText>(R.id.bag10)
//                val weight2 = holderView.findViewById<EditText>(R.id.weight2)
//                val weight3 = holderView.findViewById<EditText>(R.id.weight3)
//                val weight4 = holderView.findViewById<EditText>(R.id.weight4)
//                val weight5 = holderView.findViewById<EditText>(R.id.weight5)
//                val weight6 = holderView.findViewById<EditText>(R.id.weight6)
//                val weight7 = holderView.findViewById<EditText>(R.id.weight7)
//                val weight8 = holderView.findViewById<EditText>(R.id.weight8)
//                val weight9 = holderView.findViewById<EditText>(R.id.weight9)
//                val weight10 = holderView.findViewById<EditText>(R.id.weight10)
//                val pnumber = holderView.findViewById<EditText>(R.id.pnumber)
//                val pnumber2 = holderView.findViewById<EditText>(R.id.pnumber2)
//                val pnumber3 = holderView.findViewById<EditText>(R.id.pnumber3)
//                val pnumber4 = holderView.findViewById<EditText>(R.id.pnumber4)
//                val pnumber5 = holderView.findViewById<EditText>(R.id.pnumber5)
//                val pnumber6 = holderView.findViewById<EditText>(R.id.pnumber6)
//                val pnumber7 = holderView.findViewById<EditText>(R.id.pnumber7)
//                val pnumber8 = holderView.findViewById<EditText>(R.id.pnumber8)
//                val pnumber9 = holderView.findViewById<EditText>(R.id.pnumber9)
//                val pnumber10 = holderView.findViewById<EditText>(R.id.pnumber10)
//                customerName.setText(model1.customerName)
//                // customerAddress.setText(model1.getCustomerAddress());
//                delAddress.setText(model1.delAddress)
//                mobile.setText(model1.mobileNo)
//                productName.setText(model1.productName)
//                weight.setText(model1.weight)
//                bag.setText(model1.bag)
//                date.text = model1.date
//                entrynumber.text = model1.entry
//                pono.setText(model1.pono)
//                deldate.text = model1.deldate
//                pnumber.setText(model1.pnumber)
//                totalB.text = model1.totalBag
//                totalW.text = model1.totalWeight
//                productName2.setText(model1.productName2)
//                if (productName2.length() > 0) {
//                    bag2.setText(model1.bag2)
//                    weight2.setText(model1.weight2)
//                    pnumber2.setText(model1.pnumber2)
//                }
//                productName3.setText(model1.productName3)
//                if (productName3.length() > 0) {
//                    bag3.setText(model1.bag3)
//                    weight3.setText(model1.weight3)
//                    pnumber3.setText(model1.pnumber3)
//                }
//                productName4.setText(model1.productName4)
//                if (productName4.length() > 0) {
//                    bag4.setText(model1.bag4)
//                    weight4.setText(model1.weight4)
//                    pnumber4.setText(model1.pnumber4)
//                }
//                productName5.setText(model1.productName5)
//                if (productName5.length() > 0) {
//                    bag5.setText(model1.bag5)
//                    weight5.setText(model1.weight5)
//                    pnumber5.setText(model1.pnumber5)
//                }
//                productName6.setText(model1.productName6)
//                if (productName6.length() > 0) {
//                    bag6.setText(model1.bag6)
//                    weight6.setText(model1.weight6)
//                    pnumber6.setText(model1.pnumber6)
//                }
//                productName7.setText(model1.productName7)
//                if (productName7.length() > 0) {
//                    bag7.setText(model1.bag7)
//                    weight7.setText(model1.weight7)
//                    pnumber7.setText(model1.pnumber7)
//                }
//                productName8.setText(model1.productName8)
//                if (productName8.length() > 0) {
//                    bag8.setText(model1.bag8)
//                    weight8.setText(model1.weight8)
//                    pnumber8.setText(model1.pnumber8)
//                }
//                productName9.setText(model1.productName9)
//                if (productName9.length() > 0) {
//                    bag9.setText(model1.bag9)
//                    weight9.setText(model1.weight9)
//                    pnumber9.setText(model1.pnumber9)
//                }
//                productName10.setText(model1.productName10)
//                if (productName10.length() > 0) {
//                    bag10.setText(model1.bag10)
//                    weight10.setText(model1.weight10)
//                    pnumber10.setText(model1.pnumber10)
//                }

                if (rwpost =="null"){
                   // println("thisisnulll"+"nulll")
                    rwpost = "0.0"
                }
                val un1:Double? =rwpost.toDoubleOrNull()
                val un2:Double?=model1.dispatchWeight.toString().toDoubleOrNull()
                val tw:Double?= model1.totalWeight.toString().toDoubleOrNull()

                val un3 :Double?= un1!! + un2!!

                val dw:Double?= tw!!-un3!!

                //println("undisssbtn"+un1+un2+un3+tw+dw)







                val undismap: MutableMap<String, Any> =
                    HashMap()
                undismap["customerName"] = model1.customerName.toString()
                //   undismap.put("customerAddress",customerAddress.getText().toString());
                undismap["productName"] = model1.productName.toString()
                undismap["mobileNo"] = model1.mobileNo.toString()
                undismap["weight"] = model1.weight.toString()
                undismap["bag"] = model1.bag.toString()
                undismap["delAddress"] = model1.delAddress.toString()
                undismap["date"] = model1.date.toString()
                undismap["entry"] = model1.entry.toString()
                undismap["pono"] = model1.pono.toString()
                undismap["deldate"] = model1.deldate.toString()
                undismap["pnumber"] = model1.pnumber.toString().trim { it <= ' ' }
                undismap["totalBag"] = model1.totalBag.toString()
                undismap["totalWeight"] = model1.totalWeight.toString()
                undismap["dateid"] = model1.dateid.toString()
                undismap["remainWeight"] = un3.toString()
                undismap["dispatchWeight"] = dw.toString()

                undismap["notes"] = model1.notes.toString()


                if (model1.productName2.toString().trim{ it <= ' ' } != "null") {
                    undismap["productName2"] = model1.productName2.toString().trim { it <= ' ' }
                    undismap["weight2"] = model1.weight2.toString().trim { it <= ' ' }
                    undismap["bag2"] = model1.bag2.toString().trim { it <= ' ' }
                    undismap["pnumber2"] = model1.pnumber2.toString()
                }
                if (model1.productName3.toString().trim { it <= ' ' } != "null") {
                    undismap["productName3"] = model1.productName3.toString().trim { it <= ' ' }
                    undismap["weight3"] = model1.weight3.toString().trim { it <= ' ' }
                    undismap["bag3"] = model1.bag3.toString().trim { it <= ' ' }
                    undismap["pnumber3"] = model1.pnumber3.toString()
                }
                if (model1.productName4.toString().trim { it <= ' ' } != "null") {
                    undismap["productName4"] = model1.productName4.toString().trim { it <= ' ' }
                    undismap["weight4"] = model1.weight4.toString().trim { it <= ' ' }
                    undismap["bag4"] = model1.bag4.toString().trim { it <= ' ' }
                    undismap["pnumber4"] = model1.pnumber4.toString()
                }
                if (model1.productName5.toString().trim { it <= ' ' } != "null") {
                    undismap["productName5"] = model1.productName5.toString().trim { it <= ' ' }
                    undismap["weight5"] = model1.weight5.toString().trim { it <= ' ' }
                    undismap["bag5"] =model1.bag5.toString().trim { it <= ' ' }
                    undismap["pnumber5"] = model1.pnumber5.toString()
                }
                if (model1.productName6.toString().trim { it <= ' ' } != "null") {
                    undismap["productName6"] = model1.productName6.toString().trim { it <= ' ' }
                    undismap["weight6"] = model1.weight6.toString().trim { it <= ' ' }
                    undismap["bag6"] = model1.bag6.toString().trim { it <= ' ' }
                    undismap["pnumber6"] = model1.pnumber6.toString()
                }
                if (model1.productName7.toString().trim { it <= ' ' } != "null") {
                    undismap["productName7"] = model1.productName7.toString().trim { it <= ' ' }
                    undismap["weight7"] = model1.weight7.toString().trim { it <= ' ' }
                    undismap["bag7"] =model1.bag7.toString().trim { it <= ' ' }
                    undismap["pnumber7"] =model1.pnumber7.toString()
                }
                if (model1.productName8.toString().trim { it <= ' ' } != "null") {
                    undismap["productName8"] = model1.productName8.toString().trim { it <= ' ' }
                    undismap["weight8"] = model1.weight8.toString().trim { it <= ' ' }
                    undismap["bag8"] = model1.bag8.toString().trim { it <= ' ' }
                    undismap["pnumber8"] = model1.pnumber8.toString()
                }
                if (model1.productName9.toString().trim { it <= ' ' } != "null") {
                    undismap["productName9"] = model1.productName9.toString().trim { it <= ' ' }
                    undismap["weight9"] = model1.weight9.toString().trim { it <= ' ' }
                    undismap["bag9"] = model1.bag9.toString().trim { it <= ' ' }
                    undismap["pnumber9"] = model1.pnumber9.toString()
                }
                if (model1.productName10.toString().trim { it <= ' ' } != "null") {
                    undismap["productName10"] = model1.productName10.toString().trim { it <= ' ' }
                    undismap["weight10"] = model1.weight10.toString().trim { it <= ' ' }
                    undismap["bag10"] = model1.bag10.toString().trim { it <= ' ' }
                    undismap["pnumber10"] = model1.pnumber10.toString()
                }
                FirebaseDatabase.getInstance().reference.child("Post")
                    .child(model1.dateid.toString())
                    .updateChildren(undismap)
                    .addOnCompleteListener {
                        //undisdialog.dismiss()
                        unddislog.dismiss()
                    }
                FirebaseDatabase.getInstance().reference.child("DispatchList")
                    .child(getRef(position).key!!)
                    .removeValue()
                    .addOnCompleteListener {
                        val intt = Intent(context1, Dispatched::class.java)
                        context1.startActivity(intt)
                    }
                    .addOnFailureListener { e ->
                        Log.i(
                            "errordeletedialogbog",
                            "onFailure :$e"
                        )
                    }
                Toast.makeText(context1, "Undispatched", Toast.LENGTH_SHORT).show()
            }
            undisno.setOnClickListener {
                val inttty = Intent(context1, Dispatched::class.java)
                context1.startActivity(inttty)
                (context1 as Activity).overridePendingTransition(0, 0)
                inttty.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                unddislog.dismiss()
            }
            unddislog.show()
        }
    }

    private fun createPDFFile(path: String,bodymodel:String ,productmodel:String ,remainmodel:String,holder:DisViewHolder) {

        if (File(path).exists())
            File(path).delete()

        try{
            val document= Document()
            PdfWriter.getInstance(document, FileOutputStream(path))

            document.open()
            document.pageSize = PageSize.A6
            document.addAuthor("PSPL Dispatch List")
            document.addCreator("PSPL")

            val colorAccent = BaseColor(0,153,204,255)
            val headingFontSize = 20.0f
            val valueFontSize = 26.0f

            val fontName0 = BaseFont.createFont("res/font/printfont1.ttf","UTF-8", BaseFont.EMBEDDED)
            val titleStyle0 = Font(fontName0,20.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document,"PSPL Dispatch Details\n", Element.ALIGN_CENTER,titleStyle0)

            val fontName = BaseFont.createFont("res/font/printfont1.ttf","UTF-8", BaseFont.EMBEDDED)
            val titleStyle = Font(fontName,20.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document,bodymodel, Element.ALIGN_LEFT,titleStyle)

            val fontName1 = BaseFont.createFont("res/font/printfont1.ttf","UTF-8", BaseFont.EMBEDDED)
            val titleStyle1 = Font(fontName1,20.0f, Font.NORMAL, BaseColor.BLACK)
            addNewItem(document,productmodel+remainmodel,Element.ALIGN_LEFT,titleStyle1)



            val headingStyle = Font(fontName,headingFontSize, Font.NORMAL,colorAccent)
            /////////
            document.close()
            printPDF(holder)

        } catch (e: Exception){
            Log.e("PSPLERROR ", ""+e.message)
        }

    }

    private fun printPDF(ddholder:DisViewHolder) {
       // val printManager = getSystemService(context1.PRINT_SERVICE) as PrintManager

        val printManager = context1.getSystemService(Context.PRINT_SERVICE) as PrintManager
        try{
            val printAdapter = PdfDocumentAdapter(context1,Common.getAppPath(context1)+"Order_"+ddholder.disentrynumber.text.toString()+".pdf")

            printManager.print("Document",printAdapter, PrintAttributes.Builder().build())

        } catch (e:Exception){
            Log.e("PSPL " ,""+e.message)
        }


    }

    @Throws(DocumentException::class)
    private fun addNewItem(document: Document, text: String, align: Int, style: Font) {

        val chunk:Chunk = Chunk(text,style)
        val p = Paragraph(chunk)
        p.alignment = align
        document.add(p)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DisViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dispost, parent, false)
        return DisViewHolder(view)
    }

    inner class DisViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var disdispatchdate: TextView
        var discustomerName: TextView
        var discustomerAddress: TextView? = null
        var disproductName: TextView
        var disdelAddress: TextView
        var disbag: TextView
        var dismobile: TextView
        var disdate: TextView
        var disweight: TextView
        var disentrynumber: TextView
        var disdrivermobile: TextView
        var dispono: TextView
        var dispononame: TextView
        var disdeldate: TextView
        var distotalW: TextView
        var distotalW1: TextView
        var distotalB: TextView
        var disactualFreight: TextView
        var distransportername: TextView
        var disvehicleno: TextView
        var undispatched: Button
        var disproductName2: TextView
        var disproductName3: TextView
        var disproductName4: TextView
        var disproductName5: TextView
        var disproductName6: TextView
        var disproductName7: TextView
        var disproductName8: TextView
        var disproductName9: TextView
        var disproductName10: TextView
        var disbag2: TextView
        var disbag3: TextView
        var disbag4: TextView
        var disbag6: TextView
        var disbag5: TextView
        var disbag7: TextView
        var disbag8: TextView
        var disbag9: TextView
        var disbag10: TextView
        var disweight2: TextView
        var disweight3: TextView
        var disweight4: TextView
        var disweight5: TextView
        var disweight6: TextView
        var disweight7: TextView
        var disweight8: TextView
        var disweight9: TextView
        var disweight10: TextView
        var dislinelay2: LinearLayout
        var dislinelay3: LinearLayout
        var dislinelay4: LinearLayout
        var dislinelay5: LinearLayout
        var dislinelay6: LinearLayout
        var dislinelay7: LinearLayout
        var dislinelay8: LinearLayout
        var dislinelay9: LinearLayout
        var dislinelay10: LinearLayout
        var sharebtn: ImageView
        var printbtn: ImageView
        var distotalFreight: TextView
        var disadvance: TextView

        var disnotes: TextView

        init {
            discustomerName = itemView.findViewById(R.id.discustomerName)
            disproductName = itemView.findViewById(R.id.disproductName)
            //   discustomerAddress = itemView.findViewById(R.id.discustomerAddress);
            disdelAddress = itemView.findViewById(R.id.disdelAddress)
            dismobile = itemView.findViewById(R.id.dismobileNo)
            disbag = itemView.findViewById(R.id.disbag)
            disdate = itemView.findViewById(R.id.disdate)
            disweight = itemView.findViewById(R.id.disweight)
            disentrynumber = itemView.findViewById(R.id.disentrynumber)
            disdrivermobile = itemView.findViewById(R.id.disdrivermobile)
            dispono = itemView.findViewById(R.id.dispono)
            dispononame = itemView.findViewById(R.id.dispononame)
            disdeldate = itemView.findViewById(R.id.disdeldate)
            distotalB = itemView.findViewById(R.id.distotalB)
            distotalW = itemView.findViewById(R.id.distotalW)
            distotalW1 = itemView.findViewById(R.id.distotalW1)
            distotalFreight = itemView.findViewById(R.id.distotalFreight)
            distransportername = itemView.findViewById(R.id.distransportername)
            disvehicleno = itemView.findViewById(R.id.disvehicleno)
            disactualFreight = itemView.findViewById(R.id.disactualFreight)
            disadvance = itemView.findViewById(R.id.disadvance)
            disnotes = itemView.findViewById(R.id.disnotes)

            disdispatchdate = itemView.findViewById(R.id.disdispatchdate)
            disproductName2 = itemView.findViewById(R.id.disproductName2)
            disproductName3 = itemView.findViewById(R.id.disproductName3)
            disproductName4 = itemView.findViewById(R.id.disproductName4)
            disproductName5 = itemView.findViewById(R.id.disproductName5)
            disproductName6 = itemView.findViewById(R.id.disproductName6)
            disproductName7 = itemView.findViewById(R.id.disproductName7)
            disproductName8 = itemView.findViewById(R.id.disproductName8)
            disproductName9 = itemView.findViewById(R.id.disproductName9)
            disproductName10 = itemView.findViewById(R.id.disproductName10)
            dislinelay2 = itemView.findViewById(R.id.dislinelay2)
            dislinelay3 = itemView.findViewById(R.id.dislinelay3)
            dislinelay4 = itemView.findViewById(R.id.dislinelay4)
            dislinelay5 = itemView.findViewById(R.id.dislinelay5)
            dislinelay6 = itemView.findViewById(R.id.dislinelay6)
            dislinelay7 = itemView.findViewById(R.id.dislinelay7)
            dislinelay8 = itemView.findViewById(R.id.dislinelay8)
            dislinelay9 = itemView.findViewById(R.id.dislinelay9)
            dislinelay10 = itemView.findViewById(R.id.dislinelay10)
            disbag2 = itemView.findViewById(R.id.disbag2)
            disbag3 = itemView.findViewById(R.id.disbag3)
            disbag4 = itemView.findViewById(R.id.disbag4)
            disbag5 = itemView.findViewById(R.id.disbag5)
            disbag6 = itemView.findViewById(R.id.disbag6)
            disbag7 = itemView.findViewById(R.id.disbag7)
            disbag8 = itemView.findViewById(R.id.disbag8)
            disbag9 = itemView.findViewById(R.id.disbag9)
            disbag10 = itemView.findViewById(R.id.disbag10)
            disweight2 = itemView.findViewById(R.id.disweight2)
            disweight3 = itemView.findViewById(R.id.disweight3)
            disweight4 = itemView.findViewById(R.id.disweight4)
            disweight5 = itemView.findViewById(R.id.disweight5)
            disweight6 = itemView.findViewById(R.id.disweight6)
            disweight7 = itemView.findViewById(R.id.disweight7)
            disweight8 = itemView.findViewById(R.id.disweight8)
            disweight9 = itemView.findViewById(R.id.disweight9)
            disweight10 = itemView.findViewById(R.id.disweight10)
            sharebtn = itemView.findViewById(R.id.sharebtn)

            printbtn = itemView.findViewById(R.id.printbtn)
            undispatched = itemView.findViewById(R.id.undisbutton)
        }
    }

}