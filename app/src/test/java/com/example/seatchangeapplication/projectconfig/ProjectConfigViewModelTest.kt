package com.example.seatchangeapplication.projectconfig

import io.mockk.every
import io.mockk.mockk
import org.hamcrest.CoreMatchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

class ProjectConfigViewModelTest {
    private lateinit var subject: ProjectConfigViewModel
    private lateinit var mockProjectConfigRepositoryImpl: ProjectConfigRepositoryImpl

    @Before
    fun setUp() {
        mockProjectConfigRepositoryImpl = mockk<ProjectConfigRepositoryImpl>(relaxed = true)
        subject = ProjectConfigViewModel(mockProjectConfigRepositoryImpl)
    }

    @Test
    fun test() {
        every { mockProjectConfigRepositoryImpl.get() } returns listOf(ProjectConfigModel.from())
        val actual = subject.test()
        val expected = listOf(
            ProjectConfigModel(
                relationStaffProjectId = 0,
                staffName = "",
                projectName = "",
                projectColorValue = ""
            )
        ).toString()
        assertThat(actual, equalTo(expected))
    }
}
