package com.example.auular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentContainerView
import com.example.auular.domain.Hotel
import com.example.auular.fragments.HotelFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.List

class Tela_Tutor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_tutor)

        val name = intent.getStringExtra("petTutorName")
        val usuario = findViewById<TextView>(R.id.hello_user)

        val hello = "E aí, ${name}!"

        usuario.setText(hello)


        val api = ApiUrl.getApiUsuarios()

        api.getHotels().enqueue(object : Callback<List<Hotel>> {
            override fun onResponse(call: Call<List<Hotel>>, response: Response<List<Hotel>>) {
                if (response.isSuccessful) {
                    val hotels = response.body();
                    if (hotels?.isNotEmpty()!!) {
                      
                    } else {

                    }
                } else {

                }


            }

            override fun onFailure(call: Call<List<Hotel>>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na API: ${t.message}",
                    Toast.LENGTH_SHORT).show()
                t.printStackTrace()
            }


        })


    }
}