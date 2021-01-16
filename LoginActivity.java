package com.example.videocaller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button login,register;

    FirebaseAuth auth;

    ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dialog=new ProgressDialog(this);
        dialog.setMessage("Please wait....");



        auth=FirebaseAuth.getInstance();

        email=findViewById(R.id.txt_email);
        password=findViewById(R.id.txt_password);
        login=findViewById(R.id.btn_login);
        register=findViewById(R.id.btn_Register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
            }
        });

        login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                     dialog.show();
                     String mail,pass;
                     mail=email.getText().toString();
                     pass=password.getText().toString();
                     auth.signInWithEmailAndPassword(mail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                             dialog.dismiss();
                             if(task.isSuccessful()) {


                                 startActivity(new Intent(LoginActivity.this, DashboardActivity.class));

                             } else  {
                                 Toast.makeText(LoginActivity.this,"Loging faild",Toast.LENGTH_SHORT).show();
                             }
                         }
                     });
            }
        });
    }
}