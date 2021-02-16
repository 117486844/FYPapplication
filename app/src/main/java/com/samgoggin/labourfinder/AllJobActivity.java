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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import Model.Data;

public class AllJobActivity extends AppCompatActivity {


     //beingknow youtube channel
    //Starting Here
    //https://www.youtube.com/watch?v=yokvcTYrLGI&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=30

    //recycler
    private RecyclerView recyclerView;

    //firebase
    private DatabaseReference mAllJobPost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_job);

        //Database
        mAllJobPost= FirebaseDatabase.getInstance().getReference().child("Public database");
        mAllJobPost.keepSynced(true);


        recyclerView=findViewById(R.id.recycler_all_job);

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);


    }

    //Ending here



    //beingknow youtube channel
    //Starting Here
    //https://www.youtube.com/watch?v=xP1Ui8_nYWs&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=32

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerAdapter<Data,AllJobPostViewHolder>adapter=new FirebaseRecyclerAdapter<Data, AllJobPostViewHolder>
                (
                        Data.class,
                        R.layout.alljobpost,
                        AllJobPostViewHolder.class,
                        mAllJobPost

               ) {
            @Override
            protected void populateViewHolder(AllJobPostViewHolder allJobPostViewHolder, final Data data, int i) {


                allJobPostViewHolder.setJobTitle(data.getTitle());
                allJobPostViewHolder.setJobDate(data.getDate());
                allJobPostViewHolder.setJobDescription(data.getDescription());
                allJobPostViewHolder.setJobLocation(data.getLocation());
                allJobPostViewHolder.setJobSkills(data.getSkills());
                allJobPostViewHolder.setJobSalary(data.getSalary());

                //Ending here



                //beingknow youtube channel
                //Starting Here
                //https://www.youtube.com/watch?v=H6xbS6Pffe0&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=34

                allJobPostViewHolder.myview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent intent=new Intent(getApplicationContext(),JobDetailsActivity.class);



                        intent.putExtra("title",data.getTitle());
                        intent.putExtra("date",data.getDate());
                        intent.putExtra("description",data.getDescription());
                        intent.putExtra("location",data.getLocation());
                        intent.putExtra("skills",data.getSkills());
                        intent.putExtra("salary",data.getSalary());

                        startActivity(intent);


                    }
                });



            }
        };


        recyclerView.setAdapter(adapter);


    }



    public static class AllJobPostViewHolder extends RecyclerView.ViewHolder{

        //beingknow youtube channel
        //Starting Here
        //https://www.youtube.com/watch?v=docJeFaNRkM&list=PLRxuR_G2-IzWnjHAL4nG9BUXHWja5ZPwC&index=31



        View myview;

        public AllJobPostViewHolder(@NonNull View itemView) {
            super(itemView);
            myview=itemView;
        }

        public void setJobTitle(String title){
            TextView mTitle=myview.findViewById(R.id.all_job_post_title);
            mTitle.setText(title);
        }

        public void setJobDate(String date){
            TextView mDate=myview.findViewById(R.id.all_job_post_date);
            mDate.setText(date);
        }

        public void setJobDescription(String description){
            TextView mDescription=myview.findViewById(R.id.all_job_post_description);
            mDescription.setText(description);
        }


        public void setJobLocation(String location){
            TextView mLocation=myview.findViewById(R.id.all_job_post_location);
            mLocation.setText(location);
        }


        public void setJobSkills(String skills){
            TextView mSkills=myview.findViewById(R.id.all_job_post_skills);
            mSkills.setText(skills);
        }



        public void setJobSalary(String salary){
            TextView mSalary=myview.findViewById(R.id.all_job_post_salary);
            mSalary.setText(salary);
        }



    }

}

//Ending here