package com.example.seatchangeapplication.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.seatchangeapplication.FragmentType
import com.example.seatchangeapplication.R
import com.example.seatchangeapplication.colorconfig.ColorConfigFragment
import com.example.seatchangeapplication.databinding.FragmentMenuBinding
import com.example.seatchangeapplication.projectconfig.ProjectConfigFragment
import com.example.seatchangeapplication.seatchange.SeatChangeFragment

class MenuFragment : Fragment() {
    private lateinit var binding: FragmentMenuBinding
    private lateinit var viewModel: MenuViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        println("MenuFragment - onCreateView")
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        viewModel = MenuViewModel()
        binding.viewModel = viewModel

        viewModel.callFragmentEvent.observe(viewLifecycleOwner, Observer {
            callFragment(it)
        })

        return binding.root
    }

    private fun callFragment(type: FragmentType) {
        val fragment = when (type) {
            FragmentType.SEAT_CHANGE -> SeatChangeFragment()
            FragmentType.PROJECT_CONFIG -> ProjectConfigFragment()
            FragmentType.COLOR_CONFIG -> ColorConfigFragment()
        }
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentRoot, fragment)
            .addToBackStack(null)
            .commit()
        println("${type.name} Fragment called")
    }
}
