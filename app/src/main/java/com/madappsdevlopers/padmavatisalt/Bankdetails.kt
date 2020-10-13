package com.madappsdevlopers.padmavatisalt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.firebase.database.*

class Bankdetails : AppCompatActivity() {

    private var bd: DatabaseReference? = null

    var bankname:TextView?=null
    var bankname2:TextView?=null
    var bankname3:TextView?=null
    var bankname4:TextView?=null

    var branch:TextView?=null
    var branch2:TextView?=null
    var branch3:TextView?=null
    var branch4:TextView?=null

    var account:TextView?=null
    var account2:TextView?=null
    var account3:TextView?=null
    var account4:TextView?=null

    var ifsccode:TextView?=null
    var ifsccode2:TextView?=null
    var ifsccode3:TextView?=null
    var ifsccode4:TextView?=null

    var li2:LinearLayout?=null
    var li3:LinearLayout?=null
    var li4:LinearLayout?=null

    var shareit:ImageView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bankdetails)

        bd = FirebaseDatabase.getInstance().reference.child("bankdetails")

        shareit =findViewById<View>(R.id.shareit) as ImageView

        bankname = findViewById<View>(R.id.bankname) as TextView
        bankname2 = findViewById<View>(R.id.bankname2) as TextView
        bankname3 = findViewById<View>(R.id.bankname3) as TextView
        bankname4 = findViewById<View>(R.id.bankname4) as TextView

        branch = findViewById<View>(R.id.branch) as TextView
        branch2 = findViewById<View>(R.id.branch2) as TextView
        branch3 = findViewById<View>(R.id.branch3) as TextView
        branch4 = findViewById<View>(R.id.branch4) as TextView

        account = findViewById<View>(R.id.account) as TextView
        account2 = findViewById<View>(R.id.account2) as TextView
        account3 = findViewById<View>(R.id.account3) as TextView
        account4 = findViewById<View>(R.id.account4) as TextView

        ifsccode = findViewById<View>(R.id.ifsccode) as TextView
        ifsccode2 = findViewById<View>(R.id.ifsccode2) as TextView
        ifsccode3 = findViewById<View>(R.id.ifsccode3) as TextView
        ifsccode4 = findViewById<View>(R.id.ifsccode4) as TextView

        li2 = findViewById<View>(R.id.li2) as LinearLayout
        li3 = findViewById<View>(R.id.li3) as LinearLayout
        li4 = findViewById<View>(R.id.li4) as LinearLayout



        bd!!.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(datasnapshot: DataSnapshot) {
                val banknameee: String = datasnapshot.child("bankname").value.toString()
                val accountee: String = datasnapshot.child("account").value.toString()
                val ifsccodeee: String = datasnapshot.child("ifsccode").value.toString()
                val branchee: String = datasnapshot.child("branch").value.toString()

                val banknameee2: String = datasnapshot.child("bankname2").value.toString()
                val accountee2: String = datasnapshot.child("account2").value.toString()
                val ifsccodeee2: String = datasnapshot.child("ifsccode2").value.toString()
                val branchee2: String = datasnapshot.child("branch2").value.toString()

                val banknameee3: String = datasnapshot.child("bankname3").value.toString()
                val accountee3: String = datasnapshot.child("account3").value.toString()
                val ifsccodeee3: String = datasnapshot.child("ifsccode3").value.toString()
                val branchee3: String = datasnapshot.child("branch3").value.toString()

                val banknameee4: String = datasnapshot.child("bankname4").value.toString()
                val accountee4: String = datasnapshot.child("account4").value.toString()
                val ifsccodeee4: String = datasnapshot.child("ifsccode4").value.toString()
                val branchee4: String = datasnapshot.child("branch4").value.toString()

                bankname!!.text = banknameee
                account!!.text = accountee
                ifsccode!!.text = ifsccodeee
                branch!!.text = branchee

                bankname2!!.text = banknameee2
                account2!!.text = accountee2
                ifsccode2!!.text = ifsccodeee2
                branch2!!.text = branchee2

                bankname3!!.text = banknameee3
                account3!!.text = accountee3
                ifsccode3!!.text = ifsccodeee3
                branch3!!.text = branchee3

                bankname4!!.text = banknameee4
                account4!!.text = accountee4
                ifsccode4!!.text = ifsccodeee4
                branch4!!.text = branchee4

               // println("linearrrrr" + banknameee2)

                if (banknameee2 != "null") { li2!!.visibility = View.VISIBLE }
                if (banknameee3 != "null") { li3!!.visibility = View.VISIBLE }
                if (banknameee4 != "null") { li4!!.visibility = View.VISIBLE }


            }

            override fun onCancelled(error: DatabaseError) {

            }


        })


        shareit!!.setOnClickListener{
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"

            var m1 = "*"+"PADMAVATI SALT PVT LTD."+"*"+"\n"
        //    var m2 = "\nBRANCH - ANKLESHWAR"+"\n"

            var bn1 = "\n"+bankname!!.text.toString()+"\n"
            var br1 = branch!!.text.toString()+"\n"
            var ac1 = account!!.text.toString()+"\n"
            var ic1 = ifsccode!!.text.toString()+"\n"


            var bn2=""
            var br2=""
            var ac2=""
            var ic2=""
            if (bankname2!!.text.toString() != "null"){
                bn2 = "\n"+bankname2!!.text.toString()+"\n"
                br2 = branch2!!.text.toString()+"\n"
                ac2 = account2!!.text.toString()+"\n"
                ic2 = ifsccode2!!.text.toString()+"\n"
            }

            var bn3=""
            var br3=""
            var ac3=""
            var ic3=""
            if (bankname3!!.text.toString() != "null"){
                bn3 = "\n"+bankname3!!.text.toString()+"\n"
                br3 = branch3!!.text.toString()+"\n"
                ac3 = account3!!.text.toString()+"\n"
                ic3 = ifsccode3!!.text.toString()+"\n"
            }
            var bn4=""
            var br4=""
            var ac4=""
            var ic4=""
            if (bankname4!!.text.toString() != "null"){
                bn4 = "\n"+bankname4!!.text.toString()+"\n"
                br4 = branch4!!.text.toString()+"\n"
                ac4 = account4!!.text.toString()+"\n"
                ic4 = ifsccode4!!.text.toString()+"\n"
            }




            val mainBody = m1+bn1+br1+ac1+ic1+bn2+br2+ac2+ic2+bn3+br3+ac3+ic3+bn4+br4+ac4+ic4
            val subb = "Bank Details"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, subb)
            shareIntent.putExtra(Intent.EXTRA_TEXT, mainBody)
            startActivity(Intent.createChooser(shareIntent, "Share via"))


        }

    }
}
