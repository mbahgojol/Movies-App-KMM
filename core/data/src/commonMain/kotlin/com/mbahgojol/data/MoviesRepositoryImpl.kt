package com.mbahgojol.data

import io.ktor.client.HttpClient
import io.ktor.client.request.bearerAuth
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import me.tatarka.inject.annotations.Inject

@Inject
class MoviesRepositoryImpl : MoviesRepository {
    private val client = HttpClient()
    override suspend fun getMovies(): String {
        val response = client.get(
            "https://api.themoviedb.org/3/movie/popular?language=en-US&page=1",
        ) {
            bearerAuth("eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI4MWQ1NmJjMWU5NGI3YTc1MzMzMTJkM2NhYzE5YWM1YyIsInN1YiI6IjU5N2MzNDNkYzNhMzY4MTdlZjAwYTk0ZCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.YkZ9xzq15IGAnST7b5x1w1Ndsvb8T6C8CeBC2EzzUhA")
        }
        return response.bodyAsText()
    }
}
