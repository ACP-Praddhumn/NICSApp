package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class employerSignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employer_sign_in)
        val btnsignup=findViewById<TextView>(R.id.btntosignUpemployer)
        btnsignup.setOnClickListener {
            intent= Intent(applicationContext,employerSignUp::class.java)
            startActivity(intent)
        }
    }
}