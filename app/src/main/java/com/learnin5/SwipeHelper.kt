package com.learnin5

import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class SwipeHelper(private val recyclerView: RecyclerView) {
    
    private val gestureDetector = GestureDetector(recyclerView.context, GestureListener())
    
    init {
        recyclerView.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
            false
        }
    }
    
    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent?,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            e1?.let { e1Motion ->
                e2?.let { e2Motion ->
                    val diffX = e2Motion.x - e1Motion.x
                    val diffY = e2Motion.y - e1Motion.y
                    
                    // Check if it's a horizontal swipe
                    if (Math.abs(diffX) > Math.abs(diffY) && Math.abs(diffX) > 100) {
                        if (diffX > 0) {
                            // Swipe right - previous lesson
                            onSwipeRight()
                        } else {
                            // Swipe left - next lesson
                            onSwipeLeft()
                        }
                        return true
                    }
                }
            }
            return false
        }
    }
    
    private fun onSwipeLeft() {
        // Handle swipe left (next lesson)
        println("Swiped left - next lesson")
        // In a real implementation, this would advance to the next lesson
    }
    
    private fun onSwipeRight() {
        // Handle swipe right (previous lesson)
        println("Swiped right - previous lesson")
        // In a real implementation, this would go to the previous lesson
    }
}