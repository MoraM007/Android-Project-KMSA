package com.example.sayed.car_seervice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class company extends AppCompatActivity {
    EditText txt_ip,txt_port,txt_msg,cmp_name,cmp_user,cmp_pass,cmp_addr,cmp_phone;
    Button btn;
    TextView sayed;
    String string;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);
       // txt_ip = (EditText) findViewById(R.id.txt_ip);
      //  txt_port = (EditText) findViewById(R.id.txt_port);
      //  txt_msg = (EditText) findViewById(R.id.txt_msg);
        cmp_user = (EditText) findViewById(R.id.password);
        cmp_pass= (EditText) findViewById(R.id.comp_pass);
        cmp_phone= (EditText) findViewById(R.id.comp_phone);
        cmp_addr = (EditText) findViewById(R.id.comp_addr);
        cmp_name = (EditText) findViewById(R.id.comp_name);
        sayed=(TextView)findViewById(R.id.textView222);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Socket s = new Socket("10.0.2.2",Integer.parseInt("5001"));
                            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

                            dos.writeUTF("Sign up"+","+cmp_user.getText().toString()+","+cmp_pass.getText().toString()
                                    +","+cmp_phone.getText().toString()+","+cmp_addr.getText().toString()+","+cmp_name.getText().toString());

                            DataInputStream dis=new DataInputStream(s.getInputStream());
                            string=dis.readUTF();
                            company.this.runOnUiThread(new Runnable()
                            {
                                public void run()
                                {
                                    //Do your UI operations like dialog opening or Toast here
                                    //Toast.makeText(company.this,string, Toast.LENGTH_SHORT).show();
                                    sayed.setText(string);
                                }
                            });


                            dos.flush();
                            dos.close();

                            s.close();
                        } catch (UnknownHostException e){
                            e.printStackTrace();
                        }
                        catch (NumberFormatException e){
                            e.printStackTrace();
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                        Intent toy = new Intent(company.this, login.class);
                        startActivity(toy);

                    }
                });
                t.start();
            }
        });

    }
}
