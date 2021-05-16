package com.amui.finals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity() {


    private lateinit var auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = FirebaseAuth.getInstance();

        btnRegister.setOnClickListener {
            if (editEmail.text.trim().toString().isNotEmpty() && editPassword.text.trim().toString().isNotEmpty()) {
                createuser(editEmail.text.trim().toString(), editPassword.text.trim().toString())
                Toast.makeText(this, "Input entered", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "No Input for Email or Password", Toast.LENGTH_LONG).show()
            }


        }

        tvLogin.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent);
        }
    }


    fun createuser(Email: String, Password: String) {
        auth.createUserWithEmailAndPassword(Email, Password)
            .addOnCompleteListener(this) { task ->

                if (task.isSuccessful) {
                    Log.e("Task Message", "Successful ...");

                    var intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent);

                } else {
                    Log.e("Task Message", "Failed" + task.exception);
                }
            }
    }

    override fun onStart() {
        super.onStart()

    }
}