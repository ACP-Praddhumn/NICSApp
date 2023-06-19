package com.example.splashscreen

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

class secondpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondpage)
        val loginseeker= findViewById<CardView>(R.id.seekCard)
        val loginprovider=findViewById<CardView>(R.id.providerCard)

        loginseeker.setOnClickListener {
            intent= Intent(applicationContext,signIn::class.java)
            startActivity(intent)
        }
        loginprovider.setOnClickListener {
            intent=Intent(applicationContext,employerSignIn::class.java)
            startActivity(intent)
        }

    }
}