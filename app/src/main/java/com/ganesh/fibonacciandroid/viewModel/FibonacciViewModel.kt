package com.ganesh.fibonacciandroid.viewModel

import androidx.lifecycle.MutableLiveData
import com.ganesh.fibonacciandroid.domain.model.FibonacciModel
import com.ganesh.fibonacciandroid.domain.usecases.FibonacciSeriesUseCase
import kotlinx.coroutines.*
import javax.inject.Inject

open class FibonacciViewModel @Inject constructor(private val fibonacciSeriesUsecase: FibonacciSeriesUseCase) :
    BaseViewModel() {

    var fibonacciLiveData: MutableLiveData<List<FibonacciModel>> =
        MutableLiveData()

    private var limit = 30

    fun getFibonacciList() {
        canShowLoading.value = true

        launch {

            val result = withContext(Dispatchers.IO) {
                fibonacciSeriesUsecase.getList(limit)
            }

            handleResult(result)
        }

    }

    internal fun handleResult(result: List<FibonacciModel>) {
        fibonacciLiveData.value = result
        canShowLoading.value = false
    }
}