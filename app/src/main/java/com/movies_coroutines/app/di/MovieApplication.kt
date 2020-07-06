package com.movies_coroutines.app.di

import android.app.Application

open class MovieApplication : Application() {
    val appComponent : AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }
}