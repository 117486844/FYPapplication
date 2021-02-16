package com.samgoggin.labourfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Model.Data;

public class PostJobActivity extends AppCompatActivity {



    //beingknow youtube channel
    //Starting Here 1
    //https://www.youtube.com/watch?v=PybpxBmj5oI&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=17

    private FloatingActionButton fabBtn;

    //beingknow youtube channel
    //Starting Here 2
    //https://www.youtube.com/watch?v=Ui1GSgtLPd0&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=25

    private RecyclerView recyclerView;

    //firebase

    private FirebaseAuth mAuth;
    private DatabaseReference JobPostDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_job);

        fabBtn=findViewById(R.id.floatingActionButton);

        mAuth=FirebaseAuth.getInstance();


        FirebaseUser mUser=mAuth.getCurrentUser();
        String uId=mUser.getUid();

        JobPostDatabase= FirebaseDatabase.getInstance().getReference().child("Job Post").child(uId);

        recyclerView=findViewById(R.id.recycler_job_post_id);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setStackFromEnd(true);
        layoutManager.setReverseLayout(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), InsertJobPostActivity.class));


            } //ending here 1
        });


    }


    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Data,MyViewHolder>adapter=new FirebaseRecyclerAdapter<Data, MyViewHolder>(

                Data.class,
                R.layout.job_post_item,
                MyViewHolder.class,
                JobPostDatabase
        ) {
            @Override
            protected void populateViewHolder(MyViewHolder myViewHolder, Data data, int i) {

                myViewHolder.setJobTitle(data.getTitle());
                myViewHolder.setJobDate(data.getDate());
                myViewHolder.setJobDescription(data.getDescription());
                myViewHolder.setJobLocation(data.getLocation());
                myViewHolder.setJobSkills(data.getSkills());
                myViewHolder.setJobSalary(data.getSalary());

            }
        };

        recyclerView.setAdapter(adapter);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        View myview;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myview=itemView;
        }

        public void setJobTitle( String title){

            TextView mTitle=myview.findViewById(R.id.txtJobTitle);
            mTitle.setText(title);


        }

        public void setJobDate(String date){
            TextView mDate=myview.findViewById(R.id.job_date);
            mDate.setText(date);
        }


        public void setJobDescription(String description){
            TextView mDescription=myview.findViewById(R.id.job_description);
            mDescription.setText(description);
        }


        public void setJobLocation(String location){
            TextView mLocation=myview.findViewById(R.id.job_location);
            mLocation.setText(location);
        }


        public void setJobSkills(String skills){
            TextView mSkills=myview.findViewById(R.id.job_skills);
            mSkills.setText(skills);
        }



        public void setJobSalary(String salary){
            TextView mSalary=myview.findViewById(R.id.job_salary);
            mSalary.setText(salary);
        }

    }

 // ending here 2
}