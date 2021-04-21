package com.example.diffutilrv.MainActivity

import com.example.diffutilrv.ApiService.ApiServiceManager
import com.example.diffutilrv.Bean.CommentBeanItem
import com.example.diffutilrv.Bean.Employee
import io.reactivex.rxjava3.core.Observable

class MainRepository {

    fun getEmployeeList(): List<Employee> {
        val employees: MutableList<Employee> = mutableListOf()
        employees.add(Employee(1, "Employee 1", "Developer"))
        employees.add(Employee(2, "Employee 2", "Tester"))
        employees.add(Employee(3, "Employee 3", "Support"))
        employees.add(Employee(4, "Employee 4", "Sales Manager"))
        employees.add(Employee(5, "Employee 5", "Manager"))
        employees.add(Employee(6, "Employee 6", "Team lead"))
        employees.add(Employee(7, "Employee 7", "Scrum Master"))
        employees.add(Employee(8, "Employee 8", "Sr. Tester"))
        employees.add(Employee(9, "Employee 9", "Sr. Developer"))
        return employees
    }

    fun getEmployeeListSortedByName(): List<Employee> = getEmployeeList().sortedByDescending { it.name }

    fun getEmployeeListSortedByRole(): List<Employee> = getEmployeeList().sortedBy { it.role }


    fun getCommentPostIdApi(postId: Int): Observable<List<CommentBeanItem>> {
        val url = "https://jsonplaceholder.typicode.com/comments?postId=${postId}"
        return ApiServiceManager.apiService.getCommentsPostId(url)
    }
}
