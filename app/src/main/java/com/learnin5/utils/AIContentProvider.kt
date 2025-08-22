package com.learnin5.utils

import com.learnin5.model.Lesson
import com.learnin5.model.User

/**
 * Utility class to handle AI-powered content curation
 */
object AIContentProvider {
    
    /**
     * Generate a curated list of lessons based on user interests
     */
    fun generateCuratedLessons(user: User, availableLessons: List<Lesson>): List<Lesson> {
        // In a real implementation, this would use ML models to rank lessons
        // For now, we'll filter by user interests
        return availableLessons.filter { lesson ->
            user.interests.contains(lesson.category)
        }.sortedByDescending { it.aiRelevanceScore }
    }
    
    /**
     * Calculate relevance score for a lesson based on user profile
     */
    fun calculateRelevanceScore(user: User, lesson: Lesson): Float {
        // Simple scoring algorithm based on interests
        val interestMatch = if (user.interests.contains(lesson.category)) 1.0f else 0.0f
        val difficultyMatch = when {
            lesson.difficulty == "Easy" -> 0.8f
            lesson.difficulty == "Medium" -> 0.5f
            lesson.difficulty == "Hard" -> 0.2f
            else -> 0.0f
        }
        
        return (interestMatch + difficultyMatch) / 2
    }
    
    /**
     * Generate a quiz based on a lesson
     */
    fun generateQuizForLesson(lesson: Lesson): com.learnin5.model.Quiz {
        // In a real implementation, this would extract key concepts from the lesson
        // and generate relevant quiz questions
        
        return com.learnin5.model.Quiz(
            id = "quiz_${lesson.id}",
            question = "What is the main concept covered in this lesson?",
            options = listOf(
                "The history of ${lesson.category}",
                "Key principles of ${lesson.category}",
                "Future trends in ${lesson.category}",
                "Common misconceptions about ${lesson.category}"
            ),
            correctAnswerIndex = 1,
            lessonId = lesson.id
        )
    }
}