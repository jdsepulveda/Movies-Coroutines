package com.movies_coroutines.app.di

import com.movies_coroutines.BuildConfig
import com.movies_coroutines.remote.api.MoviesService
import com.movies_coroutines.source.RemoteDataSource
import com.movies_coroutines.source.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module(includes = [RemoteSourceModule.Binders::class])
class RemoteSourceModule {

    @Module
    interface Binders {
        @Binds
        fun bindRemoteDataSource(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
    }

    @Provides
    fun providesMoviesService(retrofit: Retrofit): MoviesService = retrofit.create(MoviesService::class.java)

    @Provides
    fun providesRetrofit(): Retrofit =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
}