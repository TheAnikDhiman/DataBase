package com.example.database

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val signupButton = findViewById<Button>(R.id.btnsignup)
        val nameEditText = findViewById<TextInputEditText>(R.id.etname)
        val emailEditText = findViewById<TextInputEditText>(R.id.etmail)
        val passwordEditText = findViewById<TextInputEditText>(R.id.etpassword)
        val idEditText = findViewById<TextInputEditText>(R.id.etID)

        signupButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email= emailEditText.text.toString()
            val password = passwordEditText.text.toString()
            val id = idEditText.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
            database.child(id).setValue(User(name,email,password,id)).addOnSuccessListener {
                Toast.makeText(this,"User Registered",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
            nameEditText.text?.clear()
            emailEditText.text?.clear()
            passwordEditText.text?.clear()
            idEditText.text?.clear()
        }
    }
}