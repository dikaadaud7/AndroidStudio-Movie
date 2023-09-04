package com.example.projectandro.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.projectandro.API.MovieResponse
import com.example.projectandro.API.Movies
import com.example.projectandro.API.authorizartionHeader
import com.example.projectandro.API.movieApiService
import com.example.projectandro.R
import com.example.projectandro.apps.ProjectAndro
import com.example.projectandro.components.GridItem
import com.example.projectandro.components.GridItemCard
import com.example.projectandro.components.NormalTextComponents
import com.example.projectandro.navigation.ProjectRouterScreen
import com.example.projectandro.navigation.Screen
import kotlinx.coroutines.launch


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeMovie() {
    val scope = rememberCoroutineScope()
    var popularMovies by remember {
        mutableStateOf(emptyList<Movies>())
    }
    var nowPlayingMovies by remember {
        mutableStateOf((emptyList<Movies>()))
    }
    var topRatedMovies by remember {
        mutableStateOf((emptyList<Movies>()))
    }
    val secondary = colorResource(id = R.color.background1)
    val primary = colorResource(id = R.color.background2)

    LaunchedEffect(key1 = true) {
        scope.launch {
            try {
                val response: MovieResponse = movieApiService.getMoviePopular(
                    authorizartionHeader
                )
                popularMovies = response.results ?: emptyList()
            } catch (e: Exception) {
                Log.e("MovieDBScreen", "Error fetching top rated movies: ${e.message}", e)
            }
        }
    }

    LaunchedEffect(key1 = true) {
        scope.launch {
            try {
                val response: MovieResponse = movieApiService.getTopRated(
                    authorizartionHeader
                )
                topRatedMovies = response.results ?: emptyList()
            } catch (e: Exception) {
                Log.e("MovieDBScreen", "Error fetching top rated movies: ${e.message}", e)
            }
        }
    }

    LaunchedEffect(key1 = true) {
        scope.launch {
            try {
                val response: MovieResponse = movieApiService.getNowPlayingMovie(
                    authorizartionHeader
                )
                nowPlayingMovies = response.results ?: emptyList()
            } catch (e: Exception) {
                Log.e("MovieDBScreen", "Error fetching top rated movies: ${e.message}", e)
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text(text = "List Of Movies")},
                backgroundColor = Color.LightGray,
                modifier = Modifier.heightIn(),
                actions = {
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier.fillMaxWidth()
                    ) {

                        IconButton(onClick = {
                            ProjectRouterScreen.navigateTo(Screen.FavoriteScreen)
                        }) {
                            Icon(Icons.Default.Favorite, contentDescription = "Add")
                        }
                    }
                }
            )
        },
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = Brush.linearGradient(listOf(secondary, primary)))
                .heightIn(8.dp),

            ){
            Column ( modifier = Modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),)
            {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(brush = Brush.linearGradient(listOf(secondary, primary)))
                )
                {
                    item {
                        UpperList(popularMovies = popularMovies)
                    }
                    item {
                        MiddleList(topMovie = topRatedMovies)
                    }
                    item {
                        BottomList(nowPlaying = nowPlayingMovies)
                    }
                }
            }
        }
    }

}

@SuppressLint("SuspiciousIndentation")
@Composable
fun UpperList(popularMovies : List<Movies>){
    val secondary = colorResource(id = R.color.background1)
    val primary = colorResource(id = R.color.background2)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(listOf(secondary, primary))
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
           NormalTextComponents(value = "Popular Movies")
           Spacer(modifier = Modifier.height(8.dp))
           CardsUpper(popular = popularMovies)
            Spacer(modifier = Modifier.height(8.dp))
        }

    }

@Composable
fun CardsUpper(popular: List<Movies>){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        items(popular) { movie ->
            val cardData = CardData(movie.title, movie.poster_path, "Description:${movie.overview}")
            CardItem(cardData) {
                ProjectRouterScreen.navigateToDetails("${movie.id}")
            }
        }
    }}



@SuppressLint("SuspiciousIndentation")
@Composable
fun MiddleList(topMovie: List<Movies>){
    val secondary = colorResource(id = R.color.background1)
    val primary = colorResource(id = R.color.background2)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(listOf(secondary, primary))
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NormalTextComponents(value = "Top Rated Movies")
            Spacer(modifier = Modifier.heightIn(8.dp))
            CardsMid(topMovie = topMovie)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }

@Composable
fun CardsMid(topMovie: List<Movies>){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        items(topMovie) { movie ->
            val cardData = CardData(movie.title, movie.poster_path, "Description:${movie.overview}")
            CardItem(cardData) {
                ProjectRouterScreen.navigateToDetails("${movie.id}")
            }
        }
    }}

@SuppressLint("SuspiciousIndentation")
@Composable
fun BottomList(nowPlaying: List<Movies>){
    val secondary = colorResource(id = R.color.background1)
    val primary = colorResource(id = R.color.background2)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.linearGradient(listOf(secondary, primary))
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
        }
            NormalTextComponents(value = "Now Playing Movies")
            Spacer(modifier = Modifier.heightIn(8.dp))
            CardsBottom(nowPlaying = nowPlaying )
            Spacer(modifier = Modifier.height(8.dp))
        }

@Composable
fun CardsBottom(nowPlaying: List<Movies>){
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        items(nowPlaying) { movie ->
            val cardData = CardData(movie.title, movie.poster_path, "Description:${movie.overview}")
            CardItem(cardData) {
                ProjectRouterScreen.navigateToDetails("${movie.id}")
            }

        }
    }
}

data class CardData(val title: String, val image: String, val description: String)

@Composable
fun CardItem(cardData: CardData, onClickAct:() -> Unit) {
    Card(
        border = BorderStroke(2.dp, Color.Gray),
        modifier = Modifier
            .width(140.dp)
            .height(200.dp)
            .padding(5.dp)
    ) {
        Column(
            modifier = Modifier
                .clickable(onClick = onClickAct),
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/original/${cardData.image}"),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
            )
            Spacer(modifier = Modifier.height(8.dp))
           androidx.compose.material3.Text(
            text = cardData.title,
               modifier = Modifier
                   .fillMaxWidth()
                   .heightIn(min = 40.dp),
               style = TextStyle(
                   fontSize = 24.sp,
                   fontWeight = FontWeight.Normal,
                   fontStyle = FontStyle.Normal
               )
               , color = colorResource(id = R.color.colorText),
               textAlign = TextAlign.Center,

           )

        }
    }
}



@Preview
@Composable
fun HomeMovieScreen(){
    HomeMovie()
}
