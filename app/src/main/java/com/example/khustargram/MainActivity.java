package com.example.khustargram;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.khustargram.navigation.AlarmFragment;
import com.example.khustargram.navigation.DetailViewFragment;
import com.example.khustargram.navigation.GridFragment;
import com.example.khustargram.navigation.UserFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

// 로그인 이후 작동
public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bottom navigation view
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_home:
                Fragment detailViewFragment = new DetailViewFragment();
                Log.i("TAG", "action_home");

                Bundle bundle_0 = new Bundle();
                bundle_0.putInt("ARG_NO", 0);

                detailViewFragment.setArguments(bundle_0);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_content, detailViewFragment).commit();
                return true;
            case R.id.action_search:
                Fragment gridFragment = new GridFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_content, gridFragment).commit();
                return true;
            case R.id.action_add_photo:
                return true;
            case R.id.action_favorite:
                Fragment alarmFragment = new AlarmFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_content, alarmFragment).commit();
                return true;
            case R.id.action_account:
                Fragment userFragment = new UserFragment();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_content, userFragment).commit();
                return true;
        }
        return false;
    }
}