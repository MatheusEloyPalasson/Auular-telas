package com.example.auular.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.auular.R
import com.example.auular.databinding.FragmentBotaoHomeBinding


class BotaoHome : Fragment() {



    private val binding by lazy {
        FragmentBotaoHomeBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.botao_home).setOnClickListener {
            activity?.findViewById<View>(R.id.)?.callOnClick()
        }
    }

}