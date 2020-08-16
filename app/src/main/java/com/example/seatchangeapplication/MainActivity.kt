package com.example.seatchangeapplication

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.seatchangeapplication.common.ArgumentKeys
import com.example.seatchangeapplication.databinding.ActivityMainBinding
import com.example.seatchangeapplication.di.SeatChangeViewModelProviders
import com.example.seatchangeapplication.di.ViewModelFactory
import com.example.seatchangeapplication.menu.MenuFragment
import com.example.seatchangeapplication.seatchange.SeatChangeFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var commuterViewModelProviders: SeatChangeViewModelProviders =
        SeatChangeViewModelProviders()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        if (intent != null && intent.getSerializableExtra(ArgumentKeys.VIEW_MODEL_PROVIDERS.key) != null) {
            commuterViewModelProviders =
                intent.getSerializableExtra(ArgumentKeys.VIEW_MODEL_PROVIDERS.key) as SeatChangeViewModelProviders
        }
        viewModel =
            commuterViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        binding.apply {
            viewModel = this@MainActivity.viewModel
        }
        viewModel.callMenuEvent.observe(this, Observer {
            callMenuFragment()
        })
    }

    fun test(): Int {
        return viewModel.countGreeting()
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