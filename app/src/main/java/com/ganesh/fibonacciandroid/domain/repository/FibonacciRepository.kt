package com.ganesh.fibonacciandroid.domain.repository

import com.ganesh.fibonacciandroid.domain.model.FibonacciModel
/**
 * repository interface
 * @author GaneshKumar Raja
 * @version 1.0
 * @since 1.0
 * @year 2019
 */
interface FibonacciRepository {
    suspend fun generateFibonacciSeries(count: Int)
    suspend fun getFibonacciList(): List<FibonacciModel>
    suspend fun hasReachedEnd(): Boolean
    suspend fun clearList()
}