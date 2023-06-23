package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.splashscreen.databinding.ActivityEmployerSignUpBinding
import com.google.firebase.auth.FirebaseAuth

class employerSignUp : AppCompatActivity() {

    private lateinit var binding: ActivityEmployerSignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employer_sign_up)

        binding = ActivityEmployerSignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        //val registerButton: Button = binding.btnRegister

        binding.btnSignup.setOnClickListener {

            val email = binding.email.editText?.text.toString()
            val password = binding.password.editText?.text.toString()
            if(email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this,employerSignIn::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this,"Empty Fields Are Not Allowed !!", Toast.LENGTH_SHORT).show()
            }

        }
    }
}