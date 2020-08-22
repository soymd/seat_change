package com.example.seatchangeapplication

import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.example.seatchangeapplication.common.ArgumentKeys
import com.example.seatchangeapplication.di.SeatChangeViewModelProviders
import com.example.seatchangeapplication.menu.MenuFragment
import com.example.seatchangeapplication.seatchange.SeatChangeFragment
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.android.controller.ActivityController
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
//@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class MainActivityTest {
//    @get:Rule
//    var activityRule = ActivityTestRule(MainActivity::class.java)

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
        println("セットアップ開始")
        mockSeatChangeViewModelProviders = mockk(relaxed = true)
        mockViewModelProvider = mockk(relaxed = true)

        mockRepository = mockk(relaxed = true)
        viewModel = MainViewModel(mockRepository)

        // mockViewModelを返却するパターン
        mockViewModel = mockk(relaxed = true)
        every { mockSeatChangeViewModelProviders.of(any(), any()) } returns mockViewModelProvider
        every { mockViewModelProvider.get(MainViewModel::class.java) } returns mockViewModel
        intent = Intent().apply {
            putExtra(ArgumentKeys.VIEW_MODEL_PROVIDERS.key, mockSeatChangeViewModelProviders)
        }

        // robolectricテスト用controllerを作成 espressoの場合は使わない
        controller = Robolectric.buildActivity(MainActivity::class.java, intent)
        println("セットアップ終了")
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
        // mockではないviewModelを返却
        every { mockViewModelProvider.get(MainViewModel::class.java) } returns viewModel

        // callMenuEventのobserverを定義
        val observer = mockk<Observer<Void>>(relaxed = true)
        viewModel.callMenuEvent.observeForever(observer)

        // espressoじゃないときのactivity起動方法
        subject = controller.create().start().resume().get()

        // menuボタンを押した際に呼ばれるfunctionを実行
        // subject.menuButton.performClick()で直接クリックする方法だと失敗
        viewModel.callMenu()

        val fragment = subject.supportFragmentManager.fragments.last()
        assertThat(fragment, instanceOf(MenuFragment::class.java))

        // ↑の検証が通るならobserverのverifyは不要だが一応残しておく
        verify { observer.onChanged(null) }
    }

    @Test
    fun `espresso版 menuボタン押下で、MenuFragmentが呼ばれる`() {
        // mockではないviewModelを返却
        every { mockViewModelProvider.get(MainViewModel::class.java) } returns viewModel

        // espressoテストを実行する場合は以下のようにactivityを起動
        val activityRule = ActivityTestRule(MainActivity::class.java)
        activityRule.launchActivity(intent)

        // callMenuEventのobserverを定義
        val observer = mockk<Observer<Void>>(relaxed = true)
        viewModel.callMenuEvent.observeForever(observer)

        onView(withId(R.id.menuButton)).perform(click())

        // observerの値が変更されたことを確認
        verify { observer.onChanged(null) }
    }
}

