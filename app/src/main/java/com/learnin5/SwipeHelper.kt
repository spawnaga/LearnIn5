package com.learnin5

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

// Simple swipe helper - if this causes issues, we can remove it
class SwipeHelper(private val recyclerView: RecyclerView) {
    
    init {
        // For now, we'll just set up the touch listener without complex gesture detection
        recyclerView.setOnTouchListener { _, event ->
            // We'll handle swipe detection in MainActivity instead
            false
        }
    }
}