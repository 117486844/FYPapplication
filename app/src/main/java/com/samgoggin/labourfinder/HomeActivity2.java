package com.samgoggin.labourfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class HomeActivity2 extends AppCompatActivity {


    //beingknow youtube channel
    //Starting Here
  //https://www.youtube.com/watch?v=G28Vfz4y79E&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=13
    private Button btnAlljob;
    private Button btnPostJob;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);



        btnAlljob=findViewById(R.id.btnSeeAllJobs);
        btnPostJob=findViewById(R.id.btnPostJob);


        btnAlljob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),AllJobActivity.class));


            }
        });

        btnPostJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(new Intent(getApplicationContext(),PostJobActivity.class));


            }
        });


    }



}
//ending here