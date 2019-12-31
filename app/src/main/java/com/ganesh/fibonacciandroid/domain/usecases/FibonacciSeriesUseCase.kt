package com.ganesh.fibonacciandroid.domain.usecases

import com.ganesh.fibonacciandroid.domain.model.FibonacciModel

interface FibonacciSeriesUseCase {
    suspend fun getList(limit:Int): List<FibonacciModel>
}