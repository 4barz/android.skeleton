package com.oiskeletons.android;

import com.oiskeletons.android.util.DaggerOIDaggerComponent;
import com.oiskeletons.android.util.DaggerTestOIDaggerComponent;
import com.oiskeletons.android.util.OISkeletonApplicationBase;
import com.oiskeletons.android.util.TestAppModule;
import com.oiskeletons.android.util.TestOIDaggerComponent;
import com.oiskeletons.android.util.TestOIDaggerModule;

import timber.log.Timber;

/**
 * Created by rubin.apore on 10/30/17.
 */

public class OISkeletonMockApplication extends OISkeletonApplicationBase {

    /**
     * PLEASE DONT ACCESS THIS OBJECT FOR ANY SERIOUS USAGE, IT IS NULL COS ITS MOCKED !!!!!!
     * For your own Sanity, dont use this object
     */
    DaggerOIDaggerComponent oiDaggerComponent;

    /**
     * If for any reason you need access to an instance of OIDaggerComponent, use this
     */
    TestOIDaggerComponent testOIDaggerComponent;
    @Override
    protected void injectComponents() {
        testOIDaggerComponent = DaggerTestOIDaggerComponent.builder()
                .testAppModule(new TestAppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .testOIDaggerModule(new TestOIDaggerModule(GITHUB_BASE_URL))
                .build();
        Timber.i("Using OISkeletonMockApplication to provide application logic");
    }

    /**
     * Use debug implementation plantTimber provided by OISkeletonApplicationBase
     */
    @Override
    protected void plantTimber() {super.plantTimber();}
}
