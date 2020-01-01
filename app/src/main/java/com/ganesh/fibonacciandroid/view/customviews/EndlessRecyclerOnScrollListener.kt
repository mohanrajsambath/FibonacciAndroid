package com.ganesh.fibonacciandroid.view.customviews

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * endless scrolling
 * @author GaneshKumar Raja
 * @version 1.0
 * @since 1.0
 * @year 2019
 */
abstract class EndlessRecyclerOnScrollListener : RecyclerView.OnScrollListener() {


    /**
     * The total number of items in the dataset after the last load
     */
    private var mPreviousTotal = 0
    /**
     * True if we are still waiting for the last set of data to load.
     */
    private var mLoading = true

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)

        val visibleItemCount = recyclerView.childCount
        var totalItemCount = 0
        var firstVisibleItem = 0

        recyclerView.layoutManager?.let {
            totalItemCount = it.itemCount
            firstVisibleItem = (it as LinearLayoutManager).findFirstVisibleItemPosition()
        }

        if (mLoading) if (totalItemCount > mPreviousTotal) {
            mLoading = false
            mPreviousTotal = totalItemCount
        }

        val visibleThreshold = 5

        if (!mLoading && totalItemCount - visibleItemCount <= firstVisibleItem + visibleThreshold) {
            // End has been reached
            onLoadMore()
            mLoading = true
        }
    }

    abstract fun onLoadMore()
}