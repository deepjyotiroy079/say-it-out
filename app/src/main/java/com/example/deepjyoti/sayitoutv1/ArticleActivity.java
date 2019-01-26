package com.example.deepjyoti.sayitoutv1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity {
    private static final String TAG = "ArticleActivity";
    private Context context;
    private Bundle extras;
    private TextView article_title, article_content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        Log.d(TAG, "onCreate: started");

        context = ArticleActivity.this;

        article_title = findViewById(R.id.article_title);
        article_content = findViewById(R.id.article_content);

        extras = getIntent().getExtras();

        if(!extras.equals(null)) {
            String a_title = extras.getString("article_title");
            String a_content = extras.getString("article_content");
            // Log.d(TAG, "onCreate: data is "+a_title);
            // Log.d(TAG, "onCreate: content is "+a_content);
            article_title.setText(a_title);
            article_content.setText(a_content);
        }
    }
}
