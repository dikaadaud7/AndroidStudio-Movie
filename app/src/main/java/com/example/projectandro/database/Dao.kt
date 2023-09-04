package com.example.projectandro.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user where email = :email")
    suspend fun getUserByEmail(email: String): User
}

@Dao
interface MovieDao{
    @Insert
    suspend fun insertMovieFav(movieFav: Movie)

    @Query("SELECT * FROM movies_favorite WHERE user_id = :userId")
    suspend fun getAllByUserId(userId: Int): List<Movie>?

    @Query("DELETE FROM movies_favorite WHERE movie_id = :movieId")
    suspend fun deleteMovieFav(movieId: Int)
}