package com.stevenunez.geoquiz

import android.util.Log
import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    private final val TAG = "QuizViewModel"

    private val questionList = listOf(
        Question(R.string.question_taiwan, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true)
    )

    var currentQuestionIndex = 0

    val currentQuestionAnswer: Boolean
        get() = questionList[currentQuestionIndex].answer

    val currentQuestionTextId: Int
        get() = questionList[currentQuestionIndex].textResId

    fun moveToNext() {
        currentQuestionIndex = (currentQuestionIndex + 1) % questionList.size

    }
}