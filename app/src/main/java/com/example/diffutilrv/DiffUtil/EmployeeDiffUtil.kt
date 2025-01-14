package com.example.diffutilrv.DiffUtil

import androidx.recyclerview.widget.DiffUtil
import com.example.diffutilrv.Bean.Employee

object EmployeeDiffUtil : DiffUtil.ItemCallback<Employee>() {
    override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
        return oldItem.id == newItem.id
    }
}