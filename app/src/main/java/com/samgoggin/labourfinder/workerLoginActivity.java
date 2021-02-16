package com.samgoggin.labourfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class workerLoginActivity extends AppCompatActivity {





    private TextView loginWorker;
    private EditText PasswordLoginWorker;
    private EditText emailLoginWorker;
    private Button btnLoginWorker;
    private Button btnRegistorLoginWorker;

    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_login);


        //root tech youtube channel
        //Starting Here
        //https://www.youtube.com/watch?v=vpoPZvQGXj0&t=283s

        mAuth = FirebaseAuth.getInstance();

        loginWorker=findViewById(R.id.loginWorker);
        PasswordLoginWorker=findViewById(R.id.PasswordLoginWorker);
        emailLoginWorker=findViewById(R.id.emailLoginWorker);
        btnLoginWorker=findViewById(R.id.btnLoginWorker);
        btnRegistorLoginWorker=findViewById(R.id.btnRegistorLoginWorker);




        btnLoginWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailLoginWorker.getText().toString();
                String password = PasswordLoginWorker.getText().toString();
                if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Enter Email and Password",
                            Toast.LENGTH_LONG ).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(workerLoginActivity.this, new OnCompleteListener<AuthResult>() {


                            private final String TAG =workerLoginActivity.class.getSimpleName();

                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Log.d("TAG", user.getEmail().toString());
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(workerLoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    updateUI(null);
                                }


                            }
                        });


            }
        });



        btnRegistorLoginWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),workerRegisterActivity.class));
            }
        });

    }


    /*@Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){
            updateUI(currentUser);
        }

    }*/


    public void updateUI(FirebaseUser currentUser){
        Intent profileIntent= new Intent(this,workerProfileActivity.class);
        profileIntent.putExtra("email", currentUser.getEmail());
        startActivity(profileIntent);

    }

    //ending here
}