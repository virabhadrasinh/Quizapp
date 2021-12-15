package com.example.a19012021003_quizapp

import android.content.Intent
import android.icu.number.Scale.none
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    internal var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.question)

        val welcome = findViewById<TextView>(R.id.welcome)

        //Intent sent from MainActivity.kt is captured here, this is the username, for display.
        welcome.text = intent.getStringExtra("EdiTtEXTvALUE")
    }

    fun submitAnswer(view: View) {
        //This assesses the correct answer to question 1.
        val none = findViewById<RadioButton>(R.id.none)
        val answerToQuestion1 = none.isChecked
        if (answerToQuestion1) {
            score += 1
        }
        //This assesses the correct answer to question 2.
        val undefined = findViewById<RadioButton>(R.id.undefined)
        val answerToQuestion2 = undefined.isChecked
        if (answerToQuestion2) {
            score += 1
        }
        //This assesses the correct answer to question 3.
        val entityB = findViewById<RadioButton>(R.id.entityB)
        val answerToQuestion3 = entityB.isChecked
        if (answerToQuestion3) {
            score += 1
        }
        //This assesses the correct answer to question 4.
        val entityA1 = findViewById<RadioButton>(R.id.entityA1)
        val answerToQuestion4 = entityA1.isChecked
        if (answerToQuestion4) {
            score += 1
        }
        //This assesses the correct answer to question 5.
        val abc = findViewById<CheckBox>(R.id.abc)
        val def = findViewById<CheckBox>(R.id.def)
        val bcd = findViewById<CheckBox>(R.id.bcd)
        val cde = findViewById<CheckBox>(R.id.cde)
        val answerToQuestion5a = abc.isChecked
        val answerToQuestion5b = def.isChecked
        val answerToQuestion5c = bcd.isChecked
        val answerToQuestion5d = cde.isChecked

        score += when {
            (answerToQuestion5a && answerToQuestion5b) && !answerToQuestion5d && !answerToQuestion5c -> 1
            else -> 0
        }

        //This assesses the correct answer to question 6.
        val edit = findViewById<EditText>(R.id.edit)
        val answerToQuestion6 = edit.text.toString()
        score += when (answerToQuestion6) {
            "Particle A" -> 1
            else -> 0
        }

        //Toast messages to display on submission and the navigation intent to restart the quiz
        Toast.makeText(this, "Thanks for taking this quiz", Toast.LENGTH_SHORT).show()
        //sleep(500)
        Toast.makeText(this, "You scored $score out of 6", Toast.LENGTH_LONG).show()
        score = 0

        //Restart quiz by going back to the home page
        startActivity(Intent(this@QuizActivity, MainActivity::class.java))
        finish()
    }
}