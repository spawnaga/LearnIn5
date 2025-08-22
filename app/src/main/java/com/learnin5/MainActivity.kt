package com.learnin5

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.learnin5.adapter.LessonAdapter
import com.learnin5.model.Lesson
import com.learnin5.model.User

class MainActivity : AppCompatActivity() {
    
    private lateinit var currentUser: User
    private lateinit var recyclerView: RecyclerView
    private lateinit var lessonAdapter: LessonAdapter
    private var currentLessonIndex = 0
    
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
        setupRecyclerView()
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
    
    private fun setupRecyclerView() {
        recyclerView = findViewById(R.id.lessons_container)
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        // Create a simple adapter for now
        lessonAdapter = LessonAdapter(emptyList()) { lesson ->
            // Handle lesson click
            println("Clicked on lesson: ${lesson.title}")
        }
        recyclerView.adapter = lessonAdapter
        
        // Setup swipe detection
        SwipeHelper(recyclerView)
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
            ),
            Lesson(
                id = "lesson_4",
                title = "Nutrition Basics",
                topic = "Health",
                content = "Good nutrition is essential for maintaining health and preventing disease. A balanced diet includes fruits, vegetables, whole grains, lean proteins, and healthy fats. Proper hydration and portion control are also important components of good nutrition.",
                duration = "5 min",
                difficulty = "Easy",
                category = "Health"
            ),
            Lesson(
                id = "lesson_5",
                title = "Quantum Computing Fundamentals",
                topic = "Technology",
                content = "Quantum computing uses quantum bits (qubits) that can exist in multiple states simultaneously, unlike classical bits that are either 0 or 1. This allows quantum computers to solve certain problems exponentially faster than classical computers.",
                duration = "5 min",
                difficulty = "Hard",
                category = "Technology"
            )
        )
        
        // Update the adapter with sample lessons
        lessonAdapter = LessonAdapter(sampleLessons) { lesson ->
            // Handle lesson click
            println("Clicked on lesson: ${lesson.title}")
        }
        recyclerView.adapter = lessonAdapter
    }
}