package com.example.marchenkosergey.loginandpassword;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    EditText password;
    EditText login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2_main);
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
    }


    public void signUp(View view) { // Передача данных и переход к 1 активности
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
        intent.putExtra("login", login.getText());
        intent.putExtra("password", password.getText());
        setResult(RESULT_OK, intent);
        finish();
    }
}
