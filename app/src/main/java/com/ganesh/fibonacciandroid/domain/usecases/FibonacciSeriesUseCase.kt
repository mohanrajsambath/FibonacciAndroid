package com.ganesh.fibonacciandroid.domain.usecases

import com.ganesh.fibonacciandroid.domain.model.FibonacciModel

/**
 * Fibonacci use cases
 * @author GaneshKumar Raja
 * @version 1.0
 * @since 1.0
 * @year 2019
 */
interface FibonacciSeriesUseCase {
    suspend fun getList(limit:Int): List<FibonacciModel>
}