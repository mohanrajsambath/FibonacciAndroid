package com.ganesh.fibonacciandroid.domain

import com.ganesh.fibonacciandroid.data.repo.FibonacciRepositoryUseCase
import com.ganesh.fibonacciandroid.domain.model.FibonacciModel
import javax.inject.Inject

class FibonacciSeriesInteractor @Inject constructor(private val fibonacciSeriesUsecase: FibonacciRepositoryUseCase) :
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