package com.ganesh.fibonacciandroid.di

import com.ganesh.fibonacciandroid.data.repo.FibonacciRepositoryImpl
import com.ganesh.fibonacciandroid.domain.usecases.FibonacciSeriesInteractor
import com.ganesh.fibonacciandroid.domain.usecases.FibonacciSeriesUseCase
import com.ganesh.fibonacciandroid.view.adapter.ItemsAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class AppModule {


    @Singleton
    @Provides
    fun getRepo(): FibonacciRepositoryImpl {
        return FibonacciRepositoryImpl()
    }

    @Singleton
    @Provides
    fun provideUse(use: FibonacciRepositoryImpl): FibonacciSeriesUseCase {
        return FibonacciSeriesInteractor(
            use
        )
    }

    @Singleton
    @Provides
    fun provideAdapter(): ItemsAdapter {
        return ItemsAdapter()
    }

}
