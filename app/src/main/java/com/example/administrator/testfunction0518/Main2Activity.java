package com.example.administrator.testfunction0518;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.administrator.testfunction0518.function.TestOneFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main2Activity extends AppCompatActivity {
    TestOneFunction testOne;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        test01();       //activity讀resource
        test02();       //外部class讀resource
        test03();       //activity讀resource
        test04();       //activity存入SharedPreferences
        test05();       //外部class讀SharedPreferences
        test06();       //讀Assets
        test07();       //讀取外部記憶體，需要存取權限，另外在說
    }

    private void test01() {
        Resources res = this.getResources();
        String str = res.getString(R.string.app_test01);
        Toast.makeText(this, str + "1", Toast.LENGTH_SHORT).show();
    }

    private void test02() {
        testOne = new TestOneFunction(this);
        testOne.showMassage();
    }

    private void test03() {
        String str = this.getString(R.string.app_test01);
        Toast.makeText(this, str + "3", Toast.LENGTH_SHORT).show();
    }

    private void test04() {
        //打開存取偏好檔，內部存取記憶體，會隨著app刪除一並刪除
        //(name,mode) 在這表示私有資料
        SharedPreferences sharedSetting01 = getSharedPreferences("name", MODE_PRIVATE);
        sharedSetting01.edit()
                .putString("key1","key01")
                .putString("key2",this.getString(R.string.app_test02))
                .putString("key3",321 + "")
                .apply();
    }

    private void test05() {
        testOne.showSharedPreferencesData();
    }

    private void test06() {
        try {
            InputStream input = getAssets().open("test01.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String str = br.readLine();
            Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void test07() {

    }
}
