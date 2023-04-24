package com.example.auular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Tela_Tutor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_tutor)

        val name = intent.getStringExtra("petTutorName")
        val usuario = findViewById<TextView>(R.id.hello_user)

        val hello = "E aí, ${name}!"

        usuario.setText(hello)

    }
}