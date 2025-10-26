package com.prograiii.wamans

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

class login : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    val context: Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        auth = Firebase.auth
    }
    public override fun onStart() {
        super.onStart()
        // Check if user is signed in (non-null) and update UI accordingly.
        val currentUser = auth.currentUser
        if (currentUser != null) {
            val intentPantallaPrincipal = Intent(context, PantallaPrincipalActivity::class.java)
            startActivity(intentPantallaPrincipal)
        }
    }
    fun crearUsuario(
        email: String,
        password: String
    ) {auth.createUserWithEmailAndPassword(correo, pass)
        .addOnCompleteListener(this) { task ->
            if (task.isSuccessful) {
                val intentlogin = Intent(context, LoginActivity::class.java)
                startActivity(intentlogin)
            }else {
                Toast.makeText(
                    baseContext,
                    "Authentication failed.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

}