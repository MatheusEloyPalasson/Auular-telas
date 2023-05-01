package com.example.auular

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.auular.domain.Hotel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Tela_Tutor : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_tutor)

        val name = intent.getStringExtra("petTutorName")
        val usuario = findViewById<TextView>(R.id.hello_user)

        val hello = "E aí, ${name}!"

        usuario.setText(hello)

        val hotelResultsRecyclerView = findViewById<RecyclerView>(R.id.hotel_results)
        val hotelAdapter = HotelAdapter()
        hotelResultsRecyclerView.adapter = hotelAdapter

        val api = ApiUrl.getApiUsuarios()

        api.getHotels().enqueue(object : Callback<List<Hotel>> {
            override fun onResponse(call: Call<List<Hotel>>, response: Response<List<Hotel>>) {
                if (response.isSuccessful) {
                    val hotels = response.body();
                    if (hotels?.isNotEmpty()!!) {
                        hotelAdapter.setResultList(hotels)
                    }
                }
            }

            override fun onFailure(call: Call<List<Hotel>>, t: Throwable) {
                Toast.makeText(
                    baseContext, "Erro na API: ${t.message}",
                    Toast.LENGTH_SHORT
                ).show()
                t.printStackTrace()
            }
        })
    }

    fun byteArrayToBitmap(data: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(data, 0, data.size)
    }
}