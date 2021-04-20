package com.example.diffutilrv.Normal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.diffutilrv.databinding.ListItemBinding

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