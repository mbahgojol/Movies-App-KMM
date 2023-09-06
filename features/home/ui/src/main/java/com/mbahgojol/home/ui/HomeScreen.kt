package com.mbahgojol.home.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import com.mbahgojol.data.MoviesRepository
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

@Preview(showBackground = true)
@Composable
private fun Preview() {

}
