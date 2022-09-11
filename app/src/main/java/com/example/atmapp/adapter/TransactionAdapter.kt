package com.example.atmapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.atmapp.R
import com.example.atmapp.databinding.RowTransactionItemBinding
import com.example.atmapp.model.AtmTransactionHistory

class TransactionAdapter(val list: MutableList<AtmTransactionHistory>) : RecyclerView.Adapter<TransactionAdapter.MyViewHolder>()
{
    private lateinit var listRowBinding: RowTransactionItemBinding
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(model:AtmTransactionHistory){
            listRowBinding.model=model
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        listRowBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.row_transaction_item,
            parent,
            false
        )
        return MyViewHolder(listRowBinding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
       return list.size
    }

}
