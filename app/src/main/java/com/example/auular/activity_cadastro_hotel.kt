package com.example.auular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.auular.databinding.ActivityCadastroHotelBinding

class activity_cadastro_hotel : AppCompatActivity() {

    lateinit var binding: ActivityCadastroHotelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroHotelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ButtonAvancar.setOnClickListener {

        replaceFragment(Fragment1())

        }

        binding.ButtonVoltar.setOnClickListener {

            replaceFragment(Fragment2())

        }
    }

    private fun replaceFragment(fragment : Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_cadastro_hotel,fragment)
        fragmentTransaction.commit()
    }
}