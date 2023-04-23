package com.example.auular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class Escolha_Cadastro : AppCompatActivity() {

    val imageButtonTutor = findViewById<ImageButton>(R.id.ibt_escolha_tutor)
    val imageButtonEmpresa = findViewById<ImageButton>(R.id.ibt_escolha_empresa)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_escolha_cadastro)

        imageButtonTutor.setOnClickListener {
            val intent = Intent(this, Cadastro::class.java)
            startActivity(intent)
        }

        imageButtonEmpresa.setOnClickListener {
            val intent = Intent(this, CadastroHotelPt1::class.java)
            startActivity(intent)
        }

    }






}