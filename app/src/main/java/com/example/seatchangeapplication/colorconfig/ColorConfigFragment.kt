package com.example.seatchangeapplication.colorconfig

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.seatchangeapplication.databinding.FragmentColorConfigBinding

class ColorConfigFragment: Fragment() {

    lateinit var binding: FragmentColorConfigBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentColorConfigBinding.inflate(inflater, container, false)
        return binding.root
    }
}