package com.example.deepjyoti.sayitoutv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class AboutActivity extends AppCompatActivity {

    // private Button button;
    private CircleImageView profile_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // button = findViewById(R.id.go_back);
        profile_img = findViewById(R.id.profile_img);
        Glide.with(this).load("https://deepjyotiroy079.github.io/images/profile.png").into(profile_img);


    }
}
