package com.example.task


import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val info: ImageView = findViewById(R.id.info)
        info.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("About Reward Title")
            builder.setMessage("100 reward points = 1 putatoe credit\n1 putatoe credit = 1 rupee\nCan be redeemed to your bank account on amount above Rs. 10,000")
            builder.setPositiveButton("Ok") { dialog, _ ->
                dialog.cancel()
            }
            val alertDialog: AlertDialog = builder.create()
            alertDialog.show()
        }

        val add_money : CardView = findViewById(R.id.add_money)
        val dialog = Dialog(this@MainActivity)

        add_money.setOnClickListener {
            dialog.setContentView(R.layout.add_dialog)
            dialog.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.setCancelable(true)
            dialog.show()
        }

        val reward : CardView = findViewById(R.id.reward)
        val dialog2 = Dialog(this@MainActivity)

        reward.setOnClickListener {
            dialog2.setContentView(R.layout.reward_dialog)
            dialog2.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog2.setCancelable(true)
            dialog2.show()
        }

        val bank :CardView = findViewById(R.id.bank)
        val dialog3 = Dialog(this@MainActivity)

        bank.setOnClickListener {
            dialog3.setContentView(R.layout.bank_dialog)
            dialog3.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog3.setCancelable(true)
            dialog3.show()
        }

        val recyclerview = findViewById<RecyclerView>(R.id.RecyclerView)
        recyclerview.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ItemsViewModel>()

        data.add(ItemsViewModel("Fri, 03 May,2023", "03:45:34","₹ 100","sfhsDH14"))
        data.add(ItemsViewModel("Tue, 08 April,2023", "01:30:20","₹ 120","edgsDG32"))
        data.add(ItemsViewModel("Wed, 23 March,2022", "00:50:30","₹ 80","fshoXG52"))
        data.add(ItemsViewModel("Tue, 15 Feb,2023", "10:34:48","₹ 200","htufKG50"))
        data.add(ItemsViewModel("Tue, 22 Jan,2023", "11:21:09","₹ 160","gjogGW89"))



        val adapter = TxnAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter





    }
}