package com.learnin5.utils

import com.learnin5.model.Lesson
import com.learnin5.model.User

/**
 * Simulates a simple database for storing user progress and streaks
 */
object UserProgressManager {
    
    // In a real app, this would be a proper database
    private val userProgress = mutableMapOf<String, MutableMap<String, Any>>()
    
    /**
     * Save user progress
     */
    fun saveUserProgress(user: User, completedLessons: List<String> = emptyList()) {
        val progressData = mutableMapOf<String, Any>()
        progressData["userId"] = user.id
        progressData["streakCount"] = user.streakCount
        progressData["completedLessons"] = completedLessons
        progressData["lastActiveDate"] = user.lastActiveDate ?: ""
        
        userProgress[user.id] = progressData
    }
    
    /**
     * Load user progress
     */
    fun loadUserProgress(userId: String): User? {
        val progressData = userProgress[userId]
        return if (progressData != null) {
            User(
                id = userId,
                name = "Learning Enthusiast", // Would be loaded from DB
                streakCount = progressData["streakCount"] as? Int ?: 0,
                interests = listOf("AI", "Technology", "Science"), // Would be loaded from DB
                completedLessons = progressData["completedLessons"] as? List<String> ?: emptyList(),
                lastActiveDate = progressData["lastActiveDate"] as? String
            )
        } else {
            null
        }
    }
    
    /**
     * Update user streak
     */
    fun updateUserStreak(userId: String, newStreak: Int) {
        val progressData = userProgress[userId]
        if (progressData != null) {
            progressData["streakCount"] = newStreak
        }
    }
    
    /**
     * Mark lesson as completed
     */
    fun markLessonCompleted(userId: String, lessonId: String) {
        val progressData = userProgress[userId]
        if (progressData != null) {
            val completedLessons = (progressData["completedLessons"] as? List<String> ?: emptyList()).toMutableList()
            if (!completedLessons.contains(lessonId)) {
                completedLessons.add(lessonId)
                progressData["completedLessons"] = completedLessons
            }
        }
    }
    
    /**
     * Get recommended lessons based on user progress
     */
    fun getRecommendedLessons(user: User, allLessons: List<Lesson>): List<Lesson> {
        val completedLessonIds = user.completedLessons.toSet()
        val availableLessons = allLessons.filter { !completedLessonIds.contains(it.id) }
        return availableLessons.take(3) // Return top 3 recommended lessons
    }
}