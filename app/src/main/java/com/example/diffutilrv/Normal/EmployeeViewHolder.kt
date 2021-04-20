package com.example.diffutilrv.Normal

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.diffutilrv.databinding.ListItemBinding

/**
 * 如果需要繼承且有不同的xml,那個傳入的mBinding的型別要設置成ViewBinding
 * 宣告相同的元件建議預設為Null,例如:
 * private val tvCount:TextView? = binding.root.findViewById(R.id.tvCount)
 */
class EmployeeViewHolder(
    private val mBinding: ListItemBinding,
    private val mainViewModel: MainViewModel
) : RecyclerView.ViewHolder(mBinding.root) {

    protected var mEmployeeData: Employee? = null

    init {
        itemView.setOnClickListener { view ->
            mEmployeeData?.let {
                mainViewModel.viewHolderOnClick(it.toString())
            }
        }
    }

    fun bind(data: Employee) {
        mEmployeeData = data
        mBinding.employeeName.text = data.name
        mBinding.employeeRole.text = data.role
    }

    //這個模式可繼承覆寫
    protected open fun setEmployeeName() {
        mEmployeeData?.let {
            mBinding.employeeName.text = it.name
        }
    }

    //這個模式可繼承覆寫
    protected open fun setEmployeeRole() {
        mEmployeeData?.let {
            mBinding.employeeRole.text = it.role
        }
    }
}