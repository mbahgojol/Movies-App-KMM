package com.mbahgojol.cleanarchitecture

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import me.tatarka.inject.annotations.Component
import me.tatarka.inject.annotations.Inject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val component = MainActivityComponent::class.create()
        setContent {
            MaterialTheme {
                component.home()
            }
        }
    }
}

typealias Home = @Composable () -> Unit

@Inject
@Composable
fun Home() {
    Text(text = "MbahGojol")
}

@Component
abstract class MainActivityComponent {
    abstract val home: Home
}
