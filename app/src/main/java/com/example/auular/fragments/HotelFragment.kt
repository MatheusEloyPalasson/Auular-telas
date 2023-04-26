package com.example.auular.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.auular.R
import com.example.auular.domain.Hotel


class HotelFragment : Fragment() {

    private lateinit var nome: String
    private lateinit var phoneNumber: String
    private lateinit var description: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.getString("nome")?.let {
            nome = it
        }
        arguments?.getString("phoneNumber")?.let {
            phoneNumber = it
        }
        arguments?.getString("description")?.let {
            description = it
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hotel, container, false)
        val view = inflater.inflate(R.layout.fragment_hotel, container, false)
        val nomeHotel = view.findViewById<TextView>(R.id.name_hotel)
        val telefone = view.findViewById<TextView>(R.id.telefone_hotel)
        val descricao = view.findViewById<TextView>(R.id.descricao_hotel)
        nomeHotel.text = nome
        telefone.text = phoneNumber
        descricao.text = description
        return view
    }

    companion object {

        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(hotel: Hotel): HotelFragment {
            val fragment = HotelFragment()
            HotelFragment().apply {
                arguments = Bundle().apply {
                    putString("nome", fragment.nome)
                    putString("phoneNumber", fragment.phoneNumber)
                    putString("description", fragment.description)
                }
                return fragment
            }

        }
    }
}



