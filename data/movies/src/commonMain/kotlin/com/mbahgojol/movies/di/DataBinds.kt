package com.mbahgojol.movies.di

import com.mbahgojol.base.inject.ApplicationScope
import com.mbahgojol.movies.MoviesRepository
import com.mbahgojol.movies.MoviesRepositoryImpl
import me.tatarka.inject.annotations.Provides

interface DataBinds {
    val MoviesRepositoryImpl.bind: MoviesRepository
        @ApplicationScope @Provides get() = this
}
