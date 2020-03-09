package com.stevenunez.geoquiz

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private final val TAG = "MainActivity"

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView

    private val questionList = listOf(
        Question(R.string.question_taiwan, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true)
    )

    private var currentQuestionIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")

        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)

        trueButton.setOnClickListener {view: View ->
            checkAnswer(true)
        }
        falseButton.setOnClickListener {view: View ->
            checkAnswer(false)
        }
        nextButton.setOnClickListener {view: View ->
            nextQuestion()
        }

        setQuestion()
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionList[currentQuestionIndex].answer

        val messageResourceId =
            if (userAnswer == correctAnswer)
                R.string.correct_toast
            else
                R.string.incorrect_toast

        Toast.makeText(this, messageResourceId, Toast.LENGTH_SHORT).show()
    }

    private fun nextQuestion() {
        currentQuestionIndex = (currentQuestionIndex + 1) % questionList.size
        setQuestion()
    }

    private fun setQuestion() {
        val questionTextResourceId = questionList[currentQuestionIndex].textResId
        questionTextView.setText(questionTextResourceId)
    }
}
