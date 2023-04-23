package com.example.auular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import com.example.auular.utils.Validator

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

    }

    fun cadastrar(componente: View) {

//        var nome = findViewById<EditText>(R.id.et_nome)
        var email = findViewById<EditText>(R.id.et_email).text.toString()
        var senha = findViewById<EditText>(R.id.et_senha).text.toString()
//        var cpf = findViewById<EditText>(R.id.et_documento)
//        var telefone = findViewById<EditText>(R.id.et_telefone)

        val isEmailValid: Boolean = Validator.validateEmail(email)
        val isPasswordValid: Boolean = Validator.validatePassword(senha)

        val buttonCadastro = findViewById<Button>(R.id.bt_cadastro);

        if (isEmailValid && isPasswordValid){
           buttonCadastro.setOnClickListener {
               val intent = Intent(this, Tela_Tutor::class.java)
               startActivity(intent);
           }
        }

        

    }
}