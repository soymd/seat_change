package com.example.seatchangeapplication.colorconfig

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.seatchangeapplication.databinding.FragmentColorConfigBinding
import com.example.seatchangeapplication.di.SeatChangeApplication

class ColorConfigFragment(

) : Fragment() {

    lateinit var binding: FragmentColorConfigBinding
    lateinit var viewModel: ColorConfigViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentColorConfigBinding.inflate(inflater, container, false)
        viewModel = SeatChangeApplication.component.colorConfigViewModel()
        val list = viewModel.getColorList()

        binding.colorListView.adapter = ColorConfigAdapter(list, requireContext())

        return binding.root
    }
}