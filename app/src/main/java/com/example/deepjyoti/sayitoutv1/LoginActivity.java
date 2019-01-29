package com.example.deepjyoti.sayitoutv1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText uname, pass;
    private ProgressBar loading;
    private Button loginBtn;

    private static String LOGIN_URL = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loading = findViewById(R.id.loading);
        uname = findViewById(R.id.uname);
        pass = findViewById(R.id.pass);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = uname.getText().toString();
                String password = pass.getText().toString();

                if(!username.isEmpty() || !password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Please enter the username and password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
