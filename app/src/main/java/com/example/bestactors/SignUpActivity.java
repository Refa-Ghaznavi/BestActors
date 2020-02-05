package com.example.bestactors;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    EditText etEmail,etPassword,etConfPassword;

    Button btnSignUp;

    TextView tvLogin;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        mAuth=FirebaseAuth.getInstance();



        etEmail=findViewById(R.id.etEmailSignUp);
        etConfPassword=findViewById(R.id.etConfPassword);
        etPassword=findViewById(R.id.etPasswordSignUp);

        tvLogin=findViewById(R.id.tvLogin);

        btnSignUp=findViewById(R.id.btnSignUp);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=etEmail.getText().toString();
                String password=etPassword.getText().toString();


                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            Intent intent=new Intent(SignUpActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();

                        }

                        else {


                            Toast.makeText(SignUpActivity.this, "There is a problem in Sign iN", Toast.LENGTH_SHORT).show();
                        }


                    }
                });



            }
        });







    }
}