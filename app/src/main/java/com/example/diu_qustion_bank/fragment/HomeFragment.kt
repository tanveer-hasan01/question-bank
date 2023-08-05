package com.example.diu_qustion_bank.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diu_qustion_bank.R
import com.example.diu_qustion_bank.databinding.FragmentHomeBinding
import com.example.diu_qustion_bank.databinding.FragmentProfileBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false);


        binding.fabButton.setOnClickListener {


        }

    return binding.root
    }
}