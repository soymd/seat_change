package com.example.seatchangeapplication

import android.content.Intent
import com.example.seatchangeapplication.projectconfig.MenuFragment
import com.example.seatchangeapplication.seatchange.SeatChangeFragment
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class MainActivityTest {
    lateinit var subject: MainActivity

    @Before
    fun setUp() {
    }

    @Test
    fun `onResume時に、SeatChangeFragmentが呼ばれる`() {
        subject = Robolectric.buildActivity(
            MainActivity::class.java,
            Intent()
        ).create().start().resume().get()

        val fragment = subject.supportFragmentManager.fragments.last()
        assertThat(fragment, instanceOf(SeatChangeFragment::class.java))
    }

    @Test
    fun `切り替えボタン押下で、ProjectConfigFragmentが呼ばれる`() {
        subject = Robolectric.buildActivity(
            MainActivity::class.java,
            Intent()
        ).create().start().resume().get()

        subject.dataBinding.projectConfigButton.performClick()

        val fragment = subject.supportFragmentManager.fragments.last()
        assertThat(fragment, instanceOf(MenuFragment::class.java))
    }
}