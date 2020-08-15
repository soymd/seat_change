package com.example.seatchangeapplication.colorconfig

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class ColorConfigRepositoryImplTest {
    lateinit var subject : ColorConfigRepositoryImpl
    lateinit var context : Context

    @Before
    fun setUp() {
        context = RuntimeEnvironment.application;
//        subject = ColorConfigRepositoryImpl()
    }

    @Test
    fun get() {
        val actual = subject.get()
        val expected = listOf<ColorConfigModel>()
        assertThat(actual, equalTo(expected))
    }
}