package com.oiskeletons.android.util;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by rubin.apore on 10/28/17.
 */
@Module
public class AppModule {

    Application oiApplication;

    public AppModule(Application application) {
        oiApplication = application;
    }

    @Provides @Singleton
    Application providesApplication() {
        return oiApplication;
    }
}
