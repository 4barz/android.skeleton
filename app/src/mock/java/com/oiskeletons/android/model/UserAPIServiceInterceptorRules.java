package com.oiskeletons.android.model;

import okhttp3.mock.MockInterceptor;
import okhttp3.Response.Builder;
import okhttp3.mock.Rule;

/**
 * Created by rubin.apore on 10/30/17.
 */

public class UserAPIServiceInterceptorRules {

    public static void addRules (MockInterceptor mockInterceptor) {
        mockInterceptor.addRule(new Rule.Builder()
                .get().or().post().or().put()
                .url("https://testserver/api/login")
                .respond(""));
    }
}
