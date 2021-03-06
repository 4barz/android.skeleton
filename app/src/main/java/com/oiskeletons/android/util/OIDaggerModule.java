package com.oiskeletons.android.util;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oiskeletons.android.model.user.UserAPIService;
import com.oiskeletons.android.model.user.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rubin.apore on 10/28/17.
 */

/**
 * Dagger graph of all the objects providable
 */
@Module
public class OIDaggerModule {
    protected String mBaseUrl;

    public OIDaggerModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    @Provides
    @Singleton
    // Application reference must come from TestAppModule.class
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
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
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // builder.addInterceptor()
        // builder.cache(); //setCache(cache);
        return builder.build();
    }

    @Provides
    @Singleton
    UserAPIService provideUserAPIService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        // use real interface
        return retrofit.create(UserAPIService.class);
    }

    @Provides
    @Singleton
    UserService provideUserService(UserAPIService userAPIService) {
        return new UserService(userAPIService);
    }
}