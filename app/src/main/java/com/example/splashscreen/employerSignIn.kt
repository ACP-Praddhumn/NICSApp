package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.splashscreen.databinding.ActivityEmployerSignInBinding
import com.google.firebase.auth.FirebaseAuth

class employerSignIn : AppCompatActivity() {

    private lateinit var binding: ActivityEmployerSignInBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employer_sign_in)

        binding = ActivityEmployerSignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView2.setOnClickListener {
            val intent = Intent(this, employerSignUp::class.java)
            startActivity(intent)
        }

        binding.btnsignIn.setOnClickListener {

            val email = binding.email.editText?.text.toString()
            val password = binding.password.editText?.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are Not Allowed !!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}