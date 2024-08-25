package com.smart.clinic

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.smart.clinic.core.designsystem.theme.ClinicTheme
import com.smart.clinic.navigation.ClinicNavHost
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import org.koin.core.context.KoinContext

@Composable
@Preview
fun App() {
    ClinicTheme {
        /*var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }*/
        KoinContext {
            val navController = rememberNavController()
            Scaffold(
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
                containerColor = ClinicTheme.colorScheme.backgroundBase
            ) { padding ->
                Box(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .windowInsetsPadding(WindowInsets.systemBars)
                ) {
                    ClinicNavHost(navController)
                }
            }
        }
    }
}