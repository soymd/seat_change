package com.example.seatchangeapplication.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProvider
import java.io.Serializable

class AppViewModelProviders : Serializable {

    fun of(activity: FragmentActivity, factory: ViewModelProvider.Factory): ViewModelProvider {
        return ViewModelProvider(activity, factory)
    }

    fun ofFragment(fragment: Fragment, factory: ViewModelProvider.Factory): ViewModelProvider {
        return ViewModelProvider(fragment, factory)
    }
}