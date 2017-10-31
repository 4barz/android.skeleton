package com.oiskeletons.android.model.user;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by rubin.apore on 10/30/17.
 */

public interface UserAPIService {
    @GET("users")
    Call<List<User>> getUsers();
}