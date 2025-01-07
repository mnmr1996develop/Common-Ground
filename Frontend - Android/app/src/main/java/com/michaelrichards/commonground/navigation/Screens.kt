package com.michaelrichards.commonground.navigation

sealed class Screens(val routeName: String) {
    data object LoginScreen : Screens("login")
    data object RegistrationScreen: Screens("registration")
    data object HomeScreen: Screens("home")
    data object SplashScreen: Screens("splash")
}