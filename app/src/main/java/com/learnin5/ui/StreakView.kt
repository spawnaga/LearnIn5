package com.learnin5.ui

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import android.widget.TextView
import com.learnin5.R

class StreakView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    
    private val streakText: TextView
    
    init {
        inflate(context, R.layout.streak_view, this)
        streakText = findViewById(R.id.tv_streak_count)
    }
    
    fun setStreakCount(count: Int) {
        streakText.text = count.toString()
    }
}