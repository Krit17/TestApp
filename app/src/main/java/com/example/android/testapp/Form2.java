package com.example.android.testapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.android.testapp.R.id.login;
import static com.example.android.testapp.R.id.radioButton;

public class Form2 extends AppCompatActivity {

    Button button;
    Bundle bundle;
    RadioGroup radioGroup;
    EditText weight,height,dob;
    ImageButton girl,boy;
    String selectedtext;
    RadioButton radioButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);
        Intent intent = getIntent();
        bundle = intent.getExtras();
        button = (Button)findViewById(R.id.submit);
        weight = (EditText)findViewById(R.id.weight) ;
        height = (EditText)findViewById(R.id.height);
        dob = (EditText)findViewById(R.id.dob);
        girl = (ImageButton)findViewById(R.id.girl);
        boy = (ImageButton)findViewById(R.id.boy);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);

        girl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(boy.isEnabled()) {
                    boy.setEnabled(false);
                }
                else{
                    boy.setEnabled(true);
                }

            }
        });
        boy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(girl.isEnabled()){
                    girl.setEnabled(false);
                }
                else{
                    girl.setEnabled(true);
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton)radioGroup.findViewById(radioButtonID);
                selectedtext = (String) radioButton.getText();

                bundle.putString("dob",dob.getEditableText().toString());
                bundle.putString("height",height.getEditableText().toString());
                bundle.putString("weight",weight.getEditableText().toString());
                bundle.putString("lifestyle",selectedtext);
                if (girl.isEnabled() && boy.isEnabled()){
                    Toast.makeText(Form2.this,"Select a gender!",Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    if (girl.isEnabled()){
                        bundle.putString("gender","female");
                    }
                    else {
                        bundle.putString("gender","male");
                    }

                }
                Intent intent2=new Intent(Form2.this,LoginActivity.class);
                intent2.putExtras(bundle);
                startActivity(intent2);

            }
        });
    }
}
