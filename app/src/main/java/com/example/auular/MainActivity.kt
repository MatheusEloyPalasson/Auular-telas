package com.example.auular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bt_login = findViewById<Button>(R.id.bt_login_home);
        bt_login.setOnClickListener {
            val intent = Intent(this, Login::class.java)
            startActivity(intent);
        }


        val bt_cadastro = findViewById<Button>(R.id.bt_cadastro_home);
        bt_cadastro.setOnClickListener {
            val intent = Intent(this, Escolha_Cadastro::class.java)
            startActivity(intent);
        }

    }






}