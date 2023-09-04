package com.example.projectandro.API

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import java.util.Date

data class Movies(
    val id: Int,
    val title: String,
    val overview: String,
    val poster_path: String,
    val popularity: Double,
    val release_date: String,
)

data class MovieResponse(
    val results: List<Movies>?
)

interface MovieService{
    @GET("movie/popular?language=en-US&page=1")
    suspend fun getMoviePopular(@Header("Authorization") authorizartionHeader :String) : MovieResponse

    @GET("movie/now_playing?language=en-US&page=6")
    suspend fun getNowPlayingMovie(@Header("Authorization") authorizartionHeader :String) : MovieResponse

    @GET("movie/top_rated?language=en-US&page=1")
    suspend fun getTopRated(@Header("Authorization") authorizartionHeader :String) : MovieResponse

    @GET("movie/{movie_id}?language=en-US")
    suspend fun getDetailMovie(@Header("Authorization") authorizartionHeader :String,
    @Path("movie_id") movieId: String) : Movies

}

object RetrofitInstance{
    private const val BASE_URL = "https://api.themoviedb.org/3/"
    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient.Builder().build())
        .build()
}

val movieApiService: MovieService = RetrofitInstance.retrofit.create(MovieService::class.java)
const val authorizartionHeader: String =
    "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI5YTdiYzk3NGZmOTlmMmZkZjJjNDEwYTFiMjBhODUxOCIsInN1YiI6IjY0ZWEyYWQyZTg5NGE2MDExZWY4YTc2NSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.8ykgWA2o8G73D-p0rHRIrdqgMROWXffvoIMB1sXGQZs"