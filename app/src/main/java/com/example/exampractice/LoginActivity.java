package com.example.exampractice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    TextView usernameTv, passwordTv;
    Button loginBtn;

    public  static final String USERNAME = "username_key";
    public static  final String PASSWORD = "password_key";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);
        usernameTv = findViewById(R.id.username_et);
        passwordTv = findViewById(R.id.password_et);
        loginBtn = findViewById(R.id.login_btn);



        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeInt =  new Intent(LoginActivity.this,HomeActivity.class);
                homeInt.putExtra(USERNAME,usernameTv.getText().toString());
                homeInt.putExtra(PASSWORD,passwordTv.getText().toString());
                startActivity(homeInt);
                Toast.makeText(LoginActivity.this,passwordTv.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });







    }
}
