package com.example.a19012021003_quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name_field = findViewById<EditText>(R.id.name_field)
val button = findViewById<Button>(R.id.take_quiz)
        button.setOnClickListener {
            val quizIntent = Intent(this, QuizActivity::class.java)
            quizIntent.putExtra("EdiTtEXTvALUE", "Welcome " + name_field.text)
            startActivity(quizIntent)
            finish()
        }

    }
}