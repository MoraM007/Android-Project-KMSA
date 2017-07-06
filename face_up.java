package com.example.sayed.car_seervice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class face_up extends AppCompatActivity {

    public Button but1;
    public Button but2;
    public void init()
    {
        but2=(Button)findViewById(R.id.Sign_up);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy=new Intent(face_up.this,MapsActivity.class); ////////// btn2lny mn sf7a l sf7a
                startActivity(toy); ////////////////////////////////////// 34an ybd2

            }
        });
        but1=(Button)findViewById(R.id.Login);
        but1.setOnClickListener(new View.OnClickListener() { /////////// dh event onclick w ft7ly public...
            @Override
            public void onClick(View v) {
                Intent toy=new Intent(face_up.this,login.class); ////////// btn2lny mn sf7a l sf7a
                startActivity(toy); ////////////////////////////////////// 34an ybd2
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_up);
        init();

    }
}
