package com.example.auular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.auular.domain.LoginTutor
import com.example.auular.domain.PetTutor
import com.example.auular.utils.Validator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Cadastro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val buttonCadastro = findViewById<Button>(R.id.bt_cadastro)

        buttonCadastro.setOnClickListener { cadastrarTutor() }

    }

    fun cadastrarTutor() {

        var nome = findViewById<EditText>(R.id.et_nome).text.toString()
        var email = findViewById<EditText>(R.id.et_email).text.toString()
        var senha = findViewById<EditText>(R.id.et_senha).text.toString()
        var cpf = findViewById<EditText>(R.id.et_documento).text.toString()
        var telefone = findViewById<EditText>(R.id.et_telefone).text.toString()

        val isEmailValid: Boolean = Validator.validateEmail(email)
        val isPasswordValid: Boolean = Validator.validatePassword(senha)


        val ApiUsuario = ApiUrl.getApiUsuarios()

        var tvAutenticacao = findViewById<TextView>(R.id.tv_teste)



        val petTutor = PetTutor(nome, email, senha, cpf, telefone, false, false)


        val result: Call<PetTutor> = ApiUsuario.postPetTutor(petTutor)

        result.enqueue(object : Callback<PetTutor> {


            override fun onResponse(call: Call<PetTutor>, response: Response<PetTutor>) {
                if (response.isSuccessful) { // status 2xx (200, 201, 204 etc)
                    val petTutor = response.body()
                    val logar = Intent(applicationContext, Login::class.java)
                    startActivity(logar)
                } else {
                    var code = response.code()
                    tvAutenticacao.text = "Erro no cadastro  " + "${code}"
                }
            }

            override fun onFailure(call: Call<PetTutor>, t: Throwable) {
                Toast.makeText(
                    baseContext, "Erro na API: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
                t.printStackTrace()
            }
        })



    }
}