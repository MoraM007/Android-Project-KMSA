package com.example.sayed.car_seervice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sign_up extends AppCompatActivity {
    public Button person;
    public Button company0;

    public void init() {
       /* person = (Button) findViewById(R.id.Personal);
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(Sign_up.this, personal.class);
                startActivity(toy);
            }
        });*/
        company0 = (Button) findViewById(R.id.Companyy);
        company0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy = new Intent(Sign_up.this, company.class);
                startActivity(toy);
            }
        });
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();


    }
}
