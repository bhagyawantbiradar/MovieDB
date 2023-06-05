package com.bhagyawant.moviedb.di

import android.content.Context
import com.bhagyawant.moviedb.data.mock.GetMoviesListRepositoryMockImpl
import com.bhagyawant.moviedb.domain.GetMoviesListUseCase
import com.bhagyawant.moviedb.domain.repository.GetMoviesListRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideGsonObject() : Gson{
        return Gson()
    }


    @Provides
    @Singleton
    fun provideGetMoviesListUseCase(getMoviesListRepository: GetMoviesListRepository) : GetMoviesListUseCase{
        return GetMoviesListUseCase(getMoviesListRepository)
    }

    @Provides
    @Singleton
    fun provideGetMoviesListRepositoryMock(@ApplicationContext context: Context, gson: Gson): GetMoviesListRepository {
        return GetMoviesListRepositoryMockImpl(context, gson)
    }
}