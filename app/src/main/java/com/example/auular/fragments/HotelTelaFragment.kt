package com.example.auular.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.auular.R

class HotelTelaFragment : Fragment() {

    private lateinit var nome: String
    private lateinit var phoneNumber: String
    private lateinit var description: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    ? {
        // Inflar o layout da Fragment
        return inflater.inflate(R.layout.fragment_hotel_view, container, false)
    }
}