package com.example.diffutilrv.DiffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.diffutilrv.Bean.CommentBeanItem
import com.example.diffutilrv.Bean.Employee

object CommentBeanDiffUtil: DiffUtil.ItemCallback<CommentBeanItem>() {
    override fun areItemsTheSame(oldItem: CommentBeanItem, newItem: CommentBeanItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CommentBeanItem, newItem: CommentBeanItem): Boolean {
        return oldItem.id == newItem.id
    }
}