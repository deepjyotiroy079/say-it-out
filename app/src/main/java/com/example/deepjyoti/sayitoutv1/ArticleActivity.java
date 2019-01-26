package com.example.deepjyoti.sayitoutv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ArticleActivity extends AppCompatActivity {
    private static final String TAG = "ArticleActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        Log.d(TAG, "onCreate: started");
    }
}
