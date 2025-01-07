package com.michaelrichards.commonground.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.michaelrichards.commonground.R
import com.michaelrichards.commonground.navigation.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(modifier: Modifier = Modifier, navController: NavController) {


    LaunchedEffect(Unit) {
        delay(5000)
        navController.navigate(Screens.HomeScreen.routeName)
    }

    Scaffold(
        bottomBar = {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.height(50.dp).fillMaxWidth()
            ){
                Text(stringResource(R.string.app_name),
                    style = MaterialTheme.typography.titleLarge
                )
            }
            
        }

    ) { paddingValues: PaddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues).fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Image(
                    modifier = Modifier
                        .size(200.dp),
                    painter = painterResource(id = R.drawable.ic_launcher_background),
                    contentDescription = stringResource(
                        id = R.string.app_logo
                    )
                )
                Spacer(Modifier.height(8.dp))
                LinearProgressIndicator()
            }
        }
    }
}



@Preview
@Composable
private fun PrevSplashScreen() {

    val navController = NavController(LocalContext.current)

    SplashScreen(navController = navController)
}