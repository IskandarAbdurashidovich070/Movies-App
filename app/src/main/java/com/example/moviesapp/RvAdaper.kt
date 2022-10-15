package com.example.moviesapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesapp.Models.User
import com.example.moviesapp.databinding.ItemRvBinding

class RvAdaper (var rvClick: RvClick, var list: List<User>) : RecyclerView.Adapter<RvAdaper.VH>() {
    inner class VH(var itemRv: ItemRvBinding) : RecyclerView.ViewHolder(itemRv.root) {
        fun onBind(user: User,position: Int) {
            itemRv.name.text = user.name
            itemRv.authors.text = user.authors
            itemRv.date.text = user.date

            itemRv.btnDelete.setOnClickListener {
                rvClick.itemClick(user)
            }
            itemRv.card.setOnClickListener {
             rvClick.clickCard(position)
            }
            itemRv.btnEdit.setOnClickListener {
             rvClick.editClick(position)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int = list.size

    interface RvClick {
        fun itemClick(user: User)
        fun clickCard(position: Int)
        fun editClick(position: Int)
    }
}