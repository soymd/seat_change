package com.example.seatchangeapplication.manager

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.seatchangeapplication.colorconfig.ColorConfigModel
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class SeatChangeSQLiteOpenAdapterTest {

    private lateinit var subject: SeatChangeSQLiteOpenAdapter
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        subject = SeatChangeSQLiteOpenAdapter(context)
    }

    @Test
    fun getProjectColorModels() {
        val actual = subject.getProjectColorModels()
        val expected = getModels()

        assertThat(actual, equalTo(expected))
    }

    private fun getModels(): List<ColorConfigModel> {
        val model1 = ColorConfigModel(
            1,
            "案件1",
            "赤",
            "ff0000"
        )
        val model2 = ColorConfigModel(
            2,
            "案件2",
            "緑",
            "00ff00"
        )
        val model3 = ColorConfigModel(
            3,
            "案件3",
            "青",
            "0000ff"
        )
        return listOf(model1, model2, model3)

    }
}