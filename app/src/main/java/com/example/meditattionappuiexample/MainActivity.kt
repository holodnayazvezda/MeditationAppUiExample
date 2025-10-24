package com.example.meditattionappuiexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.meditattionappuiexample.domain.navigation.NavigationHost
import com.example.meditattionappuiexample.ui.screens.bottomnav.sleep_screen.SleepScreenViewModel
import com.example.meditattionappuiexample.ui.theme.MeditattionAppUiExampleTheme

class MainActivity : ComponentActivity() {
    private val sleepScreenViewModel by viewModels<SleepScreenViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeditattionAppUiExampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationHost(
                        modifier = Modifier.padding(innerPadding),
                        sleepScreenViewModel = sleepScreenViewModel
                    )
                }
            }
        }
    }
}
