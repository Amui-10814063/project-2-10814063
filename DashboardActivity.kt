package com.amui.finals

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_dashboard.*
import kotlinx.android.synthetic.main.activity_main.*

class DashboardActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        auth = FirebaseAuth.getInstance();

        btnlogout.setOnClickListener{
            auth.signOut();
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}