package com.oiskeletons.android;

import com.oiskeletons.android.util.OISkeletonApplicationBase;
import com.oiskeletons.android.util.ReleaseTimberLogTree;
import timber.log.Timber;

/**
 * Created by rubin.apore on 10/28/17.
 */
/**
 * OI's custom implementation of the standard android application class
 * release version
 */
public class OISkeletonApplication extends OISkeletonApplicationBase {
    final public String BASE_API_URL = "";
    final public String BASE_NEWS_URL = "";
    final public String GITHUB_BASE_URL = "";

    /**
     * Use debug implementation plantTimber provided by OISkeletonApplicationBase
     */
    @Override
    protected void plantTimber() {
        Timber.plant(new ReleaseTimberLogTree());
    }
}
