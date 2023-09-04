package com.example.projectandro.screens

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.projectandro.API.Movies
import com.example.projectandro.API.authorizartionHeader
import com.example.projectandro.API.movieApiService
import com.example.projectandro.R
import com.example.projectandro.components.userIsLogin
import com.example.projectandro.database.Movie
import com.example.projectandro.database.MyApplication
import com.example.projectandro.navigation.ProjectRouterScreen
import com.example.projectandro.navigation.Screen
import com.example.projectandro.navigation.SystemBackButtonHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DetailsMovie(itemId: String) {
    val secondary = colorResource(id = R.color.background1)
    val primary = colorResource(id = R.color.background2)
    val context = LocalContext.current
    val movieDetail = remember { mutableStateOf<Movies?>(null) }
    val isFavorite = remember { mutableStateOf(false) }
    val movieDao = (context.applicationContext as MyApplication).database.movieDao()
    var movieList by remember { mutableStateOf<List<Movie>?>(null) }
    var userLogin = userIsLogin
    LaunchedEffect(itemId) {
        try {
            val response: Movies = movieApiService.getDetailMovie(authorizartionHeader, itemId)
            movieDetail.value = response
        } catch (e: Exception) {
            // Handle error
        }
        CoroutineScope(Dispatchers.IO).launch {
            withContext(Dispatchers.Main) {
                movieList = userLogin?.let { movieDao.getAllByUserId(it.id) }

                val isMovieInFavoriteList = movieList?.any { movieFav ->
                    movieFav.movie_id == (movieDetail.value?.id ?: 0)
                } ?: false
                isFavorite.value = isMovieInFavoriteList
            }
        }
    }

    val movie = movieDetail.value

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Details") }, navigationIcon = {
                IconButton(onClick = {
                    ProjectRouterScreen.navigateTo(Screen.HomeMoviesScreen)
                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }, backgroundColor = Color.LightGray, modifier = Modifier.heightIn()

            )
        },
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.linearGradient(listOf(secondary, primary))
                )
                .padding(8.dp)
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        brush = Brush.linearGradient(listOf(secondary, primary))
                    )
                    .heightIn(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                movie?.let { it ->
                    val imageUrl = "https://image.tmdb.org/t/p/w500/${it.poster_path}"
                    Image(
                        painter = rememberAsyncImagePainter(model = imageUrl),
                        contentDescription = it.title,
                        modifier = Modifier
                            .size(500.dp)
                            .align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = it.title,
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Normal
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        color = colorResource(id = R.color.colorText)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Release Date: ${it.release_date}",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        color = colorResource(id = R.color.colorText)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Popularity: ${it.popularity}",
                        textAlign = TextAlign.Left,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        color = colorResource(id = R.color.colorText)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = it.overview,
                        textAlign = TextAlign.Justify,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            fontStyle = FontStyle.Normal
                        ),
                        modifier = Modifier.align(Alignment.CenterHorizontally),
                        color = colorResource(id = R.color.colorText)
                    )
                    IconButton(
                        onClick = {
                            val newMovie = Movie(
                                movie_id = movie.id,
                                title = movie.title,
                                release_date = movie.release_date,
                                poster_path = movie.poster_path,
                                popularity = movie.popularity,
                                overview = movie.overview,
                                user_id = userLogin!!.id
                            )
                            if (!isFavorite.value) {
                                CoroutineScope(Dispatchers.IO).launch {
                                    withContext(Dispatchers.Main) {
                                        movieDao.insertMovieFav(newMovie)
                                        movieList =
                                            userLogin?.let { movieDao.getAllByUserId(it.id) }

                                        val isMovieInFavoriteList = movieList?.any { movieFav ->
                                            movieFav.movie_id == (movieDetail.value?.id ?: 0)
                                        } ?: false
                                        isFavorite.value = isMovieInFavoriteList
                                    }
                                }
                            } else {
                                CoroutineScope(Dispatchers.IO).launch {
                                    withContext(Dispatchers.Main) {
                                        movieDao.deleteMovieFav(newMovie.movie_id)
                                        movieList =
                                            userLogin?.let { movieDao.getAllByUserId(it.id) }

                                        val isMovieInFavoriteList = movieList?.any { movieFav ->
                                            movieFav.movie_id == (movieDetail.value?.id ?: 0)
                                        } ?: false
                                        isFavorite.value = isMovieInFavoriteList
                                    }
                                }
                            }
                        }, modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {
                        Icon(
                            imageVector =
                            if (isFavorite.value){
                                Icons.Default.Favorite
                            }
                            else Icons.Default.FavoriteBorder,
                            contentDescription = "Favorite",
                            tint = if (isFavorite.value) Color.Red else Color.Black
                        )
                    }

                }

            }

        }
    }

    SystemBackButtonHandler {
        ProjectRouterScreen.navigateTo(Screen.HomeMoviesScreen)
    }
}


@Preview
@Composable
fun DetailScreenMovies() {
    DetailsMovie(itemId = "603")
}
