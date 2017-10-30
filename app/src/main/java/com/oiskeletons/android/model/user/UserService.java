package com.oiskeletons.android.model.user;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by rubin.apore on 10/29/17.
 */

public class UserService {
    private Retrofit retrofit;
    @Inject public UserService(Retrofit retrofit) {
        this.retrofit = retrofit;
    }
    public List<User> getUsers() {
        return Arrays.asList(new User("rubin"), new User("apore"));
    }
}