package com.samgoggin.labourfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    //beingknow youtube channel
    //Starting Here
    //https://www.youtube.com/watch?v=iACIOEJlrlI&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=6

    private EditText email;
    private EditText password;

    private Button btnLogin;
    private Button btnRegister;



    //Firebase
    //beingknow youtube channel
    //Starting Here 2
    //https://www.youtube.com/watch?v=oGNKH7xA0e4&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=11

    private FirebaseAuth mAuth;

    //progress dialog
  private ProgressDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth=FirebaseAuth.getInstance();

        mDialog=new ProgressDialog(this);


        LoginFunction();
    }

    private void LoginFunction(){

        email=findViewById(R.id.emailLogin);
        password=findViewById(R.id.PasswordLogin);

        btnLogin=findViewById(R.id.btnLogin);
        btnRegister=findViewById(R.id.btnRegistorLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //beingknow youtube channel
                //Starting Here
                //https://www.youtube.com/watch?v=l03J2xLmQSo&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=10

                String mEmail=email.getText().toString().trim();
                String pass=password.getText().toString().trim();

                if (TextUtils.isEmpty(mEmail)){
                    email.setError("Required Field...");
                    return;
                }

                if (TextUtils.isEmpty(pass)){
                    password.setError("Required Field...");
                    return;

                }



                mDialog.setMessage("Processing..");
                mDialog.show();





                mAuth.signInWithEmailAndPassword(mEmail,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),HomeActivity2.class));

                            mDialog.dismiss();

                        }else {

                            Toast.makeText(getApplicationContext(),"Login Failed..",Toast.LENGTH_SHORT).show();
                        }
                    }
                });



              // ending here 2

            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),RegisterActivity.class));

            }
        });

    }


}



