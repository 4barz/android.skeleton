package com.oiskeletons.android.model.user;

import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by rubin.apore on 10/29/17.
 */

public class UserService {
    private UserAPIService userAPIService;

    @Inject public UserService(UserAPIService userAPIService) {
        this.userAPIService = userAPIService;
    }
    public List<User> getUsers() {
        userAPIService.getUsers()
                .enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        Timber.i("the response " + response.body().size());
                        for(int x = response.body().size() - 1; x >= 0; x--) {
                            Timber.i("user has name " + response.body().get(x).getName());
                        }
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        Timber.i("the response " + t.getMessage());
                    }
                });
        return Arrays.asList(new User("rubin"), new User("apore"));
    }
}