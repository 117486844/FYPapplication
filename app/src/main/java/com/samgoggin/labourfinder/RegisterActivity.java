package com.samgoggin.labourfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {


    private EditText emailReg;
    private EditText passwordReg;
    private EditText companyName;
    private EditText managerName;
    private EditText companyNumber;
    private EditText tvAddressReg;

    private Button btnRegistration;

    private FirebaseDatabase database;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    private Company company;


    private  static final String COMPANY = "company";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);




        emailReg = findViewById(R.id.emailRegistor);
        companyName = findViewById(R.id.CompanyName);
        passwordReg = findViewById(R.id.passwordRegistor);
        managerName = findViewById(R.id.managerName);
        companyNumber = findViewById(R.id.companyNumber);
        tvAddressReg = findViewById(R.id.tvAddressReg);
        btnRegistration = findViewById(R.id.btnRegisterCompany);


        //root tech youtube channel
        //Starting Here
        //https://www.youtube.com/watch?v=0gNPX52o_7I&t=119s


        database = FirebaseDatabase.getInstance();
        mDatabase = database.getReference(COMPANY);
        mAuth = FirebaseAuth.getInstance();


        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = emailReg.getText().toString();
                String password = passwordReg.getText().toString();
                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
                    Toast.makeText(getApplicationContext(),"Enter Email and Password",
                            Toast.LENGTH_LONG ).show();
                    return;
                }

                String CompanyName = companyName.getText().toString();
                String address = tvAddressReg.getText().toString();
                String ManagerName = managerName.getText().toString();
                String number = companyNumber.getText().toString();
                company = new Company(email, password, CompanyName, address, ManagerName, number);


                registerUser(email,password);


            }
        });

    }


    public void registerUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {


                    private final String TAG =MainActivity.class.getSimpleName();

                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser company = mAuth.getCurrentUser();
                            updateUI(company);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }


                    }
                });

    }

    public void updateUI(FirebaseUser currentUser){
        String keyId = mDatabase.push().getKey();
        mDatabase.child(keyId).setValue(company);
        Intent loginIntent = new Intent(this, MainActivity.class);
        startActivity(loginIntent);

    }
}

//ending here


/*

    //Firebase auth
    //https://www.youtube.com/watch?v=kfxGwainU5g&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=9
   private FirebaseAuth mAuth;



   //Progress dialog..

    private ProgressDialog mDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();

        mDialog=new ProgressDialog(this);


        Registration();
    }

    private void Registration(){


        emailReg=findViewById(R.id.emailRegistor);
        passwordReg=findViewById(R.id.passwordRegistor);





        btnRegistration=findViewById(R.id.btnRegisterCompany);
        btnLoginReg=findViewById(R.id.btnLoginReg);

        btnRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //I got this code from this video
                //https://www.youtube.com/watch?v=fcxB6p76vGY&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=8

                String email=emailReg.getText().toString().trim();
                String pass=passwordReg.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    emailReg.setError("Required Field..");
                   return;
                }

                if (TextUtils.isEmpty(pass)){
                    passwordReg.setError("Required Field..");
                    return;
                }


                mDialog.setMessage("Processing...");
                mDialog.show();





                mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()){

                            Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(getApplicationContext(),HomeActivity2.class));

                            mDialog.dismiss();


                        }else {
                            Toast.makeText(getApplicationContext(),"Registration Failed..",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

        btnLoginReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });
    }

}*/