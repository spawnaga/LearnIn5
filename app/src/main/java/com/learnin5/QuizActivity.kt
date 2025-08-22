package com.learnin5

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.learnin5.model.Quiz
import com.learnin5.utils.UserProgressManager

class QuizActivity : AppCompatActivity() {
    
    private lateinit var currentQuiz: Quiz
    private var selectedAnswerIndex = -1
    private var score = 0
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        
        setupQuizData()
        setupUI()
    }
    
    private fun setupQuizData() {
        // Sample quiz data - in a real app this would come from the lesson
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
            radioButtons[index].tag = index // Store index for later reference
            radioButtons[index].setOnClickListener { onAnswerSelected(index) }
        }
        
        // Handle submit button click
        btnSubmit.setOnClickListener {
            handleSubmitQuiz()
        }
    }
    
    private fun onAnswerSelected(answerIndex: Int) {
        selectedAnswerIndex = answerIndex
        // Highlight selected answer
        highlightSelectedAnswer(answerIndex)
    }
    
    private fun highlightSelectedAnswer(selectedIndex: Int) {
        val radioButtons = arrayOf(
            findViewById<RadioButton>(R.id.radio_answer1),
            findViewById<RadioButton>(R.id.radio_answer2),
            findViewById<RadioButton>(R.id.radio_answer3),
            findViewById<RadioButton>(R.id.radio_answer4)
        )
        
        radioButtons.forEachIndexed { index, radioButton ->
            if (index == selectedIndex) {
                radioButton.setBackgroundResource(R.drawable.radio_button_selected)
            } else {
                radioButton.setBackgroundResource(R.drawable.radio_button_unselected)
            }
        }
    }
    
    private fun handleSubmitQuiz() {
        if (selectedAnswerIndex == -1) {
            Toast.makeText(this, "Please select an answer", Toast.LENGTH_SHORT).show()
            return
        }
        
        val isCorrect = selectedAnswerIndex == currentQuiz.correctAnswerIndex
        
        if (isCorrect) {
            score++
            Toast.makeText(this, "Correct! Well done.", Toast.LENGTH_SHORT).show()
            
            // Simulate saving progress
            UserProgressManager.markLessonCompleted("user_1", currentQuiz.lessonId)
        } else {
            Toast.makeText(this, "Incorrect. The correct answer is: ${currentQuiz.options[currentQuiz.correctAnswerIndex]}", Toast.LENGTH_LONG).show()
        }
        
        // Show result and move to next screen or finish
        showResult(isCorrect)
    }
    
    private fun showResult(isCorrect: Boolean) {
        // In a real app, this would show a detailed result screen
        // For now, we'll just show a toast and finish the activity
        val resultMessage = if (isCorrect) {
            "Great job! You got it right."
        } else {
            "Keep learning! You'll get better next time."
        }
        
        Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show()
        
        // Finish the quiz activity after a delay
        findViewById<Button>(R.id.btn_submit_quiz).postDelayed({
            finish()
        }, 2000)
    }
}