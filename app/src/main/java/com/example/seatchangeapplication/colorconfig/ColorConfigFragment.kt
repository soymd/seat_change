package com.example.seatchangeapplication.colorconfig

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.seatchangeapplication.common.ArgumentKeys
import com.example.seatchangeapplication.databinding.FragmentColorConfigBinding
import com.example.seatchangeapplication.di.SeatChangeViewModelProviders
import dagger.android.support.DaggerFragment
import javax.inject.Inject

// DaggerFragmentにしないとInjectされない
class ColorConfigFragment @Inject constructor() : DaggerFragment() {

    lateinit var binding: FragmentColorConfigBinding
    lateinit var viewModel: ColorConfigViewModel

    private var SeatChangeViewModelProviders: SeatChangeViewModelProviders =
        SeatChangeViewModelProviders()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (arguments != null && arguments?.getSerializable(ArgumentKeys.VIEW_MODEL_PROVIDERS.key) != null) {
            SeatChangeViewModelProviders =
                arguments?.getSerializable(ArgumentKeys.VIEW_MODEL_PROVIDERS.key) as SeatChangeViewModelProviders
        }

        viewModel = SeatChangeViewModelProviders.of(requireActivity(), viewModelFactory)
            .get(ColorConfigViewModel::class.java)

        binding = FragmentColorConfigBinding.inflate(inflater, container, false)
        val list = viewModel.getColorList()

        binding.colorListView.adapter = ColorConfigAdapter(list, requireContext())

        return binding.root
    }
}