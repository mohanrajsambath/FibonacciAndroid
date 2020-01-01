package com.ganesh.fibonacciandroid.data.repo

import com.ganesh.fibonacciandroid.domain.model.FibonacciModel
import com.ganesh.fibonacciandroid.domain.repository.FibonacciRepository

/**
 * Fibonacci number generator
 * @author GaneshKumar Raja
 * @version 1.0
 * @since 1.0
 * @year 2019
 */
class FibonacciRepositoryImpl :
    FibonacciRepository {

    private var position = 0
    private var firstNumber: Long = -1
    private var secondNumber: Long = 1
    private var fibonacciNumberList = mutableListOf<FibonacciModel>()
    private var isReachedEnd = false

    override suspend fun getFibonacciList(): List<FibonacciModel> {
        return fibonacciNumberList
    }

    override suspend fun hasReachedEnd(): Boolean {
        return isReachedEnd
    }

    override suspend fun clearList() {
        fibonacciNumberList.clear()
    }

    /**
     * calculating numbers in recursive manner
     */
    override suspend fun generateFibonacciSeries(count: Int) {

        if (count > 0) {
            val result = firstNumber + secondNumber
            firstNumber = secondNumber
            secondNumber = result

            if (result < 0) {
                // if result reaches MAX_LONG
                isReachedEnd = true
                // call this method
                generateFibonacciSeries(0)
            } else {
                // creating FibonacciModel object and add it into the list
                fibonacciNumberList.add(
                    FibonacciModel(result.toString(), position++))
                // call this method
                generateFibonacciSeries(count - 1)
            }

        }

    }

}

