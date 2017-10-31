package com.oiskeletons.android.util;

import android.app.Application;

import timber.log.BuildConfig;
import timber.log.Timber;

/**
 * Created by rubin.apore on 10/28/17.
 */

abstract public class OISkeletonApplicationBase extends Application {
    final public String BASE_API_URL = "";
    final public String BASE_NEWS_URL = "";
    final public String GITHUB_BASE_URL = "https://jsonplaceholder.typicode.com";
    protected OIDaggerComponent oiDaggerComponent;

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
        if(BuildConfig.DEBUG){
        this.plantTimber();
        }

        injectComponents();
    }

    abstract protected void injectComponents();

    protected void plantTimber() {
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

    public OIDaggerComponent getNetComponent() {
        return oiDaggerComponent;
    }
}
