package com.amui.finals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance();


        btnLogin.setOnClickListener {

            if (edEmail.text.trim().isNotEmpty() && edPassword .text.trim().isNotEmpty()){
                signInUser(edEmail.text.trim().toString(), edPassword.text.trim().toString())
                Toast.makeText(this, "Input Provided", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "No Input for Username or Password", Toast.LENGTH_LONG).show()
            }
        }

        tvRegister.setOnClickListener{
            val intent = Intent(this, Register::class.java)
            startActivity(intent)
        }
    }

    fun signInUser(email:String, password:String){

        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this) {task ->

                if (task.isSuccessful){
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Error !!", Toast.LENGTH_LONG).show()
                }
            }
    }

}