package com.example.auular

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.auular.domain.LoginTutor
import com.example.auular.domain.PetTutor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val buttonLogin = findViewById<Button>(R.id.bt_login)

        buttonLogin.setOnClickListener { logarTutor() }

    }

    private fun logarTutor() {


        var tvAutenticacao = findViewById<TextView>(R.id.tv_autenticacao)


        val ApiUsuario = ApiUrl.getApiUsuarios()


        val email = findViewById<EditText>(R.id.et_email).text.toString();
        val senha = findViewById<EditText>(R.id.et_senha).text.toString();

        val loginTutor = LoginTutor(email, senha)

        val result: Call<PetTutor> = ApiUsuario.getLogin(loginTutor)

        result.enqueue(object : Callback<PetTutor> {


            override fun onResponse(call: Call<PetTutor>, response: Response<PetTutor>) {
                if (response.isSuccessful) { // status 2xx (200, 201, 204 etc)
                    val petTutor = response.body()
                    val logar = Intent(applicationContext, Tela_Tutor::class.java)
                    logar.putExtra("petTutorName", petTutor?.name)
                    startActivity(logar)
                } else {
                    var code = response.code()
                    tvAutenticacao.text = "Login e/ou senha inválidos " + "${code}"
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


//        val buttonLogin = findViewById<Button>(R.id.bt_login)


    }


}