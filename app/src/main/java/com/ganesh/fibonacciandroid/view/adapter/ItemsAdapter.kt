package com.ganesh.fibonacciandroid.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ganesh.fibonacciandroid.R
import com.ganesh.fibonacciandroid.databinding.ItemViewBinding
import com.ganesh.fibonacciandroid.domain.model.FibonacciModel
import javax.inject.Inject


class ItemsAdapter @Inject constructor() : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    private var items: MutableList<FibonacciModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ItemViewHolder(parent)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        if (holder is ItemViewHolder && items.size > position) {
            holder.bind(items[position])
        }

    }

    /**
     * updating data to adapter
     */
    fun update(data: List<FibonacciModel>) {
        val size = this.items.size

        if (size == 0) {
            this.items.addAll(data)
        } else {
            this.items.addAll(this.items.size, data)
        }

        notifyDataSetChanged()
    }


    abstract class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    class ItemViewHolder(
        private val parent: ViewGroup,
        private val binding: ItemViewBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_view,
            parent,
            false
        )
    ) : ViewHolder(binding.root) {

        fun bind(item: FibonacciModel) {
            binding.model = item
        }
    }

}