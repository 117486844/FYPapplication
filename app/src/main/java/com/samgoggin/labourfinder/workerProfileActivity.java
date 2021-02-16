package com.samgoggin.labourfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;

public class workerProfileActivity extends AppCompatActivity {


    private TextView tvWorkerProfileName;
    private TextView tvWorkerProfileAddress;
    private TextView tvWorkerProfileNumber;
    private TextView tvWorkerProfileExperience;
    private TextView tvWorkerProfileEmail;

    //private final String TAG = this.getClass().getName().toUpperCase();


    private String email, password;

    private FirebaseDatabase database;
    private DatabaseReference userRef;
    private static final String USER = "user";


//root tech youtube channel
    //Starting Here
// https://www.youtube.com/watch?v=GuMwCuvGWx4&t=472s


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_profile);

        Intent intent = getIntent();
        email = intent.getStringExtra("email");
       Log.d("TAG","%%%%%%" + email);




        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        DatabaseReference userRef = rootRef.child(USER);
        Log.v("USERID", "$$$$$" + userRef.getKey());



       tvWorkerProfileName = findViewById(R.id.tvWorkerProfileName);
       tvWorkerProfileAddress = findViewById(R.id.tvWorkerProfileAddress);
       tvWorkerProfileNumber = findViewById(R.id.tvWorkerProfileNumber);
       tvWorkerProfileExperience = findViewById(R.id.tvWorkerProfileExperience);
       tvWorkerProfileEmail = findViewById(R.id.tvWorkerProfileEmail);


      /*database = FirebaseDatabase.getInstance();
       userRef = database.getReference(USER);*/

       userRef.addValueEventListener(new ValueEventListener() {
           String fullName, address, number, experience,emailAdd;
           @Override
           public void onDataChange(DataSnapshot snapshot) {
               for (DataSnapshot ds : snapshot.getChildren()){
                   Log.d("TAG","&&&&&"+ ds.child("email").getValue(String.class));
               if (ds.child("email").getValue(String.class).equals(email)){

                   fullName = ds.child("fullName").getValue(String.class);
                   address = ds.child("address").getValue(String.class);
                   number = ds.child("number").getValue(String.class);
                   experience = ds.child("experience").getValue(String.class);
                   Log.d("Tag","**********GOOD**********" + experience );
                   emailAdd = ds.child("email").getValue(String.class);
                   break;
               }
                    Log.d("Tag","**********ERROR**********");
               }
                tvWorkerProfileName.setText(fullName);
                tvWorkerProfileAddress.setText(address);
                tvWorkerProfileNumber.setText(number);
                tvWorkerProfileExperience.setText(experience);
                tvWorkerProfileEmail.setText(emailAdd);


           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {
               Log.w("TAG", "Failed to read value.", error.toException());
           }
       });


       //ending here

    }
}