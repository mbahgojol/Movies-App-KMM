package com.mbahgojol.data

interface MoviesRepository {
    suspend fun getMovies(): String
}
