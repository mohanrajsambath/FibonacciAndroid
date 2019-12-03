package com.ganesh.fibonacciandroid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.ganesh.endlessrecyclerview.EndlessRecyclerOnScrollListener
import com.ganesh.fibonacciandroid.R
import com.ganesh.fibonacciandroid.databinding.ActivityMainBinding
import com.ganesh.fibonacciandroid.view.adapter.ItemsAdapter
import com.ganesh.fibonacciandroid.viewModel.FibonacciViewModel
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import android.view.View


class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    @Inject
    lateinit var adapter: ItemsAdapter
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>
    private lateinit var viewModel: FibonacciViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel =
            ViewModelProviders
                .of(this, viewModelFactory)
                .get(FibonacciViewModel::class.java)

        addScrollListener()

        binding.adapter = adapter

        setUpViewModelObserver()
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    private fun addScrollListener() {
        binding.recyclerView.addOnScrollListener(object :
            EndlessRecyclerOnScrollListener() {
            override fun onLoadMore() {
                viewModel.getFibonacciList()
            }
        })
    }


    private fun setUpViewModelObserver() {

        viewModel.fibonacciLiveData.observe(this, Observer {
            if (it.isNotEmpty()) {
                adapter.update(it)
            }
        })

        viewModel.canShowLoading.observe(this, Observer {
            if (it) {
                binding.itemProgressBar.visibility = View.VISIBLE
            } else {
                binding.itemProgressBar.visibility = View.GONE
            }
        })

        viewModel.getFibonacciList()

    }

}
