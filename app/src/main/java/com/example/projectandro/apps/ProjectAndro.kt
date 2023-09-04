package com.example.projectandro.apps

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.projectandro.API.Movies
import com.example.projectandro.navigation.ProjectRouterScreen
import com.example.projectandro.navigation.Screen
import com.example.projectandro.screens.DetailScreenMovies
import com.example.projectandro.screens.DetailsMovie
import com.example.projectandro.screens.FavoriteScreen
import com.example.projectandro.screens.HomeMovie
import com.example.projectandro.screens.HomeMovieScreen
import com.example.projectandro.screens.HomeScreen
import com.example.projectandro.screens.LoginScreen
import com.example.projectandro.screens.SignUpScreen
import com.example.projectandro.screens.TermsAndCondition


@Composable
fun ProjectAndro(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Crossfade(targetState = ProjectRouterScreen.currentScreen) { currentState ->
        when(currentState.value){
        is Screen.SignUpScreen ->{
           SignUpScreen()
        }
        is Screen.TermsAndCondition->{
              TermsAndCondition()
            }
        is Screen.LoginScreen->{
            LoginScreen()
        }
        is Screen.HomeScreen ->{
            HomeScreen()
        }
        is Screen.HomeMoviesScreen ->{
            HomeMovieScreen()
        }
        is Screen.DetailMoviesScreen->{
           DetailsMovie(ProjectRouterScreen.selectedMovieId.value?:"")
        }
        is Screen.FavoriteScreen->{
            FavoriteScreen()
        }
              }
        }
    }

}
