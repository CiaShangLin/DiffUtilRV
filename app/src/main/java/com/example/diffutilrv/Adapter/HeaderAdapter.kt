package com.example.diffutilrv.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilrv.ViewHolder.HeaderViewHolder
import com.example.diffutilrv.databinding.ItemHeaderViewHolderBinding

class HeaderAdapter : RecyclerView.Adapter<HeaderViewHolder>() {

    companion object {
        const val HEADER = 200
    }

    override fun getItemCount(): Int = 1
    override fun getItemViewType(position: Int): Int = HEADER

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeaderViewHolder {
        val binding = ItemHeaderViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeaderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeaderViewHolder, position: Int) {

    }


}