package com.example.task

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TxnAdapter(private val list: List<ItemsViewModel>) : RecyclerView.Adapter<TxnAdapter.ViewHolder>() {
    class ViewHolder(Txn : View): RecyclerView.ViewHolder(Txn) {

        val dayDate : TextView = Txn.findViewById(R.id.dayDate)
        val time : TextView = Txn.findViewById(R.id.time)
        val amount : TextView = Txn.findViewById(R.id.am)
        val id : TextView = Txn.findViewById(R.id.id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.transaction, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemsViewModel = list[position]

        // sets the text to the textview from our itemHolder class
        holder.dayDate.text = ItemsViewModel.dayDate
        holder.time.text = ItemsViewModel.time
        holder.amount.text = ItemsViewModel.amount
        holder.id.text = ItemsViewModel.id

    }

    override fun getItemCount(): Int {
        return list.size
    }
}