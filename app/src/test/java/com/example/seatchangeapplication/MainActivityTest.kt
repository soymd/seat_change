package com.example.seatchangeapplication

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.test.rule.ActivityTestRule
import com.example.seatchangeapplication.common.ArgumentKeys
import com.example.seatchangeapplication.di.SeatChangeViewModelProviders
import com.example.seatchangeapplication.menu.MenuFragment
import com.example.seatchangeapplication.seatchange.SeatChangeFragment
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config

//@RunWith(AndroidJUnit4::class)
@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class MainActivityTest {
    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java)
    lateinit var subject: MainActivity

    lateinit var mockSeatChangeViewModelProviders: SeatChangeViewModelProviders
    lateinit var mockViewModelProvider: ViewModelProvider
    lateinit var mockViewModel: MainViewModel
    lateinit var intent: Intent
    lateinit var controller: ActivityController<MainActivity>

    lateinit var viewModel: MainViewModel
    lateinit var mockRepository: MainRepository

    @Before
    fun setUp() {
        mockSeatChangeViewModelProviders = mockk(relaxed = true)
        mockViewModelProvider = mockk(relaxed = true)
        mockViewModel = mockk(relaxed = true)
        every { mockSeatChangeViewModelProviders.of(any(), any()) } returns mockViewModelProvider
        every { mockViewModelProvider.get(MainViewModel::class.java) } returns mockViewModel

        intent = Intent().apply {
            putExtra(ArgumentKeys.VIEW_MODEL_PROVIDERS.key, mockSeatChangeViewModelProviders)
        }
        controller = Robolectric.buildActivity(MainActivity::class.java, intent)
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
    fun `menuボタン押下で、MenuFragmentが呼ばれる`() {
        // mockではないviewModelを使用するパターンを設定
        mockRepository = mockk(relaxed = true)
        viewModel = MainViewModel(mockRepository)
        every { mockViewModelProvider.get(MainViewModel::class.java) } returns viewModel

        // callMenuEventのobserverを定義
        val observer = mockk<Observer<Void>>(relaxed = true)
        viewModel.callMenuEvent.observeForever(observer)

        subject = controller.create().start().resume().get()

        // menuボタンを押した際に呼ばれるfunctionを実行
        // subject.menuButton.performClick()で直接クリックする方法だと失敗
        viewModel.callMenu()

        // observerの値が変更されたことを確認
        verify { observer.onChanged(null) }

        // 以下の検証が通るなら↑のverifyは不要？
        val fragment = subject.supportFragmentManager.fragments.last()
        assertThat(fragment, instanceOf(MenuFragment::class.java))
    }

    @Test
    fun `injection test`() {
        every { mockViewModel.countGreeting() } returns 999
        subject = controller.create().start().resume().get()

        val actual = subject.test()
        assertThat(actual, equalTo(999))
    }
}

