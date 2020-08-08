package com.example.seatchangeapplication.seatchange

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.seatchangeapplication.R
import com.example.seatchangeapplication.databinding.FragmentSeatChangeBinding

class SeatChangeFragment : Fragment() {

    lateinit var binding: FragmentSeatChangeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSeatChangeBinding.inflate(inflater, container, false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

}
