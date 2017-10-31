package com.oiskeletons.android;

import android.content.SharedPreferences;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import com.oiskeletons.android.model.user.UserService;
import com.oiskeletons.android.ui.HomeActivity;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import okhttp3.OkHttpClient;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by rubin.apore on 10/30/17.
 */
@LargeTest
public class HomeActivityTest {

    @Mock
    OkHttpClient okHttpClient;
    @Mock
    SharedPreferences sharedPreferences;

    @Mock
    UserService userService;

    @Rule
    public ActivityTestRule<HomeActivity> hActivityRule = new ActivityTestRule<HomeActivity>(HomeActivity.class);

    @Test
    public void viewExist() {
        // this is how you call activity methods
        hActivityRule.getActivity().doRandomStuff();
        onView(withId(R.id.messageId)).check(matches(isDisplayed()));
    }

}