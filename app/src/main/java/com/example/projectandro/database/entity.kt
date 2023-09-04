package com.example.projectandro.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "user")
data class User (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val firstname: String,
    val lastname: String,
    val email: String,
    val password: String,
    val confirmPassword: String,
)

@Entity (tableName = "movies_favorite")
data class Movie(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val movie_id: Int,
    val title: String,
    val release_date: String,
    val poster_path: String,
    val popularity: Double,
    val overview: String,
    val user_id: Int
)
