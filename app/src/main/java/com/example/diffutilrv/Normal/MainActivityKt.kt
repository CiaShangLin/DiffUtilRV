package com.example.diffutilrv.Normal

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.diffutilrv.DummyEmployeeDataUtils
import com.example.diffutilrv.R
import com.example.diffutilrv.databinding.ActivityMainKtBinding

class MainActivityKt : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainKtBinding
    private val mMainViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory()).get(
            MainViewModel::class.java
        )
    }
    private val mEmployeeAdapter by lazy { EmployeeAdapter(mMainViewModel) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainKtBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        mBinding.recyclerView.layoutManager = LinearLayoutManager(this)
        mBinding.recyclerView.adapter = mEmployeeAdapter
        mMainViewModel.getEmployeeLiveData().observe(this,
            Observer<List<Employee>> {
                mEmployeeAdapter.submitList(it) {
                    Log.d("DEBUG", "加載完成 這個Callback可加可不加")
                }
            })

        mMainViewModel.getOnClickLiveData().observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.sort_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.sort_by_name -> {
                mMainViewModel.updateEmployeeListItemsByName()
                return true
            }
            R.id.sort_by_role -> {
                mMainViewModel.updateEmployeeListItemsByRole()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}