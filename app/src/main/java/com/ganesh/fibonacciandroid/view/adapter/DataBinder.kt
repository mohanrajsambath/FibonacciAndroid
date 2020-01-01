package com.ganesh.fibonacciandroid.view.adapter

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.ganesh.fibonacciandroid.domain.model.FibonacciModel

@BindingAdapter(value = ["number"], requireAll = false)
fun setRattingToRateView(txtView: TextView, model: FibonacciModel?) {

    model?.let {
        txtView.text = StringBuffer("""f(${model.position}) =${model.number}""")
    }
}

@BindingAdapter("visibilities")
fun progressBarVisibilities(progressBar: ProgressBar, status:Boolean){
    if(status){
        progressBar.visibility = View.VISIBLE
    }else{
        progressBar.visibility = View.GONE
    }

}