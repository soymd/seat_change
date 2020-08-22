package com.example.seatchangeapplication.menu

//import com.example.seatchangeapplication.colorconfig.ColorConfigFragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.seatchangeapplication.FragmentType
import com.example.seatchangeapplication.R
import com.example.seatchangeapplication.colorconfig.ColorConfigFragment
import com.example.seatchangeapplication.common.ArgumentKeys
import com.example.seatchangeapplication.databinding.FragmentMenuBinding
import com.example.seatchangeapplication.di.SeatChangeViewModelProviders
import com.example.seatchangeapplication.projectconfig.ProjectConfigFragment
import com.example.seatchangeapplication.seatchange.SeatChangeFragment
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class MenuFragment : DaggerFragment() {
    private lateinit var binding: FragmentMenuBinding
    private lateinit var viewModel: MenuViewModel

    private var seatChangeViewModelProviders: SeatChangeViewModelProviders =
        SeatChangeViewModelProviders()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (arguments != null && arguments?.getSerializable(ArgumentKeys.VIEW_MODEL_PROVIDERS.key) != null) {
            seatChangeViewModelProviders =
                arguments?.getSerializable(ArgumentKeys.VIEW_MODEL_PROVIDERS.key) as SeatChangeViewModelProviders
        }
        viewModel = seatChangeViewModelProviders.of(requireActivity(), viewModelFactory)
            .get(MenuViewModel::class.java)

        binding = FragmentMenuBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
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
    }
}
