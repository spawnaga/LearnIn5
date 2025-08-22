package com.learnin5

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.learnin5.model.Quiz

class QuizActivity : AppCompatActivity() {
    
    private lateinit var currentQuiz: Quiz
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        
        setupQuizData()
        setupUI()
    }
    
    private fun setupQuizData() {
        // Sample quiz data
        currentQuiz = Quiz(
            id = "quiz_1",
            question = "What is the primary goal of machine learning?",
            options = listOf(
                "To replace human workers completely",
                "To enable computers to learn from data",
                "To create more powerful computers",
                "To reduce electricity consumption"
            ),
            correctAnswerIndex = 1,
            lessonId = "lesson_1"
        )
    }
    
    private fun setupUI() {
        val tvQuestion = findViewById<TextView>(R.id.tv_quiz_question)
        val radioGroup = findViewById<RadioGroup>(R.id.radio_group_answers)
        val btnSubmit = findViewById<Button>(R.id.btn_submit_quiz)
        
        // Set question text
        tvQuestion.text = currentQuiz.question
        
        // Populate answer options
        val options = currentQuiz.options
        val radioButtons = arrayOf(
            findViewById<RadioButton>(R.id.radio_answer1),
            findViewById<RadioButton>(R.id.radio_answer2),
            findViewById<RadioButton>(R.id.radio_answer3),
            findViewById<RadioButton>(R.id.radio_answer4)
        )
        
        options.forEachIndexed { index, option ->
            radioButtons[index].text = option
        }
        
        // Handle submit button click
        btnSubmit.setOnClickListener {
            val selectedRadioButtonId = radioGroup.checkedRadioButtonId
            if (selectedRadioButtonId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedRadioButtonId)
                val selectedIndex = radioGroup.indexOfChild(selectedRadioButton)
                
                if (selectedIndex == currentQuiz.correctAnswerIndex) {
                    // Correct answer logic
                    // Show success message
                } else {
                    // Incorrect answer logic
                    // Show feedback
                }
            }
        }
    }
}