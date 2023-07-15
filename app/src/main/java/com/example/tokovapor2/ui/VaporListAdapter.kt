package com.example.tokovapor2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tokovapor2.R
import com.example.tokovapor2.model.Vapors


class VaporListAdapter(
    private val onItemClickListener: (Vapors) -> Unit
):ListAdapter<Vapors, VaporListAdapter.VaporsViewHolder>(WORDS_COMPARATOR){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaporsViewHolder {
        return VaporsViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: VaporsViewHolder, position: Int) {
        val vapors = getItem(position)
        holder.bind(vapors)
        holder.itemView.setOnClickListener {
            onItemClickListener(vapors)
        }
    }
    class VaporsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView6)
        private val addressTextView: TextView = itemView.findViewById(R.id.addressTextView7)
        private val goodsTextView: TextView = itemView.findViewById(R.id.goodsTextView8)
        private val typeTextView: TextView = itemView.findViewById(R.id.typeTextView9)
        private val amountgoodsTextView: TextView = itemView.findViewById(R.id.amountgoodsTextView10)

        fun bind(vapors: Vapors?) {
            nameTextView.text = vapors?.name
            addressTextView.text = vapors?.address
            goodsTextView.text = vapors?.goods
            typeTextView.text = vapors?.type
            amountgoodsTextView.text = vapors?.amountgoods
        }

        companion object {
            fun create(parent: ViewGroup): VaporListAdapter.VaporsViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_vapors, parent, false)
                return  VaporsViewHolder(view)
            }
        }

    }

companion object {
    private  val  WORDS_COMPARATOR = object : DiffUtil.ItemCallback<Vapors>() {
        override fun areItemsTheSame(oldItem: Vapors, newItem: Vapors): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Vapors, newItem: Vapors): Boolean {
            return  oldItem.id == newItem.id
        }
    }
}
}

