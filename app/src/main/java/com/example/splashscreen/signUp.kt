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
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class signUp : AppCompatActivity() {
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val userNics = findViewById<TextInputEditText>(R.id.userNics)
        val userName = findViewById<TextInputEditText>(R.id.userName)
        val userFather = findViewById<TextInputEditText>(R.id.userFather)
        val userDob = findViewById<TextInputEditText>(R.id.userDob)
        val userQualification = findViewById<TextInputEditText>(R.id.userQualification)
        val userGender = findViewById<TextInputEditText>(R.id.userGender)
        val userContact = findViewById<TextInputEditText>(R.id.userContact)
        val userEmail = findViewById<TextInputEditText>(R.id.userEmail)
        val userPassword = findViewById<TextInputEditText>(R.id.userPassword)
        val succefullSignup = findViewById<Button>(R.id.succefullSignup)

        succefullSignup.setOnClickListener {
            val Nics = userNics.text.toString()
            val Name = userName.text.toString()
            val Father = userFather.text.toString()
            val Dob = userDob.text.toString()
            val Qualification = userQualification.text.toString()
            val Gender = userGender.text.toString()
            val Contact = userContact.text.toString()
            val Email = userEmail.text.toString()
            val Password = userPassword.text.toString()

            val user = User(Nics,Name,Father,Dob,Qualification,Gender,Contact,Email,Password)
            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(Name).setValue(user).addOnSuccessListener {

                userNics.text?.clear()
                userFather.text?.clear()
                userName.text?.clear()
                userDob.text?.clear()
                userQualification.text?.clear()
                userGender.text?.clear()
                userContact.text?.clear()
                userPassword.text?.clear()
                userEmail.text?.clear()
                Toast.makeText(this,"User Registered Successfully !",Toast.LENGTH_SHORT).show()
                val intent = Intent(this,signIn :: class.java)
                startActivity(intent)
            }.addOnFailureListener{
                Toast.makeText(this, "User Not Registered !",Toast.LENGTH_SHORT).show()
            }
        }

    }

}
