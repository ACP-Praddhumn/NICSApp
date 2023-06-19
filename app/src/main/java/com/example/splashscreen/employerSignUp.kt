package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class employerSignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employer_sign_up)
        val btntosignup=findViewById<Button>(R.id.btnSignin)
        btntosignup.setOnClickListener {
            intent= Intent(applicationContext,employerSignIn::class.java)
            startActivity(intent)
        }

    }
}