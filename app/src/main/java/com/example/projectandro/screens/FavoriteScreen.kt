package com.example.projectandro.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.projectandro.API.Movies
import com.example.projectandro.R
import com.example.projectandro.components.NormalTextComponents
import com.example.projectandro.components.userIsLogin
import com.example.projectandro.database.MyApplication
import com.example.projectandro.database.User
import com.example.projectandro.navigation.ProjectRouterScreen
import com.example.projectandro.navigation.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun FavoriteScreen(){
    val context = LocalContext.current
    val movieDao = (context.applicationContext as MyApplication).database.movieDao()
    val userDao = (context.applicationContext as MyApplication).database.userDao()
    var userLogin = userIsLogin
    var movieList by remember {
        mutableStateOf<List<Movies>?>(null)
    }
    val secondary = colorResource(id = R.color.background1)
    val primary = colorResource(id = R.color.background2)



    LaunchedEffect(key1 = true) {
        CoroutineScope(Dispatchers.IO).launch {
            val movieFavList = movieDao.getAllByUserId(userLogin!!.id)
            val mappedMovieList = movieFavList?.map { movieFav ->
                Movies(
                    id = movieFav.movie_id,
                    title = movieFav.title,
                    overview = movieFav.overview,
                    popularity = movieFav.popularity,
                    release_date = movieFav.release_date,
                    poster_path = movieFav.poster_path,
                )
            }
            withContext(Dispatchers.Main) {
                movieList = mappedMovieList
            }
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { androidx.compose.material3.Text(text = "Favorites") },
                navigationIcon = {
                IconButton(onClick = {
                    ProjectRouterScreen.navigateTo(Screen.HomeMoviesScreen)
                }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }, backgroundColor = Color.LightGray, modifier = Modifier.heightIn()

            )
        },
    ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(listOf(secondary, primary))
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(listOf(secondary, primary))
                        )
                        .padding(bottom = 16.dp)
                ) {
                    NormalTextComponents(value = "Favorite")
                    Spacer(modifier = Modifier.heightIn(min = 10.dp))
                    LazyColumn {
                        items(movieList ?: emptyList()){
                                movie -> ItemCard(movie = movie) {
                            ProjectRouterScreen.navigateToDetails("${movie.id}")
                        }
                        }
                    }
                }
            }
        }
    }
    @Composable
    fun ItemCard(movie: Movies, onClick: () -> Unit) {
        Card(
           modifier = Modifier
               .fillMaxWidth()
               .padding(8.dp)
               .clickable(onClick = onClick),
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = "https://image.tmdb.org/t/p/w500" + movie.poster_path),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                )
                Spacer(modifier = Modifier.width(30.dp))
                Column {
                    Text(
                        text = movie.title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }
        }
}