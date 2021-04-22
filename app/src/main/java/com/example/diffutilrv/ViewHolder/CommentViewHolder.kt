package com.example.diffutilrv.ViewHolder

import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilrv.Bean.CommentBeanItem
import com.example.diffutilrv.MainActivity.MainViewModel
import com.example.diffutilrv.databinding.ItemCommentViewHolderBinding

class CommentViewHolder(
    private val mBinding: ItemCommentViewHolderBinding,
    private val mainViewModel: MainViewModel
) : RecyclerView.ViewHolder(mBinding.root) {

    fun bind(commentBeanItem: CommentBeanItem) {
        mBinding.tvId.text = commentBeanItem.id.toString()
        mBinding.tvName.text = commentBeanItem.name
    }
}