package com.example.seatchangeapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.seatchangeapplication.databinding.ActivityMainBinding
import com.example.seatchangeapplication.projectconfig.MenuFragment
import com.example.seatchangeapplication.seatchange.SeatChangeFragment

class MainActivity : AppCompatActivity() {
    lateinit var dataBinding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = MainViewModel()

        dataBinding.viewModel = viewModel

        viewModel.callProjectConfigEvent.observe(this, Observer {
            callProjectConfigFragment()
        })

        val fragment = SeatChangeFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentRoot, fragment)

            .commit()
    }

    override fun onResume() {
        super.onResume()

    }

    private fun callProjectConfigFragment() {
        val fragment = MenuFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.menuFragmentRoot, fragment)
            .addToBackStack(null) // backStackに登録する場合
            .commit()
    }
}
