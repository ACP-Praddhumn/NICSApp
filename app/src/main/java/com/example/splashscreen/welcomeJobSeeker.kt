package com.example.splashscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class welcomeJobSeeker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val Name = intent.getStringExtra(signIn.KEY1)
        val Father = intent.getStringExtra(signIn.KEY2)
        val Contact = intent.getStringExtra(signIn.KEY3)

        val welcomeText = findViewById<TextView>(R.id.welcome)
        val fatherText = findViewById<TextView>(R.id.father)
        val contactText = findViewById<TextView>(R.id.contact)

        welcomeText.text = "Welcome $Name"
        fatherText.text = "Father : $Father"
        contactText.text = "Contact no : $Contact"

    }
}