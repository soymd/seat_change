package com.example.seatchangeapplication.menu

//import com.example.seatchangeapplication.colorconfig.ColorConfigFragment
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.runner.AndroidJUnit4
import com.example.seatchangeapplication.FragmentType
import com.example.seatchangeapplication.MainActivity
import com.example.seatchangeapplication.R
import com.example.seatchangeapplication.colorconfig.ColorConfigFragment
import com.example.seatchangeapplication.common.ArgumentKeys
import com.example.seatchangeapplication.di.SeatChangeViewModelProviders
import com.example.seatchangeapplication.projectconfig.ProjectConfigFragment
import com.example.seatchangeapplication.seatchange.SeatChangeFragment
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.hamcrest.CoreMatchers.instanceOf
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
//@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class MenuFragmentTest {
//    @get:Rule
//    var taskExecutorRule = InstantTaskExecutorRule()

    private lateinit var subject: MenuFragment
    lateinit var mockSeatChangeViewModelProviders: SeatChangeViewModelProviders
    lateinit var mockViewModelProvider: ViewModelProvider
    private lateinit var viewModel: MenuViewModel

    lateinit var fragmentManager: FragmentManager
    private lateinit var scenario: FragmentScenario<MenuFragment>

    lateinit var bundle: Bundle


    @Before
    fun setUp() {
        subject = MenuFragment()
        mockSeatChangeViewModelProviders = mockk(relaxed = true)
        mockViewModelProvider = mockk(relaxed = true)

        viewModel = MenuViewModel()
        every { mockSeatChangeViewModelProviders.of(any(), any()) } returns mockViewModelProvider
        every { mockViewModelProvider.get(MenuViewModel::class.java) } returns viewModel

        bundle = Bundle().apply {
            putSerializable(ArgumentKeys.VIEW_MODEL_PROVIDERS.key, mockSeatChangeViewModelProviders)
        }
        subject.arguments = bundle

        // espressoを使わない場合用
        fragmentManager = Robolectric.buildActivity(MainActivity::class.java)
            .create().start().resume().get().supportFragmentManager
    }


    // TODO:perform(click())で落下
    @Ignore
    @Test
    fun `espresso ColorConfigButton押下でColorConfigFragment呼び出し`() {
        scenario = launchFragmentInContainer<MenuFragment>()

        // ↓Fragmentを呼び出さないボタンは実行可能
        onView(withId(R.id.hogeButton)).perform(click())

        // 可視状態にはなっている模様
        onView(withId(R.id.colorConfigButton)).check(matches(isDisplayed()))
        onView(withId(R.id.seatChangeButton)).check(matches(isDisplayed()))
        onView(withId(R.id.projectConfigButton)).check(matches(isDisplayed()))

        // 実行不可
        onView(withId(R.id.colorConfigButton)).perform(click())
        onView(withId(R.id.seatChangeButton)).perform(click())
        onView(withId(R.id.projectConfigButton)).perform(click())
    }

    @Test
    fun `ColorConfigButton押下でColorConfigFragment呼び出し`() {
        // fragmentの遷移をテストするにはespressoを使わずに起動するしかないっぽい
        fragmentManager.beginTransaction().add(subject, null).commit()

        val observer = mockk<Observer<FragmentType>>(relaxed = true)
        viewModel.callFragmentEvent.observeForever(observer)

        viewModel.callFragment(FragmentType.COLOR_CONFIG)

        verify { observer.onChanged(FragmentType.COLOR_CONFIG) }

        val nextFragment = subject.parentFragmentManager.fragments.last()
        assertThat(nextFragment, instanceOf(ColorConfigFragment::class.java))
    }

    @Test
    fun `ProjectConfigButton押下でProjectConfigFragment呼び出し`() {
        fragmentManager.beginTransaction().add(subject, null).commit()

        val observer = mockk<Observer<FragmentType>>(relaxed = true)
        viewModel.callFragmentEvent.observeForever(observer)

        viewModel.callFragment(FragmentType.PROJECT_CONFIG)

        verify { observer.onChanged(FragmentType.PROJECT_CONFIG) }

        val nextFragment = subject.parentFragmentManager.fragments.last()
        assertThat(nextFragment, instanceOf(ProjectConfigFragment::class.java))
    }

    @Test
    fun `SeatChangeButton押下でSeatChangeFragment呼び出し`() {
        fragmentManager.beginTransaction().add(subject, null).commit()

        val observer = mockk<Observer<FragmentType>>(relaxed = true)
        viewModel.callFragmentEvent.observeForever(observer)

        viewModel.callFragment(FragmentType.SEAT_CHANGE)

        verify { observer.onChanged(FragmentType.SEAT_CHANGE) }

        val nextFragment = subject.parentFragmentManager.fragments.last()
        assertThat(nextFragment, instanceOf(SeatChangeFragment::class.java))
    }
}