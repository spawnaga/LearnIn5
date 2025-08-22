# Learn in 5 - Micro Learning App

A 5-minute learning app with AI-curated daily feed, gamified streaks, and quick quizzes.

## Features

- 5-minute lessons on various topics (AI, history, finance, health)
- AI-curated daily feed based on user interests
- Gamified streaks & quick quizzes
- TikTok-like swipe interface for knowledge consumption

## Project Structure

```
app/
├── src/
│   ├── main/
│   │   ├── java/com/learnin5/
│   │   │   ├── MainActivity.kt
│   │   │   ├── model/
│   │   │   │   ├── Lesson.kt
│   │   │   │   ├── User.kt
│   │   │   │   └── Quiz.kt
│   │   │   ├── ui/
│   │   │   │   ├── LessonCard.kt
│   │   │   │   ├── QuizActivity.kt
│   │   │   │   └── StreakView.kt
│   │   │   ├── adapter/
│   │   │   │   └── LessonAdapter.kt
│   │   │   └── utils/
│   │   │       └── AIContentProvider.kt
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   ├── activity_main.xml
│   │   │   │   ├── item_lesson_card.xml
│   │   │   │   └── activity_quiz.xml
│   │   │   ├── values/
│   │   │   │   ├── colors.xml
│   │   │   │   ├── strings.xml
│   │   │   │   └── styles.xml
│   │   │   └── drawable/
│   │   └── AndroidManifest.xml
│   └── test/
│       └── java/com/learnin5/
└── build.gradle
```

## Getting Started

1. Clone the repository
2. Open in Android Studio
3. Build and run the project

## Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request