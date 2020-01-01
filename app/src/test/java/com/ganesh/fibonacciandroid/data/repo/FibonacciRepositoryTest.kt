package com.ganesh.fibonacciandroid.data.repo

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FibonacciRepositoryTest {

    private lateinit var fibonacciUseCase: FibonacciRepositoryImpl

    @Before
    fun initAll() {
        fibonacciUseCase =
            FibonacciRepositoryImpl()
    }

    @Test
    fun generate_validInput_success() {

        runBlocking {
            fibonacciUseCase.generateFibonacciSeries(90)
        }

        runBlocking {
            assertTrue(fibonacciUseCase.getFibonacciList().size == 90)
        }

        runBlocking {
            assertTrue(!fibonacciUseCase.hasReachedEnd())
        }

    }

    /**
     * to ensure 5th item value is 3 in Fibonacci series
     *
     */
    @Test
    fun generate_ItemCountFive_three() {

        runBlocking {
            fibonacciUseCase.clearList()
            fibonacciUseCase.generateFibonacciSeries(5)
        }

        runBlocking {
            assertTrue(fibonacciUseCase.getFibonacciList().size == 5)
            assertTrue(fibonacciUseCase.getFibonacciList()[4].number.toInt() == 3)
        }

    }


    @Test
    fun generate_0_success() {

        runBlocking {
            fibonacciUseCase.clearList()
            fibonacciUseCase.generateFibonacciSeries(0)
        }

        runBlocking {
            assertTrue(fibonacciUseCase.getFibonacciList().isEmpty())
        }

        runBlocking {
            assertTrue(!fibonacciUseCase.hasReachedEnd())
        }

    }

    /**
     * to ensure when count below 0, result should be empty
     *
     */
    @Test
    fun generate_belowZero_success() {

        runBlocking {
            fibonacciUseCase.clearList()
            fibonacciUseCase.generateFibonacciSeries(-1)
        }

        runBlocking {
            assertTrue(fibonacciUseCase.getFibonacciList().isEmpty())
        }

        runBlocking {
            assertTrue(!fibonacciUseCase.hasReachedEnd())
        }

    }

    /**
     * to test it reached end when count becomes more then 93
     *
     */
    @Test
    fun generate_invalid_failure() {

        runBlocking {
            fibonacciUseCase.clearList()
            fibonacciUseCase.generateFibonacciSeries(94)
        }

        runBlocking {
            assertTrue(fibonacciUseCase.hasReachedEnd())
        }

        runBlocking {
            assertTrue(fibonacciUseCase.getFibonacciList().size != 94)
        }

    }

}