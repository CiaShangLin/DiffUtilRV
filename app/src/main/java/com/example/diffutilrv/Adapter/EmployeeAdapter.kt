package com.example.diffutilrv.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.diffutilrv.Bean.Employee
import com.example.diffutilrv.DiffUtil.EmployeeDiffUtil
import com.example.diffutilrv.ViewHolder.EmployeeViewHolder
import com.example.diffutilrv.MainActivity.MainViewModel
import com.example.diffutilrv.databinding.ListItemBinding
/**
 * ListAdapter是官方幫我們把Adapter和DiffUtil整合起來的Class
 * 如果你能確定資料型別只有一種的話推薦使用,不過他也有些坑,例如:
 * 1.你要清空資料的話要submitList(null)而不是submitList(listOf())
 * 2.如果submitList資料有暫存的話建議用copy的傳送給LiveData再做submitList原因是如果你直接
 * 對這個暫存的list做操作的話那麼接下來做submitList它的DiffUtil判斷會失敗,或者是出現一些意外地閃退
 * 用copy的話就可以確保兩份資料是分離的不會受到Object物件引用的問題,listOf().map{it.copy()}
 */
class EmployeeAdapter(private val mainViewModel: MainViewModel) :
    ListAdapter<Employee, EmployeeViewHolder>(EmployeeDiffUtil) {

    companion object {
        const val EMPLOYEE_VIEW_HOLDER = 100
    }

    override fun getItemViewType(position: Int): Int {
        return EMPLOYEE_VIEW_HOLDER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EmployeeViewHolder(binding, mainViewModel)
    }

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }
}