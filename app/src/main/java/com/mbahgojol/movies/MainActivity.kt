package com.mbahgojol.movies

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.mbahgojol.base.inject.ActivityScope
import com.mbahgojol.data.MoviesRepository
import com.mbahgojol.movies.di.ActivityComponent
import com.mbahgojol.movies.di.AndroidApplicationComponent
import kotlinx.coroutines.launch
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Inject
import me.tatarka.inject.annotations.Provides

class MainActivity : ComponentActivity() {

    lateinit var repository: MoviesRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = MainActivityComponent::class.create(this)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    component.home(component.repo)
                }
            }
        }
    }
}

typealias Home = @Composable (MoviesRepository) -> Unit

@Inject
@Composable
fun Home(repository: MoviesRepository) {
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

@ActivityScope
@Component
abstract class MainActivityComponent(
    @get:Provides override val activity: Activity,
    @Component val applicationComponent: AndroidApplicationComponent = AndroidApplicationComponent.from(
        activity,
    ),
) : ActivityComponent {
    abstract val repo: MoviesRepository
    abstract val home: Home
}
