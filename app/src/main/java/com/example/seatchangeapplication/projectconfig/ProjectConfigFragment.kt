package com.example.seatchangeapplication.projectconfig

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.seatchangeapplication.databinding.FragmentProjectConfigBinding

class ProjectConfigFragment: Fragment() {

    lateinit var binding: FragmentProjectConfigBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProjectConfigBinding.inflate(inflater, container, false)
        return binding.root
    }
}