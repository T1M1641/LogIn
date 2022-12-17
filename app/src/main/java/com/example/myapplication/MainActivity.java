package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mEdit1,  mEdit2;
    Button save_button, load_button, authBtn;
    SharedPreferences mSharedPref;
    public static final String DATA_USER = "Сохранённые данные";
    public static final String USERNAME = "Сохраненное имя";
    public static final String PASSWORD = "Сохраненный пароль";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEdit1 = (EditText) findViewById(R.id.et1);
        mEdit2 = (EditText) findViewById(R.id.et2);
        save_button = (Button) findViewById(R.id.button1);
        load_button = (Button) findViewById(R.id.button2);
        authBtn = findViewById(R.id.authBtn);
        authBtn.setOnClickListener(view -> {
            startActivity(new Intent(this, AuthActivity.class));
        });
    }

    public void save(View view) {
        mSharedPref = getSharedPreferences(DATA_USER, Context.MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPref.edit();
        mEditor.putString(USERNAME, mEdit1.getText().toString());
        mEditor.putString(PASSWORD, mEdit2.getText().toString());
        mEditor.apply();
        Toast.makeText(this, "Данные сохранены", Toast.LENGTH_LONG).show();

    }

    public void load(View view) {
        mSharedPref = getSharedPreferences(DATA_USER, Context.MODE_PRIVATE);
        String saved_name = mSharedPref.getString(USERNAME, "");
        String saved_pass = mSharedPref.getString(PASSWORD, "");
        mEdit1.setText(saved_name);
        mEdit2.setText(saved_pass);
        Toast.makeText(this, "Данные загружены", Toast.LENGTH_LONG).show();
    }
}
