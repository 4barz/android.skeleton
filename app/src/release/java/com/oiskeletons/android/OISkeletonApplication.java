package com.oiskeletons.android;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by rubin.apore on 10/28/17.
 */

public class OISkeletonApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree(){
            @Override
            protected String createStackElementTag(StackTraceElement element) {
                return super.createStackElementTag(element) + ":" + element;
            }
        });
    }
}
