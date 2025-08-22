package com.learnin5.model

data class Lesson(
    val id: String,
    val title: String,
    val topic: String,
    val content: String,
    val duration: String, // e.g., "5 min"
    val difficulty: String, // e.g., "Easy", "Medium", "Hard"
    val category: String, // e.g., "AI", "History", "Finance", "Health"
    val aiRelevanceScore: Float = 0.0f // Score from AI curation
)