package com.example.seatchangeapplication

import io.mockk.every
import io.mockk.mockk
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

class MainViewModelTest {
    lateinit var mockMainRepository: MainRepository
    lateinit var subject: MainViewModel

    @Before
    fun setUp() {
        mockMainRepository = mockk()
        subject = MainViewModel(mockMainRepository)
    }

    @Test
    fun foo() {
        every { mockMainRepository.getGreeting() } returns "hogehoge"

        val actural = subject.countGreeting()
        val expected = 8

        assertThat(actural, equalTo(expected))

    }
}