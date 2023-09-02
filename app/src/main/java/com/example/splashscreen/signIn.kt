package com.example.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class signIn : AppCompatActivity() {
    lateinit var database : DatabaseReference
    companion object{
        const val KEY1 = "com.example.splashscreen.signIn.Name"
        const val KEY2 = "com.example.splashscreen.signIn.Father"
        const val KEY3 = "com.example.splashscreen.signIn.Contact"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in2)

        val signInButton = findViewById<Button>(R.id.btnsignIn)
        val userName = findViewById<TextInputEditText>(R.id.userNicsId)
        val btnsignUp = findViewById<TextView>(R.id.btntosignUp)

        btnsignUp.setOnClickListener {
            val intent = Intent(this, signUp ::class.java)
            startActivity(intent)
        }

        signInButton.setOnClickListener {
            val uniqueId = userName.text.toString()
            if(uniqueId.isNotEmpty()){
                readData(uniqueId)
            }else{
                Toast.makeText(this,"Please Enter The Details .", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun readData(uniqueId: String) {
        database = FirebaseDatabase.getInstance().getReference("Users")
        database.child(uniqueId).get().addOnSuccessListener {
            if(it.exists()){
                val Name = it.child("userName").value
                val Father = it.child("userFather").value
                val Contact = it.child("userContact").value

                val intentWelcome = Intent(this,welcomeJobSeeker :: class.java)
                intentWelcome.putExtra(KEY1,Name.toString())
                intentWelcome.putExtra(KEY2,Father.toString())
                intentWelcome.putExtra(KEY3,Contact.toString())
                startActivity(intentWelcome)

            }else{
                Toast.makeText(this,"User does not exist.",Toast.LENGTH_SHORT).show()
            }

        }.addOnFailureListener{
            Toast.makeText(this,"Failed !!",Toast.LENGTH_SHORT).show()
        }
    }
}