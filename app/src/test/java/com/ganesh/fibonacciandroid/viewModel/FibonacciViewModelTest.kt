package com.ganesh.fibonacciandroid.viewModel

import com.ganesh.fibonacciandroid.BaseTest
import com.ganesh.fibonacciandroid.domain.usecases.FibonacciSeriesUseCase
import com.ganesh.fibonacciandroid.domain.model.FibonacciModel
import kotlinx.coroutines.runBlocking

import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock

import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class FibonacciViewModelTest : BaseTest() {
    @Mock
    lateinit var domainUseCase: FibonacciSeriesUseCase

    @InjectMocks
    lateinit var viewModel: FibonacciViewModel

    private lateinit var spyViewModel: FibonacciViewModel

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        viewModel = FibonacciViewModel(domainUseCase)
        spyViewModel = spy(viewModel)
    }

    @Test
    fun getFibonacciList_validInput_success() {

        val numberList: MutableList<FibonacciModel> = mutableListOf()


        runBlocking {

            `when`(domainUseCase.getList(30)).thenReturn(
                numberList
            )

            spyViewModel.getFibonacciList()
        }

        verify(spyViewModel, times(1)).handleResult(numberList)

    }


}