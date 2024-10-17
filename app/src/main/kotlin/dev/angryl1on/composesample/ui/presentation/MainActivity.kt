package dev.angryl1on.composesample.ui.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import dev.angryl1on.composesample.navigation.AppNavigation
import dev.angryl1on.composesample.ui.theme.ComposeSampleTheme
import dev.angryl1on.composesample.ui.theme.LocalDimensions

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            ComposeSampleTheme {
                val dimensions = LocalDimensions.current

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AppNavigation(
                        modifier = Modifier
                            .padding(innerPadding)
                            .padding(dimensions.horizontalMedium)
                    )
                }
            }
        }
    }
}
