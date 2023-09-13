package com.mbahgojol.movies

interface MoviesRepository {
    suspend fun getMovies(): String
}
