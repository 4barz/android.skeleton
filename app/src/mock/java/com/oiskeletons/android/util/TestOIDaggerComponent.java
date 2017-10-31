package com.oiskeletons.android.util;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by rubin.apore on 10/28/17.
 */

/**
 * Provide dagger component for mock env
 */
@Singleton
@Component(modules={TestAppModule.class, TestOIDaggerModule.class})
public interface TestOIDaggerComponent extends OIDaggerComponent{}