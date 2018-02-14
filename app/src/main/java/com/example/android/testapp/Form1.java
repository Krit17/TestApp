package com.example.android.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Form1 extends AppCompatActivity {
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form1);

    }

    public void next(View view){
        button = (Button)view;
        String id = button.getId()+"";
        Bundle bundle=new Bundle();
        bundle.putString("id",id);
        Intent intent=new Intent(Form1.this,Form2.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
