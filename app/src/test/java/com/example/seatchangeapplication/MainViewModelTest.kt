package com.example.seatchangeapplication

import io.mockk.every
import io.mockk.mockk
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Before

import org.junit.Assert.*
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
        every { mockMainRepository.getHoge() } returns "hogehoge"

        val actural = subject.count()
        val expected = 8

        assertThat(actural, equalTo(expected))

    }
}