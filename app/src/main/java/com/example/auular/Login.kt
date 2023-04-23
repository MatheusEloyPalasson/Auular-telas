package com.example.auular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.auular.utils.Validator

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLoginHome = findViewById<Button>(R.id.bt_login_home)
        buttonLoginHome.setOnClickListener {
            finish()
        }

        val email = findViewById<EditText>(R.id.et_email).text.toString();
        val senha = findViewById<EditText>(R.id.et_senha).text.toString();



        login(email, senha);

    }

    private fun login(email: String, senha: String) {

        val logar = Intent(applicationContext, Tela_Tutor::class.java)

        Validator.validateEmail(email)
        Validator.validatePassword(senha)

        startActivity(logar)



    }


}