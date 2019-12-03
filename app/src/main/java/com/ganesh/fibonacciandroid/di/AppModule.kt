package com.ganesh.fibonacciandroid.di

import com.ganesh.fibonacciandroid.data.repo.FibonacciRepository
import com.ganesh.fibonacciandroid.data.repo.FibonacciRepositoryUseCase
import com.ganesh.fibonacciandroid.domain.FibonacciSeriesInteractor
import com.ganesh.fibonacciandroid.domain.FibonacciSeriesUseCase
import com.ganesh.fibonacciandroid.view.adapter.ItemsAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class AppModule {


    @Singleton
    @Provides
    fun getRepo(): FibonacciRepositoryUseCase {
        return FibonacciRepository()
    }

    @Singleton
    @Provides
    fun provideUse(use: FibonacciRepositoryUseCase): FibonacciSeriesUseCase {
        return FibonacciSeriesInteractor(use)
    }

    @Singleton
    @Provides
    fun provideAdapter(): ItemsAdapter {
        return ItemsAdapter()
    }

}
