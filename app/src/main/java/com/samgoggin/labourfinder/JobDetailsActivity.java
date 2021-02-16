package com.samgoggin.labourfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JobDetailsActivity extends AppCompatActivity {



    //beingknow youtube channel
    //Starting Here
    //https://www.youtube.com/watch?v=DiUTymcFl5U&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=35

    private TextView mTitle;
    private TextView mDate;
    private TextView mDescription;
    private TextView mLocation;
    private TextView mSkills;
    private TextView mSalary;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_details);

        mTitle=findViewById(R.id.job_details_title);
        mDate=findViewById(R.id.job_details_date);
        mDescription=findViewById(R.id.job_details_description);
        mLocation=findViewById(R.id.job_details_location);
        mSkills=findViewById(R.id.job_details_skills);
        mSalary=findViewById(R.id.job_details_salary);




        //Receive data from all job activity using intent

        Intent intent=getIntent();

        String title=intent.getStringExtra("title");
        String date=intent.getStringExtra("date");
        String description=intent.getStringExtra("description");
        String location=intent.getStringExtra("location");
        String skills=intent.getStringExtra("skills");
        String salary=intent.getStringExtra("salary");

        mTitle.setText(title);
        mDate.setText(date);
        mDescription.setText(description);
        mLocation.setText(location);
        mSkills.setText(skills);
        mSalary.setText(salary);


          // ending here
    }
}