package com.mbahgojol.dashboard

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.mbahgojol.movies.MoviesRepository
import kotlinx.coroutines.launch
import me.tatarka.inject.annotations.Inject

typealias HomeScreen = @Composable (MoviesRepository) -> Unit

@Inject
@Composable
fun HomeScreen(repository: MoviesRepository) {
    val scope = rememberCoroutineScope()
    var text by remember { mutableStateOf("Loading") }
    LaunchedEffect(true) {
        scope.launch {
            text = try {
                repository.getMovies()
            } catch (e: Exception) {
                e.localizedMessage ?: "error"
            }
        }
    }
    Text(text = text)
}
