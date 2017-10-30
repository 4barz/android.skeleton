package com.oiskeletons.android.util;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rubin.apore on 10/28/17.
 */
@Module
public class TestAppModule {

    Application oiApplication;

    public TestAppModule(Application application) {
        // super(application);
        oiApplication = application;
    }

    @Provides @Singleton
    Application providesApplication() {
        return oiApplication;
    }
}
