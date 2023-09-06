package com.mbahgojol.movies

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.mbahgojol.base.inject.ActivityScope
import com.mbahgojol.data.MoviesRepository
import com.mbahgojol.home.ui.HomeScreen
import com.mbahgojol.movies.di.ActivityComponent
import com.mbahgojol.movies.di.AndroidApplicationComponent
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Provides

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = MainActivityComponent::class.create(this)
        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    component.homeScreen(component.repo)
                }
            }
        }
    }
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
    abstract val homeScreen: HomeScreen
}
