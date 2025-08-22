package com.learnin5

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.learnin5.model.Lesson
import com.learnin5.model.User

class MainActivity : AppCompatActivity() {
    
    private lateinit var currentUser: User
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize sample user
        currentUser = User(
            id = "user_1",
            name = "Learning Enthusiast",
            streakCount = 3,
            interests = listOf("AI", "Technology", "Science")
        )
        
        setupUI()
        loadSampleData()
    }
    
    private fun setupUI() {
        val btnTakeQuiz = findViewById<Button>(R.id.btn_take_quiz)
        val tvStreakCount = findViewById<TextView>(R.id.tv_streak_count)
        
        // Set initial streak count
        tvStreakCount.text = currentUser.streakCount.toString()
        
        btnTakeQuiz.setOnClickListener {
            // Navigate to quiz activity
            // startActivity(Intent(this, QuizActivity::class.java))
        }
    }
    
    private fun loadSampleData() {
        // Load sample lessons for demonstration
        val sampleLessons = listOf(
            Lesson(
                id = "lesson_1",
                title = "Introduction to Machine Learning",
                topic = "AI",
                content = "Machine learning is a subset of artificial intelligence that enables computers to learn and improve from experience without being explicitly programmed. It uses algorithms to parse data, learn from that data, and then make informed decisions based on what it has learned.",
                duration = "5 min",
                difficulty = "Easy",
                category = "AI"
            ),
            Lesson(
                id = "lesson_2",
                title = "The Industrial Revolution",
                topic = "History",
                content = "The Industrial Revolution was a period of major industrialization that took place during the late 18th and early 19th centuries. It transformed economies from agricultural to manufacturing, leading to urbanization and significant social changes.",
                duration = "5 min",
                difficulty = "Medium",
                category = "History"
            ),
            Lesson(
                id = "lesson_3",
                title = "Understanding Cryptocurrency",
                topic = "Finance",
                content = "Cryptocurrency is a digital or virtual currency that uses cryptography for security. Unlike traditional currencies, it operates independently of a central bank and is based on blockchain technology, which is a distributed ledger that records transactions across many computers.",
                duration = "5 min",
                difficulty = "Medium",
                category = "Finance"
            )
        )
        
        // Display lessons (this would normally be handled by an adapter)
        displayLessons(sampleLessons)
    }
    
    private fun displayLessons(lessons: List<Lesson>) {
        // In a real implementation, this would populate the swipeable lesson cards
        // For now, we'll just log the lessons
        lessons.forEach { lesson ->
            println("Lesson: ${lesson.title} - ${lesson.topic}")
        }
    }
}