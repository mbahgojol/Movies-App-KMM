package com.mbahgojol.data.di

import com.mbahgojol.base.inject.ApplicationScope
import com.mbahgojol.data.MoviesRepository
import com.mbahgojol.data.MoviesRepositoryImpl
import me.tatarka.inject.annotations.Provides

interface DataBinds {
    val MoviesRepositoryImpl.bind: MoviesRepository
        @ApplicationScope @Provides get() = this
}
