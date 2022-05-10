package com.binar.mvvmnews.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.binar.mvvmnews.R
import com.binar.mvvmnews.adapter.RvAdapter
import com.binar.mvvmnews.viewmodel.ViewModelNews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var newsAdapter : RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_film.layoutManager = LinearLayoutManager(this)
        rv_film.adapter = newsAdapter

        initViewModel()
    }

    fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)
        viewModel.getLiveDataNews2().observe(this, {
            if (it != null){
                newsAdapter.setNewsList(it)
                newsAdapter.notifyDataSetChanged()
            }
        })
        viewModel.getDataNews()
    }
}