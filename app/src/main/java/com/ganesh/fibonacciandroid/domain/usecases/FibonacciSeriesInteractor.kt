package com.ganesh.fibonacciandroid.domain.usecases

import com.ganesh.fibonacciandroid.data.repo.FibonacciRepositoryImpl
import com.ganesh.fibonacciandroid.domain.model.FibonacciModel
import javax.inject.Inject

/**
 * Fibonacci use cases implementation
 * @author GaneshKumar Raja
 * @version 1.0
 * @since 1.0
 * @year 2019
 */
class FibonacciSeriesInteractor @Inject constructor(private val fibonacciSeriesUsecase: FibonacciRepositoryImpl) :
    FibonacciSeriesUseCase {

    override suspend fun getList(limit: Int): List<FibonacciModel> {
        //to clear all the values in repo
        fibonacciSeriesUsecase.clearList()

        // to ensure it is not reached end
        if (fibonacciSeriesUsecase.hasReachedEnd()) {
            return listOf()
        }

        // generatin the numbers
        fibonacciSeriesUsecase.generateFibonacciSeries(limit)
        //return the calculated values
        return fibonacciSeriesUsecase.getFibonacciList()
    }

}