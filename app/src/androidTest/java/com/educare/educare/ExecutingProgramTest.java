package com.educare.educare;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
//import androidx.test.runner.AndroidJUnit4;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import static org.junit.Assert.*;
import androidx.test.espresso.Espresso.*;
import androidx.test.espresso.action.ViewActions.*;
import androidx.test.espresso.matcher.ViewMatchers.*;
import org.hamcrest.Matcher.*;
import androidx.test.espresso.assertion.ViewAssertions.*;

/*
* If @RunWith(AndroidJUnit4.class) is deprecated, change import from --- import androidx.test.runner.AndroidJUnit4; to
* import androidx.test.ext.junit.runners.AndroidJUnit4;
* */
@RunWith(AndroidJUnit4.class)
public class ExecutingProgramTest {

    @Rule
    public ActivityTestRule<SignUpActivity> mSignUpActivityTest =
            new ActivityTestRule<>(SignUpActivity.class);

    @Test
    public void executeProgram(){
//        add static imports for
        ViewInteraction signupButton = Espresso.onView(ViewMatchers.withId(R.id.button_signup));
        Espresso.onView(ViewMatchers.withId(R.id.text_input_first_name_edit_text)).perform(ViewActions.typeText("Monsuru"));
        Espresso.onView(ViewMatchers.withId(R.id.text_input_first_name_edit_text)).check(ViewAssertions.matches(ViewMatchers.withText("Monsuru")));
                signupButton.check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(ViewActions.closeSoftKeyboard(), ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.button_login)).perform(ViewActions.click());
        for (int i = 0; i < 16; i++){
            Espresso.onView(ViewMatchers.withId(R.id.next_finish)).perform(ViewActions.click());
        }
        Espresso.onView(ViewMatchers.withId(R.id.finish)).perform(ViewActions.click());
    }
}