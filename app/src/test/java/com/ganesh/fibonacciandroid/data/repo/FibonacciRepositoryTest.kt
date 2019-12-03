package com.ganesh.fibonacciandroid.data.repo

import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class FibonacciRepositoryTest {

    private lateinit var fibonacciUseCase: FibonacciRepositoryUseCase

    @Before
    fun initAll() {
        fibonacciUseCase = FibonacciRepository()
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

    @Test
    fun generate_ItemNoFive_three() {

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

    @Test
    fun generate_invalid_failure() {

        runBlocking {
            fibonacciUseCase.clearList()
            fibonacciUseCase.generateFibonacciSeries(200)
        }

        runBlocking {
            assertTrue(fibonacciUseCase.hasReachedEnd())
        }

        runBlocking {
            assertTrue(fibonacciUseCase.getFibonacciList().size != 200)
        }


    }

}