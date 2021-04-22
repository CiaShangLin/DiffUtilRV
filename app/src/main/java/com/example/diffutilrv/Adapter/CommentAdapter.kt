package com.example.diffutilrv.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.diffutilrv.Bean.CommentBeanItem
import com.example.diffutilrv.DiffUtil.CommentBeanDiffUtil
import com.example.diffutilrv.MainActivity.MainViewModel
import com.example.diffutilrv.ViewHolder.CommentViewHolder
import com.example.diffutilrv.databinding.ItemCommentViewHolderBinding

class CommentAdapter(private val mainViewModel: MainViewModel) :
    ListAdapter<CommentBeanItem, CommentViewHolder>(CommentBeanDiffUtil) {

    companion object {
        const val COMMENT_VIEW_HOLDER = 400
    }

    override fun getItemViewType(position: Int): Int = COMMENT_VIEW_HOLDER

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val binding =
            ItemCommentViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentViewHolder(binding, mainViewModel)
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

}