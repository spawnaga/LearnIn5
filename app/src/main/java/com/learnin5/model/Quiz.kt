package com.learnin5.model

data class Quiz(
    val id: String,
    val question: String,
    val options: List<String>,
    val correctAnswerIndex: Int,
    val lessonId: String
)