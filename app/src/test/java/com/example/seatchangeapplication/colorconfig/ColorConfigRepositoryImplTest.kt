package com.example.seatchangeapplication.colorconfig

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.seatchangeapplication.manager.DbManager
import io.mockk.every
import io.mockk.mockk
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class ColorConfigRepositoryImplTest {
    lateinit var subject: ColorConfigRepositoryImpl
    lateinit var mockDbManager: DbManager
    lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        mockDbManager = mockk(relaxed = true)
        subject = ColorConfigRepositoryImpl(mockDbManager)
    }

    @Test
    fun get() {
        val model = ColorConfigModel.from()
        model.projectName = "hogehoge"
        every { mockDbManager.getProjectColorModels() } returns listOf(model)

        val actual = subject.get()
        val expected = listOf(model)
        assertThat(actual, equalTo(expected))
    }
}