package com.learnin5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.learnin5.R
import com.learnin5.model.Lesson

class LessonAdapter(
    private val lessons: List<Lesson>,
    private val onItemClick: (Lesson) -> Unit
) : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {
    
    class LessonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_lesson_title)
        val topic: TextView = view.findViewById(R.id.tv_lesson_topic)
        val content: TextView = view.findViewById(R.id.tv_lesson_content)
        val duration: TextView = view.findViewById(R.id.tv_lesson_duration)
        val difficulty: TextView = view.findViewById(R.id.tv_lesson_difficulty)
    }
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lesson_card, parent, false)
        return LessonViewHolder(view)
    }
    
    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        val lesson = lessons[position]
        holder.title.text = lesson.title
        holder.topic.text = lesson.topic
        holder.content.text = lesson.content
        holder.duration.text = lesson.duration
        holder.difficulty.text = lesson.difficulty
        
        holder.itemView.setOnClickListener { onItemClick(lesson) }
    }
    
    override fun getItemCount() = lessons.size
}