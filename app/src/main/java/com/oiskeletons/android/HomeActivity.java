package com.oiskeletons.android;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.oiskeletons.android.model.user.UserService;

import java.sql.Time;

import javax.inject.Inject;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import timber.log.Timber;

/**
 * OI's implementation of the AppCompatActivity, the intention is take advantage of
 * <a href="{@docRoot}tools/extras/support-library.html">support library</a> action bar features.
 */
public class HomeActivity extends AppCompatActivity {

    @Inject OkHttpClient okHttpClient;
    @Inject SharedPreferences sharedPreferences;
    @Inject Retrofit retrofit;

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    /**
     * One of the lifecycle methods that is called when the activity if created
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        ((OISkeletonApplication)getApplication()).getNetComponent().inject(this);

        Timber.i("injected objects" + okHttpClient.toString());

        UserService userService = new UserService(retrofit);

        Timber.i("the number of users " + userService.getUsers().size());
    }

}
