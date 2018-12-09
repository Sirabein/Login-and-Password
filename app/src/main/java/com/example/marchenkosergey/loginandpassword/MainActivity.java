package com.example.marchenkosergey.loginandpassword;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {

    String passwordTrue = "6wVQDoYr";
    EditText login;
    EditText passwordEditText;
    TextView check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        check = findViewById(R.id.check);
        passwordEditText = findViewById(R.id.password);
        login = findViewById(R.id.login);

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }
            @Override
            public void afterTextChanged(Editable s) {  // Проверка пароля
                if (passwordEditText.getText().toString().equals(passwordTrue)) {
                    check.setText("Correct Password");
                } else check.setText("Wrong Password");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) { // Получение данных
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            login.setText(data.getExtras().get("login").toString());
            passwordTrue = data.getExtras().get("password").toString();
        }

    }

    public void logIn(View view) {  // Переход к 2 активности
        if (passwordEditText.getText().toString().equals(passwordTrue)) {
        } else {
            Intent logIn = new Intent(MainActivity.this, Main2Activity.class);
            startActivityForResult(logIn, 1);
        }
    }
}
