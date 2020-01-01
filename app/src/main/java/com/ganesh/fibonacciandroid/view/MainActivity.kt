package com.ganesh.fibonacciandroid.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

import com.ganesh.fibonacciandroid.R
import com.ganesh.fibonacciandroid.databinding.ActivityMainBinding
import com.ganesh.fibonacciandroid.view.adapter.ItemsAdapter
import com.ganesh.fibonacciandroid.viewModel.FibonacciViewModel
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


/**
 * main activity to view list of fibonacci numbers
 * @author GaneshKumar Raja
 * @version 1.0
 * @since 1.0
 * @year 2019
 */
import com.ganesh.fibonacciandroid.view.customviews.EndlessRecyclerOnScrollListener


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
        viewModel.getFibonacciList()
        setUpViewModelObserver()
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    /**
     * scrolling of the recyclerview handling
     *
     */
    private fun addScrollListener() {
        binding.recyclerView.addOnScrollListener(object :
            EndlessRecyclerOnScrollListener() {
            override fun onLoadMore() {
                viewModel.getFibonacciList()
            }
        })
    }

    /**
     * set up viewmodel's livedata observer
     *
     */
    private fun setUpViewModelObserver() {

        viewModel.fibonacciLiveData.observe(this, Observer {
            adapter.update(it)
        })

        viewModel.canShowLoading.observe(this, Observer {
            binding.visibilities = it
        })


    }

}
