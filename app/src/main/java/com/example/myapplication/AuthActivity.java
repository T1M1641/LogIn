package com.example.myapplication;

import static com.example.myapplication.MainActivity.DATA_USER;
import static com.example.myapplication.MainActivity.PASSWORD;
import static com.example.myapplication.MainActivity.USERNAME;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class AuthActivity extends AppCompatActivity {

    EditText mEdit1,  mEdit2;
    Button signIn;
    SharedPreferences mSharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        mEdit1 = (EditText) findViewById(R.id.et1);
        mEdit2 = (EditText) findViewById(R.id.et2);

        signIn = findViewById(R.id.signIn);

        mSharedPref = getSharedPreferences(DATA_USER, Context.MODE_PRIVATE);
        String saved_name = mSharedPref.getString(USERNAME, "");
        String saved_pass = mSharedPref.getString(PASSWORD, "");
        signIn.setOnClickListener(view -> {
            if (mEdit1.equals(mEdit2)){
                Toast.makeText(this, "Логин и пароль не должны совпадать", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!mEdit1.getText().toString().equals(saved_name)){
                Toast.makeText(this, "Неверный Логин", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!mEdit2.getText().toString().equals(saved_pass)){
                Toast.makeText(this, "Неверный Пароль", Toast.LENGTH_SHORT).show();
                return;
            }
            Snackbar.make(view, "Успешно!", Snackbar.LENGTH_SHORT).show();
        });
    }
}