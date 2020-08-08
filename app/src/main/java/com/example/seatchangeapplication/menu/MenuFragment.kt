package com.example.seatchangeapplication.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.seatchangeapplication.R
import com.example.seatchangeapplication.colorconfig.ColorConfigFragment
import com.example.seatchangeapplication.databinding.FragmentMenuBinding
import com.example.seatchangeapplication.databinding.FragmentSeatChangeBinding
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
        viewModel = MenuViewModel()
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        binding.viewModel = viewModel
        viewModel.callSeatChangeEvent.observe(this, Observer {
            callSeatChange()
        })
        viewModel.callColorConfigEvent.observe(this, Observer {
            callColorConfig()
        })
        viewModel.callProjectConfigEvent.observe(this, Observer {
            callProjectConfig()
        })


        return binding.root
    }

    private fun callSeatChange() {
        val fragment = SeatChangeFragment()
        this.fragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentRoot, fragment)
            ?.commit()
    }

    private fun callColorConfig() {
        val fragment = ColorConfigFragment()
        this.fragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentRoot, fragment)
            ?.commit()
    }


    private fun callProjectConfig() {
        val fragment = ProjectConfigFragment()
        this.fragmentManager?.beginTransaction()
            ?.replace(R.id.fragmentRoot, fragment)
            ?.commit()
    }

}
