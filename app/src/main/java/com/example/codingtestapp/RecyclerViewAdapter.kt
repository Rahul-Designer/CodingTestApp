package com.example.codingtestapp

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter(
    private val context: Context,
    private val arrCarModel: Array<String>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    private var rmPosition: Int? = 0
    private var last: Int? = null
    class ViewHolder(itemView: View, onItemClickListener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        var model : TextView
        var modelBg : LinearLayout
        init {
            model = itemView.findViewById(R.id.car_model)
            modelBg = itemView.findViewById(R.id.card_bg)
            itemView.setOnClickListener {
                onItemClickListener.updateBackground(adapterPosition)
            }
        }
        fun bind(info: String) {
            model.text =info
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recyclerview_item, parent, false),onItemClickListener
        )
    }

    override fun getItemCount(): Int {
        return arrCarModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (rmPosition == position){
            holder.modelBg.setBackgroundColor(Color.parseColor("#6300AC"))
            holder.model.setTextColor(Color.WHITE)
        }
        if (last == position){
            holder.modelBg.setBackgroundResource(R.drawable.model_car)
            holder.model.setTextColor(Color.parseColor("#6300AC"))
        }
        val pos = arrCarModel[position]
        holder.bind(pos)
    }
    fun changeUI(position: Int) {
        this.last = this.rmPosition
        this.rmPosition = position
        last?.let { notifyItemChanged(it) }
        notifyItemChanged(position)
    }
    interface OnItemClickListener {
        fun updateBackground(position: Int)
    }
}