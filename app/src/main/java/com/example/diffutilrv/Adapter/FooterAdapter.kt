package com.example.diffutilrv.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilrv.ViewHolder.FooterViewHolder
import com.example.diffutilrv.ViewHolder.HeaderViewHolder
import com.example.diffutilrv.databinding.ItemFooterViewHolderBinding
import com.example.diffutilrv.databinding.ItemHeaderViewHolderBinding

class FooterAdapter : RecyclerView.Adapter<FooterViewHolder>() {

    companion object {
        const val FOOTER = 300
    }

    override fun getItemCount(): Int = 1
    override fun getItemViewType(position: Int): Int = FOOTER

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FooterViewHolder {
        val binding = ItemFooterViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FooterViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FooterViewHolder, position: Int) {

    }


}