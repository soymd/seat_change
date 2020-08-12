package com.example.seatchangeapplication

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.seatchangeapplication.databinding.ActivityMainBinding
import com.example.seatchangeapplication.di.AppViewModelProviders
import com.example.seatchangeapplication.di.ViewModelFactory
import com.example.seatchangeapplication.menu.MenuFragment
import com.example.seatchangeapplication.seatchange.SeatChangeFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity @Inject constructor(private val viewModelFactory: ViewModelFactory) :
    DaggerAppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var appViewModelProviders: AppViewModelProviders = AppViewModelProviders()

//    @Inject
//    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = appViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
//        viewModel = AppViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        //viewModel = MainViewModel()
        binding.viewModel = viewModel
        viewModel.callMenuEvent.observe(this, Observer {
            callMenuFragment()
        })
    }

    override fun onResume() {
        super.onResume()
        // 画面初期表示, TODO: 共通化
        val fragment = SeatChangeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentRoot, fragment)
            .commit()
    }

    private fun callMenuFragment() {
        val menuFragment = MenuFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.menuFragmentRoot, menuFragment)
            .addToBackStack(null)
            .commit()
        println("MenuFragment called")
    }
}