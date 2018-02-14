package com.example.android.testapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity2 extends AppCompatActivity {

    Button button;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    EditText email,password;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        Intent intent=getIntent();
        bundle=intent.getExtras();
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        button = (Button)findViewById(R.id.submit);

        mAuth = FirebaseAuth.getInstance();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
            }
        });
    }
    public void LoginUser(){
        String emailId = email.getEditableText().toString().trim();
        String pass = password.getEditableText().toString().trim();

        if (emailId.isEmpty()){
            email.setError("Enter a valid email");
            email.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(emailId).matches()){
            email.setError("");
            email.requestFocus();
            return;
        }

        if (pass.isEmpty()){
            password.setError("Enter a password");
            password.requestFocus();
            return;
        }

        if (pass.length()<6){
            password.setError("Minimum length required: 6");
            password.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(emailId,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent=new Intent(LoginActivity2.this,ProfileActivity.class);
                    intent.putExtras(bundle);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
