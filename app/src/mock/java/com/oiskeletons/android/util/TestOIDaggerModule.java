package com.oiskeletons.android.util;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oiskeletons.android.model.user.User;
import com.oiskeletons.android.model.user.UserService;

import org.mockito.Mock;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.Arrays;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.mockito.Mockito.when;

/**
 * Created by rubin.apore on 10/28/17.
 */

/**
 * Dagger graph of all the objects providable
 */
@Module
public class TestOIDaggerModule {
    String mBaseUrl;

    public TestOIDaggerModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    // Application reference must come from TestAppModule.class
    SharedPreferences providesSharedPreferences(Application application) {
        return Mockito.mock(SharedPreferences.class);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {return Mockito.mock(OkHttpClient.class);}

    /**
     * TD: find a better way to mock this
     * @param gson
     * @param okHttpClient
     * @return
     */
    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(mBaseUrl)
                .client(okHttpClient)
                .build();
        return retrofit;
    }

    @Provides
    @Singleton
    UserService provideUserService(Retrofit retrofit) {
        UserService uService = Mockito.mock(UserService.class);
        // provide whens
        when(uService.getUsers()).thenReturn(Arrays.asList(new User("lonerUser")));
        return uService;
    }
}
