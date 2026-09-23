package com.example.lab1_madt

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val textView = findViewById<TextView>(R.id.textView)
        val buttonColour = findViewById<Button>(R.id.buttonColour)
        val buttonBackgroundColour = findViewById<Button>(R.id.buttonBackgroundColour)


        button.setOnClickListener {
            textView.setText(R.string.button_clicked)
        }

        buttonColour.setOnClickListener {
            textView.setTextColor(getColor(android.R.color.holo_red_dark))
        }

        //Code for revert
        buttonBackgroundColour.setOnClickListener {
            findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.main)
                .setBackgroundColor(getColor(android.R.color.holo_blue_light))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}