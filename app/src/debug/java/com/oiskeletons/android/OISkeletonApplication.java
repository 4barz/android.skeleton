package com.oiskeletons.android;

import android.app.Application;

import timber.log.Timber;

/**
 * Created by rubin.apore on 10/28/17.
 */

/**
 * OI's custom implementation of the standard android application class
 * debug version
 */
public class OISkeletonApplication extends Application {
    /**
     * Called when the application is starting, before any activity,
     * service, or receiver objects (excluding content providers) have been created.
     * Implementations should be as quick as possible (for example using lazy initialization of state)
     * since the time spent in this function directly impacts the performance of starting the first activity,
     * service, or receiver in a process
     */
    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree(){
            /**
             * Create a custom tag for our logger
             *
             * @param element An object holding stacktrace information, like linenumber
             * @return A string used in tagging the log message
             */
            @Override
            protected String createStackElementTag(StackTraceElement element) {
                return super.createStackElementTag(element) + ":" + element.getLineNumber();
            }
        });
    }
}
