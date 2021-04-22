package com.example.diffutilrv.SpecialActivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.GridLayoutManager
import com.example.diffutilrv.Adapter.CommentAdapter
import com.example.diffutilrv.Adapter.EmployeeAdapter
import com.example.diffutilrv.Adapter.FooterAdapter
import com.example.diffutilrv.Adapter.HeaderAdapter
import com.example.diffutilrv.MainActivity.MainViewModel
import com.example.diffutilrv.ViewModelFactory.MainViewModelFactory
import com.example.diffutilrv.databinding.ActivitySpecialBinding

class SpecialActivity : AppCompatActivity() {

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, SpecialActivity::class.java)
            context.startActivity(intent)
        }
    }

    private lateinit var mBinding: ActivitySpecialBinding
    private val mViewModel by lazy {
        ViewModelProvider(this, MainViewModelFactory()).get(
            MainViewModel::class.java
        )
    }
    private val mConcatAdapter by lazy {
        ConcatAdapter(ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build())
    }
    private val mHeaderAdapter by lazy { HeaderAdapter() }
    private val mFooterAdapter by lazy { FooterAdapter() }
    private val mEmployeeAdapter by lazy { EmployeeAdapter(mViewModel) }
    private val mCommentAdapter by lazy { CommentAdapter(mViewModel) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivitySpecialBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        mConcatAdapter.addAdapter(mHeaderAdapter)
        mConcatAdapter.addAdapter(mEmployeeAdapter)
        mConcatAdapter.addAdapter(mCommentAdapter)
        mConcatAdapter.addAdapter(mFooterAdapter)

        mBinding.recyclerView.layoutManager = GridLayoutManager(this, 6).apply {
            this.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return when (mConcatAdapter.getItemViewType(position)) {
                        HeaderAdapter.HEADER -> 6
                        FooterAdapter.FOOTER -> 6
                        EmployeeAdapter.EMPLOYEE_VIEW_HOLDER -> 3
                        CommentAdapter.COMMENT_VIEW_HOLDER -> 2
                        else -> 6
                    }
                }
            }
        }
        mBinding.recyclerView.adapter = mConcatAdapter

        mViewModel.getEmployeeLiveData().observe(this, Observer {
            mEmployeeAdapter.submitList(it)
        })

        mViewModel.getCommentPostIdApi(1)
        mViewModel.getCommentLiveData().observe(this, Observer {
            mCommentAdapter.submitList(it)
        })
    }
}