package com.ganesh.fibonacciandroid.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ganesh.fibonacciandroid.domain.model.FibonacciModel
import com.ganesh.fibonacciandroid.domain.usecases.FibonacciSeriesUseCase
import kotlinx.coroutines.*
import javax.inject.Inject
/**
 * to fetch fibinacci numbers from domain layer and send it to views
 * @author GaneshKumar Raja
 * @version 1.0
 * @since 1.0
 * @year 2019
 */
open
class FibonacciViewModel @Inject constructor(private val fibonacciSeriesUsecase: FibonacciSeriesUseCase) :
    BaseViewModel() {

    var fibonacciLiveData: MutableLiveData<List<FibonacciModel>> =
        MutableLiveData()

    private var limit = 30

    fun getFibonacciList() {
        canShowLoading.value = true

        viewModelScope.launch {
            handleResult(fibonacciSeriesUsecase.getList(limit))
        }
    }

    internal fun handleResult(result: List<FibonacciModel>) {

        if(!result.isNullOrEmpty()) {
            fibonacciLiveData.value = result
        }

        canShowLoading.value = false
    }
}