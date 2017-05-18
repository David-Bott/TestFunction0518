package com.example.administrator.testfunction0518.function;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.widget.Toast;

import com.example.administrator.testfunction0518.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Administrator on 2017/5/18.
 */

public class TestOneFunction {
    Activity activity;
    Resources res;
    String testOne;

    public TestOneFunction() {
        testOne = "2";
    }

    public TestOneFunction(Activity activity) {
        this();
        this.activity = activity;
    }

    public void showMassage() {
        res = activity.getResources();
        Toast.makeText(activity, res.getString(R.string.app_test01) + testOne , Toast.LENGTH_SHORT).show();
    }

    public void showSharedPreferencesData() {
        SharedPreferences sharedSetting02 = this.activity.getSharedPreferences("name", MODE_PRIVATE);
        String str01 = sharedSetting02.getString("key1","no");
        String str02 = sharedSetting02.getString("key2","no");
        String str03 = sharedSetting02.getString("key3","no");
        Toast.makeText(activity, str01 + "-" + str02 + "-" + str03, Toast.LENGTH_SHORT).show();
    }
}
