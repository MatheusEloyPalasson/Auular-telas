package com.example.auular.utils

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.auular.Escolha_Cadastro
import com.example.auular.Login
import com.example.auular.R

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