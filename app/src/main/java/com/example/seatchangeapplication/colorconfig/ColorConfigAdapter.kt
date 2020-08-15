package com.example.seatchangeapplication.colorconfig

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seatchangeapplication.databinding.ItemColorConfigBinding

class ColorConfigAdapter(
    val list: List<ColorConfigModel>,
    val context: Context
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(context)
        return ColorConfigViewHolder(ItemColorConfigBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ColorConfigViewHolder -> {
                val info = list[position]
                holder.binding.projectName.text = info.projectName
                holder.binding.executePendingBindings()
            }
        }
    }
}