package com.example.auular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import com.example.auular.fragments.AppName
import com.example.auular.fragments.BotaoHome

class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        val button = findViewById<Button>(R.id.btnVoltar)

        button.setOnClickListener {
            val voltar = Intent(applicationContext, Tela_Tutor::class.java)
            startActivity(voltar)
        }


    }

}