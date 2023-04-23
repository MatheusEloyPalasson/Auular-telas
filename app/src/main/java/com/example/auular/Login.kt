package com.example.auular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLoginHome = findViewById<Button>(R.id.bt_login_home)
        buttonLoginHome.setOnClickListener {
            finish()
        }

    }

    private fun login (){

        val email = findViewById<EditText>(R.id.et_email).text.toString();
        val senha = findViewById<EditText>(R.id.et_senha).text.toString();


    }
}