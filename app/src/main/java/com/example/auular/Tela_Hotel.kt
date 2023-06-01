package com.example.auular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.auular.fragments.HotelTelaFragment

class Tela_Hotel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_hotel)

        // Obter o FragmentManager
        val fragmentManager = supportFragmentManager

        // Iniciar a transação para adicionar a Fragment
        val transaction = fragmentManager.beginTransaction()

        // Criar uma instância do Fragment
        val hotelFragment = HotelTelaFragment()

        // Adicionar a Fragment ao contêiner
        transaction.add(R.id.containerHotel, hotelFragment)

        // Confirmar a transação
        transaction.commit()


    }


}