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
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class workerRegisterActivity extends AppCompatActivity {




    private EditText etFullName;
    private EditText etWorkerAddress;
    private EditText etExperience;
    private EditText etWorkerEmail;
    private EditText etWorkerPassword;
    private EditText etWorkerNumber;

    private Button btnWorkerRegistration;

    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private User user;


    private  static final String USER = "user";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_register);

        etFullName = findViewById(R.id.etFullName);
        etWorkerAddress= findViewById(R.id.etWorkerAddress);
        etExperience = findViewById(R.id.etExperience);
        etWorkerEmail = findViewById(R.id.etWorkerEmail);
        etWorkerPassword = findViewById(R.id.etWorkerPassword);
        etWorkerNumber = findViewById(R.id.etWorkerNumber);
        btnWorkerRegistration = findViewById(R.id.btnWorkerRegistration);



        //root tech youtube channel
        //Starting Here
        //https://www.youtube.com/watch?v=0gNPX52o_7I&t=119s


        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(USER);
        mAuth = FirebaseAuth.getInstance();


        btnWorkerRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etWorkerEmail.getText().toString();
                String password = etWorkerPassword.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Enter Email and Password",
                            Toast.LENGTH_LONG ).show();
                    return;
                }

                String fullName = etFullName.getText().toString();
                String address = etWorkerAddress.getText().toString();
                String experience = etExperience.getText().toString();
                String number = etWorkerNumber.getText().toString();
                user = new User(email, password, fullName, address, experience, number);


                registerUser(email,password);


            }
        });

    }


    public void registerUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(workerRegisterActivity.this, new OnCompleteListener<AuthResult>() {


                    private final String TAG =workerLoginActivity.class.getSimpleName();

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(workerRegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });

    }

 public void updateUI(FirebaseUser currentUser){
        String keyId = mDatabase.push().getKey();
        mDatabase.child(keyId).setValue(user);
     Intent loginIntent = new Intent(this, workerLoginActivity.class);
     startActivity(loginIntent);

 }


 //ending here
}