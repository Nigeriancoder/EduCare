package com.educare.educare;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4ClassRunner.class)
public class SignUpActivityTest {

    @Before
    public void launchActivity(){
        ActivityScenario activityScenario = ActivityScenario.launch(SignUpActivity.class);
    }

    @Test
    public void completeTests(){
        onView(withId(R.id.button_signup)).perform(click());
        onView(withId(R.id.button_login)).perform(click());
        for (int i = 0; i < 16; i++) {
            onView(withId(R.id.next_finish)).perform(click());
        }

    }
}