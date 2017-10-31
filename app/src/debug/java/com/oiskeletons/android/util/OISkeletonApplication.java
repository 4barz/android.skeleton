package com.oiskeletons.android.util;

import com.oiskeletons.android.util.AppModule;
import com.oiskeletons.android.util.DaggerOIDaggerComponent;
import com.oiskeletons.android.util.OIDaggerModule;
import com.oiskeletons.android.util.OISkeletonApplicationBase;

/**
 * Created by rubin.apore on 10/28/17.
 */

/**
 * OI's custom implementation of the standard android application class
 * debug version
 */

public class OISkeletonApplication extends OISkeletonApplicationBase {
    @Override
    protected void injectComponents() {
        oiDaggerComponent = DaggerOIDaggerComponent.builder()
                .appModule(new AppModule(this))
                .oIDaggerModule(new OIDaggerModule(GITHUB_BASE_URL))
                .build();
    }

    /**
     * Use debug implementation plantTimber provided by OISkeletonApplicationBase
     */
    @Override
    protected void plantTimber() {super.plantTimber();}
}