package com.oiskeletons.android.util;

/**
 * Created by rubin.apore on 10/28/17.
 */

import timber.log.Timber;

/**
 * OI's custom implementation of the standard android application class
 * debug:mock version
 */
public class OISkeletonApplication extends OISkeletonApplicationBase {

    @Override
    protected void injectComponents() {
        oiDaggerComponent = DaggerTestOIDaggerComponent.builder()
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
