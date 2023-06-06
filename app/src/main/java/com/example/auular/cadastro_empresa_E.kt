package com.example.auular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.auular.databinding.ActivityAcitivityCadastroHotelPt1Binding.inflate
import com.example.auular.databinding.ActivityCadastroEmpresaEBinding
import com.example.auular.fragments.FragmentCadastro1
import com.example.auular.fragments.FragmentCadastro2
import com.example.auular.fragments.FragmentCadastro3

class cadastro_empresa_E : AppCompatActivity() {
    lateinit var binding: ActivityCadastroEmpresaEBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val meuFragment1 = FragmentCadastro1()
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_cadastro_hotel, meuFragment1) // Substitua "container" pelo ID do contêiner onde deseja adicionar o Fragment
            .commitAllowingStateLoss()

        val fragmentUm = supportFragmentManager.findFragmentById(R.id.fragment_cadastro_hotel)


        binding = ActivityCadastroEmpresaEBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.avancarBtn.setOnClickListener {

            if (fragmentUm is FragmentCadastro1) {
                replaceFragment(FragmentCadastro2())
            } else if (fragmentUm is FragmentCadastro2) {
                replaceFragment(FragmentCadastro3())
            }
        }


        binding.voltarBtn.setOnClickListener {

            if (fragmentUm is FragmentCadastro1) {
                replaceFragment(FragmentCadastro1())
            } else if (fragmentUm is FragmentCadastro2) {
                replaceFragment(FragmentCadastro1())
            } else if (fragmentUm is FragmentCadastro3) {
                replaceFragment(FragmentCadastro2())
            }
        }
    }

    fun replaceFragment(fragment : Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_cadastro_hotel,fragment)
        fragmentTransaction.commit()
    }
}