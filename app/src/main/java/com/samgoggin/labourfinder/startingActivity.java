package com.samgoggin.labourfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class startingActivity extends AppCompatActivity {




    private Button btnWorker;
    private Button btnCompany;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);


        StartingFunction();

    }

    public void StartingFunction(){

        btnWorker=findViewById(R.id.btnWorker);
        btnCompany=findViewById(R.id.btnCompany);



        btnCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),MainActivity.class));

            }
        });

        btnWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),workerLoginActivity.class));
            }
        });

    }


}