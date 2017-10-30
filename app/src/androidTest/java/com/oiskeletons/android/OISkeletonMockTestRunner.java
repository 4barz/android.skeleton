package com.oiskeletons.android;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

import com.oiskeletons.android.util.OISkeletonApplication;

import timber.log.Timber;

/**
 * Created by rubin.apore on 10/30/17.
 */

public class OISkeletonMockTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Timber.i("Getting newApplication from custom test runner");
        return super.newApplication(cl, OISkeletonApplication.class.getName(), context);
    }
}
