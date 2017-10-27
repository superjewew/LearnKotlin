package com.proandroiddev.normanlie.learnkotlin

import android.arch.lifecycle.LifecycleActivity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.proandroiddev.normanlie.learnkotlin.databinding.ActivityMainBinding

class MainActivity : LifecycleActivity(), RepositoryRecyclerViewAdapter.OnItemClickListener {

    lateinit var binding : ActivityMainBinding
    private val repositoryRecyclerViewAdapter = RepositoryRecyclerViewAdapter(arrayListOf(), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.viewModel = viewModel
        binding.executePendingBindings()

        binding.repositoryRv.layoutManager = LinearLayoutManager(this)
        binding.repositoryRv.adapter = repositoryRecyclerViewAdapter
        viewModel.repositories.observe(this,
                Observer<ArrayList<Repository>> { it?.let{ repositoryRecyclerViewAdapter.replaceData(it)} })
    }

    override fun onItemClick(position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
