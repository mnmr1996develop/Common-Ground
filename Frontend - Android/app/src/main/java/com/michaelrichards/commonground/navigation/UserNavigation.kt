package com.michaelrichards.commonground.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.michaelrichards.commonground.screens.splash.SplashScreen

@Composable
fun UserNavigation(modifier: Modifier = Modifier) {

    val controller = rememberNavController()

    NavHost(navController = controller, startDestination = Screens.SplashScreen.routeName){

        composable(route = Screens.SplashScreen.routeName){
            SplashScreen(navController = controller)
        }

        composable(route = Screens.HomeScreen.routeName){
            @Composable
            fun EmptyHomeScreen(modifier: Modifier = Modifier) {
                Box(modifier = Modifier.fillMaxSize()){
                    Text("Home Screen")
                }
            }
        }
    }


}