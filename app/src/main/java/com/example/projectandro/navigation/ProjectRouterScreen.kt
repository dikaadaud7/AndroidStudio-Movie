package com.example.projectandro.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


sealed class Screen(){
    object SignUpScreen : Screen()
    object TermsAndCondition : Screen()
    object LoginScreen : Screen()
    object HomeScreen : Screen()
    object HomeMoviesScreen: Screen()
    object DetailMoviesScreen: Screen()
    object FavoriteScreen: Screen()
}

object ProjectRouterScreen{
    val currentScreen : MutableState<Screen> = mutableStateOf(Screen.LoginScreen)
    val selectedMovieId: MutableState<String?> = mutableStateOf(null)

    fun navigateTo(destinations : Screen){
         currentScreen.value = destinations
    }
    fun navigateToDetails(movieId: String){
        selectedMovieId.value = movieId
        currentScreen.value = Screen.DetailMoviesScreen
    }
}