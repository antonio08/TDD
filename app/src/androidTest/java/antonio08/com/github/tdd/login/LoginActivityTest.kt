/**
 * Created by Antonio Lozano on 2020-02-06.
 */
package antonio08.com.github.tdd.login

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import antonio08.com.github.tdd.R
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    private val activityTestRule = ActivityTestRule<LoginActivity>(LoginActivity::class.java)

    @Test
    fun checkUserNameEditTextIsDisplayed(){
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.mUserNameInput)).check(matches(isDisplayed()))
    }

    @Test
    fun checkErrorMessageIsDisplayedForEmptyData(){
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.mLoginButton)).check(matches(isDisplayed())).perform(click())
        onView(withText("Please check Username or Password.")).check(matches(isDisplayed()))
    }

    @Test
    fun checkLoginSuccess(){
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.mUserNameInput)).perform(typeText("Antonio"),
            closeSoftKeyboard())

        onView(withId(R.id.mUserPassword)).perform(typeText("password"),
            closeSoftKeyboard())

        onView(withId(R.id.mLoginButton)).check(matches(isDisplayed())).perform(click())

        onView(withText("Login successful.")).check(matches(isDisplayed()))
    }

}