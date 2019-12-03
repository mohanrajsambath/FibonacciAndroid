package com.ganesh.fibonacciandroid.data.repo

import com.ganesh.fibonacciandroid.domain.model.FibonacciModel

interface FibonacciRepositoryUseCase {
    suspend fun generateFibonacciSeries(count: Int)
    suspend fun getFibonacciList(): List<FibonacciModel>
    suspend fun hasReachedEnd(): Boolean
    suspend fun clearList()
}