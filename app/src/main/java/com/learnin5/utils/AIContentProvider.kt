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
        // For now, we'll filter by user interests and sort by relevance score
        return availableLessons
            .filter { lesson ->
                user.interests.contains(lesson.category)
            }
            .sortedByDescending { calculateRelevanceScore(user, it) }
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
        
        // Add some randomness to make it more dynamic
        val randomFactor = (0..10).random() / 10.0f
        
        return (interestMatch + difficultyMatch) / 2 + randomFactor * 0.1f
    }
    
    /**
     * Generate a quiz based on a lesson
     */
    fun generateQuizForLesson(lesson: Lesson): com.learnin5.model.Quiz {
        // In a real implementation, this would extract key concepts from the lesson
        // and generate relevant quiz questions
        
        // Different quiz types based on lesson category
        val quizQuestions = when (lesson.category) {
            "AI" -> mapOf(
                "What is the main concept covered in this lesson?" to listOf(
                    "The history of AI",
                    "Key principles of AI",
                    "Future trends in AI",
                    "Common misconceptions about AI"
                ),
                "Which of these is a type of machine learning?" to listOf(
                    "Supervised learning",
                    "Cooking",
                    "Painting",
                    "Running"
                )
            )
            "History" -> mapOf(
                "When did the Industrial Revolution begin?" to listOf(
                    "18th century",
                    "19th century",
                    "20th century",
                    "17th century"
                ),
                "What was a major effect of the Industrial Revolution?" to listOf(
                    "Urbanization",
                    "Decreased population",
                    "Reduced technology",
                    "Less trade"
                )
            )
            "Finance" -> mapOf(
                "What is cryptocurrency?" to listOf(
                    "Digital money",
                    "Physical money",
                    "Paper money",
                    "Gold coins"
                ),
                "What technology underlies most cryptocurrencies?" to listOf(
                    "Blockchain",
                    "Cloud computing",
                    "Artificial Intelligence",
                    "Internet of Things"
                )
            )
            "Health" -> mapOf(
                "Why is good nutrition important?" to listOf(
                    "Maintains health",
                    "Causes illness",
                    "Reduces exercise",
                    "Increases stress"
                ),
                "What is a balanced diet?" to listOf(
                    "Includes fruits, vegetables, grains, proteins, and fats",
                    "Only fruits and vegetables",
                    "Only meat and dairy",
                    "Only processed foods"
                )
            )
            "Technology" -> mapOf(
                "What is a qubit?" to listOf(
                    "Quantum bit",
                    "Binary digit",
                    "Computer processor",
                    "Network protocol"
                ),
                "What is quantum computing?" to listOf(
                    "Computing using quantum bits",
                    "Traditional computing",
                    "Manual computing",
                    "Analog computing"
                )
            )
            else -> mapOf(
                "What is the main topic of this lesson?" to listOf(
                    "General knowledge",
                    "Science",
                    "History",
                    "Arts"
                )
            )
        }
        
        val question = quizQuestions.keys.firstOrNull() ?: "What is the main concept of this lesson?"
        val options = quizQuestions[question] ?: listOf(
            "Option 1",
            "Option 2", 
            "Option 3",
            "Option 4"
        )
        
        // Pick a random correct answer
        val correctAnswerIndex = (0 until options.size).random()
        
        return com.learnin5.model.Quiz(
            id = "quiz_${lesson.id}",
            question = question,
            options = options,
            correctAnswerIndex = correctAnswerIndex,
            lessonId = lesson.id
        )
    }
    
    /**
     * Simulate AI recommendation engine
     */
    fun recommendLessons(user: User, availableLessons: List<Lesson>, count: Int = 3): List<Lesson> {
        // Filter lessons by user interests
        val filteredLessons = availableLessons.filter { lesson ->
            user.interests.contains(lesson.category)
        }
        
        // Sort by relevance score
        val sortedLessons = filteredLessons.sortedByDescending { calculateRelevanceScore(user, it) }
        
        // Return top N lessons
        return sortedLessons.take(count)
    }
}