package com.example.seatchangeapplication

import android.content.ContentValues
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.database.getStringOrNull
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.seatchangeapplication.databinding.ActivityMainBinding
import com.example.seatchangeapplication.manager.DbManager
import com.example.seatchangeapplication.menu.MenuFragment
import com.example.seatchangeapplication.seatchange.SeatChangeFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = MainViewModel()
        binding.viewModel = viewModel
        viewModel.callMenuEvent.observe(this, Observer {
            callMenuFragment()
        })

        var dbManager = DbManager(applicationContext);

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