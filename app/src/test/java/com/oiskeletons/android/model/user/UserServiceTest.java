package com.oiskeletons.android.model.user;

import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import timber.log.Timber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created by rubin.apore on 10/30/17.
 */

public class UserServiceTest {
    OkHttpClient okHttpClient = Mockito.mock(OkHttpClient.class);

    UserAPIService userAPIService = Mockito.mock(UserAPIService.class);

    UserService userService;


    @BeforeEach
    void setUp() {
        userService = new UserService(userAPIService);
    }
    @AfterEach
    void tearDown() {}

    @Test
    public void getUsers() {
       List<User> users = userService.getUsers();
        assertNotNull(users);
        assertEquals(users.size(), 2);
    }

}