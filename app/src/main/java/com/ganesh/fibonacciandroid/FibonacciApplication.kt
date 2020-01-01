package com.ganesh.fibonacciandroid

import android.app.Activity
import android.app.Application

import com.ganesh.fibonacciandroid.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Fibonacci Application
 * @author GaneshKumar Raja
 * @version 1.0
 * @since 1.0
 * @year 2019
 */
class FibonacciApplication : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }

    override fun activityInjector() = dispatchingAndroidInjector

}