package com.example.splashscreen

import android.content.Intent
import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.Button


class signUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        val signbtn=findViewById<Button>(R.id.succefullSignup)
        signbtn.setOnClickListener {
            intent=Intent(applicationContext,signIn::class.java)
            startActivity(intent)
        }

              }

          }
