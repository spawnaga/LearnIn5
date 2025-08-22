package com.learnin5.model

data class User(
    val id: String,
    val name: String,
    val streakCount: Int = 0,
    val interests: List<String> = emptyList(), // Topics the user is interested in
    val completedLessons: List<String> = emptyList(), // IDs of completed lessons
    val lastActiveDate: String? = null // Date of last activity
)