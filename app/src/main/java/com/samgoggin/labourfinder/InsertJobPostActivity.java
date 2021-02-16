package com.samgoggin.labourfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

import Model.Data;

public class InsertJobPostActivity extends AppCompatActivity {



    //beingknow youtube channel
    //Starting Here 1
    //https://www.youtube.com/watch?v=uBHo2f7_edA&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=19


    private EditText job_title;
    private EditText job_description;
    private EditText job_skills;
    private EditText job_location;
    private EditText job_salary;


    private Button btnAddJobPost;


    //Firebase..

    private FirebaseAuth mAuth;
    private DatabaseReference mJobPost;


    private DatabaseReference mPublicDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_job_post);


        //beingknow youtube channel
        //Starting Here 3
        //https://www.youtube.com/watch?v=3T3-iAG-0MM&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=22

        mAuth=FirebaseAuth.getInstance();

        FirebaseUser mUser=mAuth.getCurrentUser();
        String uId=mUser.getUid();

        mJobPost= FirebaseDatabase.getInstance().getReference().child("Job Post").child(uId);



        //beingknow youtube channel
        //Starting Here 4
       // https://www.youtube.com/watch?v=xP1Ui8_nYWs&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=32

        mPublicDatabase=FirebaseDatabase.getInstance().getReference().child("Public database");

        InsertJob();
        //ending 4
    }


    private void InsertJob(){

        job_title=findViewById(R.id.txtJobTitle);
        job_description=findViewById(R.id.txtJobDescription);
        job_skills=findViewById(R.id.txtSkill);
        job_location=findViewById(R.id.txtLocation);
        job_salary=findViewById(R.id.editTextNumberDecimal);




        //ending here 1


        btnAddJobPost=findViewById(R.id.btnAddJobPost);

        btnAddJobPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                //beingknow youtube channel
                //Starting Here 2
                //https://www.youtube.com/watch?v=7sxZOmzqv1A&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=20

                String title=job_title.getText().toString().trim();
                String description=job_description.getText().toString().trim();
                String skills=job_skills.getText().toString().trim();
                String location=job_location.getText().toString().trim();
                String salary=job_salary.getText().toString().trim();




                if (TextUtils.isEmpty(title)){
                    job_title.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(description)){
                    job_description.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(skills)){
                    job_skills.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(location)){
                    job_location.setError("Required Field..");
                    return;
                }
                if (TextUtils.isEmpty(salary)){
                    job_salary.setError("Required Field..");
                    return;
                }

              //ending here 2



             String id=mJobPost.push().getKey();

              String date= DateFormat.getDateInstance().format(new Date());

              Data data=new Data(title,description,skills,location,salary,id,date);

              mJobPost.child(id).setValue(data);

              //ending 3


              mPublicDatabase.child(id).setValue(data);

                Toast.makeText(getApplicationContext(),"Successful",Toast.LENGTH_SHORT).show();

                startActivity(new Intent(getApplicationContext(),PostJobActivity.class));


            }
        });

    }


}