package com.oiskeletons.android;

import android.content.SharedPreferences;
import android.support.test.espresso.NoMatchingViewException;
import android.support.test.espresso.ViewAssertion;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.oiskeletons.android.model.user.User;
import com.oiskeletons.android.model.user.UserService;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.mockito.Mockito.when;

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
