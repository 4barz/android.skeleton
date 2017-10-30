package com.oiskeletons.android.util;

import com.oiskeletons.android.HomeActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rubin.apore on 10/28/17.
 */

@Singleton
@Component(modules={TestAppModule.class, TestOIDaggerModule.class})
public interface TestOIDaggerComponent extends OIDaggerComponent{
    void inject(HomeActivity activity);
    // void inject(MyFragment fragment);
    // void inject(MyService service);
}
