package com.ganesh.fibonacciandroid.domain.repository

import com.ganesh.fibonacciandroid.domain.model.FibonacciModel

interface FibonacciRepository {
    suspend fun generateFibonacciSeries(count: Int)
    suspend fun getFibonacciList(): List<FibonacciModel>
    suspend fun hasReachedEnd(): Boolean
    suspend fun clearList()
}