package com.example.auular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun loginHome (componente : View) {
            val logar = Intent(applicationContext, Login::class.java)
            startActivity(logar)
    }

    fun cadastroHome(componente: View) {
            val cadastro = Intent(applicationContext, Escolha_Cadastro::class.java)
            startActivity(cadastro)

    }








}