package com.example.seatchangeapplication

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.seatchangeapplication.common.ArgumentKeys
import com.example.seatchangeapplication.common.toSnakeCase
import com.example.seatchangeapplication.databinding.ActivityMainBinding
import com.example.seatchangeapplication.di.MainApplication.Companion.DEBUG_TAG
import com.example.seatchangeapplication.di.SeatChangeViewModelProviders
import com.example.seatchangeapplication.di.ViewModelFactory
import com.example.seatchangeapplication.dto.Color
import com.example.seatchangeapplication.dto.IDto
import com.example.seatchangeapplication.manager.DbManager
import com.example.seatchangeapplication.manager.DbOperationException
import com.example.seatchangeapplication.menu.MenuFragment
import com.example.seatchangeapplication.seatchange.SeatChangeFragment
import dagger.android.support.DaggerAppCompatActivity
<<<<<<< HEAD
import java.lang.Exception
=======
import timber.log.Timber
>>>>>>> c4081a06af1990f5143d6c18484cc6188962a1ff
import javax.inject.Inject
import kotlin.reflect.full.memberProperties

@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var viewModelProviders: SeatChangeViewModelProviders = SeatChangeViewModelProviders()

    private val TAG = this::class.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Timber.tag(DEBUG_TAG)
            .d("${this.javaClass.simpleName}: ${object {}.javaClass.enclosingMethod.name}")
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // テスト時にViewModelをmockするための記述
        if (intent != null && intent.getSerializableExtra(ArgumentKeys.VIEW_MODEL_PROVIDERS.key) != null) {
            viewModelProviders =
                intent.getSerializableExtra(ArgumentKeys.VIEW_MODEL_PROVIDERS.key) as SeatChangeViewModelProviders
        }
        viewModel = viewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)

        binding.apply {
            viewModel = this@MainActivity.viewModel
        }
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
    }
}