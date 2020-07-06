package com.movies_coroutines.app.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.movies_coroutines.app.viewmodels.FragmentLatestMoviesVM
import com.movies_coroutines.app.viewmodels.FragmentPopularMoviesVM
import com.movies_coroutines.app.viewmodels.factory.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class PresentationModule {

    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FragmentPopularMoviesVM::class)
    abstract fun bindsFragmentPopularMoviesVM(fragmentPopularMoviesVM: FragmentPopularMoviesVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FragmentLatestMoviesVM::class)
    abstract fun bindsFragmentLatestMoviesVM(fragmentLatestMoviesVM: FragmentLatestMoviesVM): ViewModel
}