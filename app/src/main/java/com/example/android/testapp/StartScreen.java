package com.example.android.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

public class StartScreen extends AppCompatActivity {

Button start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);
    }
    void start(View view){
        start = (Button)view;

        Intent intent = new Intent(StartScreen.this,Form1.class);
        startActivity(intent);
    }

}
