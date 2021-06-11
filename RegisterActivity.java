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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth auth;
    EditText username,e_mai,password;
    Button login,register;

    FirebaseFirestore database;

    ProgressDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        dialog=new ProgressDialog(this);
        dialog.setMessage("Creating Account....");
		
		dialog=new ProgressDialog(this);
        dialog.setMessage("Creating Account is have active");



        database=FirebaseFirestore.getInstance();

        auth=FirebaseAuth.getInstance();

        username=findViewById(R.id.txt_name);
        e_mai=findViewById(R.id.txt_email);
        password=findViewById(R.id.txt_password);
        login=findViewById(R.id.btn_login);
        register=findViewById(R.id.btn_Register);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                String name,email,pass;
                email=e_mai.getText().toString();
                name=username.getText().toString();
                pass=password.getText().toString();

                final User user=new User();
                user.setEmail(email);
                user.setPass(pass);
                user.setName(name);

                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.dismiss();
                        if(task.isSuccessful()) {

                            database.collection("User").document().set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                                }
                            });



                        }
                        else

                            {
                            Toast.makeText(RegisterActivity.this,"Account Not Created",Toast.LENGTH_SHORT).show();
                            }
                    }
                });
            }
        });

    }
}
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
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth auth;
    EditText username,e_mai,password;
    Button login,register;

    FirebaseFirestore database;

    ProgressDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        dialog=new ProgressDialog(this);
        dialog.setMessage("Creating Account....");
		
		dialog=new ProgressDialog(this);
        dialog.setMessage("Creating Account is have active");



        database=FirebaseFirestore.getInstance();

        auth=FirebaseAuth.getInstance();

        username=findViewById(R.id.txt_name);
        e_mai=findViewById(R.id.txt_email);
        password=findViewById(R.id.txt_password);
        login=findViewById(R.id.btn_login);
        register=findViewById(R.id.btn_Register);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                String name,email,pass;
                email=e_mai.getText().toString();
                name=username.getText().toString();
                pass=password.getText().toString();

                final User user=new User();
                user.setEmail(email);
                user.setPass(pass);
                user.setName(name);

                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.dismiss();
                        if(task.isSuccessful()) {

                            database.collection("User").document().set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                                }
                            });



                        }
                        else

                            {
                            Toast.makeText(RegisterActivity.this,"Account Not Created",Toast.LENGTH_SHORT).show();
                            }
                    }
                });
            }
        });

    }
}