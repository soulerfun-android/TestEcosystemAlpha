package com.example.testecosystemalpha.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.testecosystemalpha.presentation.ui.theme.TestEcosystemAlphaTheme
import com.example.testecosystemalpha.presentation.ui.screens.MainScreen
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val component by lazy {
        (application as App).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            TestEcosystemAlphaTheme {
                MainScreen(viewModelFactory)
            }
        }
    }
}
