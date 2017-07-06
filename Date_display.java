package com.example.sayed.car_seervice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Date_display extends AppCompatActivity {
    Spinner spinner3;
    Spinner spinner4;
    TextView say;
    TextView say2;
    TextView say3;
    TextView say4;
    DataInputStream dis;
    DataOutputStream dos;
    String string0;
    String string2;
    String string3;
    String string4;
    String string5;
    String string6;
    String string7;
    String text="";
    Button btn;
    int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_display);
        ////////////////////////////////////////////
        spinner3= (Spinner) findViewById(R.id.spMajor);
        spinner4= (Spinner) findViewById(R.id.spinner3);
        say= (TextView) findViewById(R.id.textView3);
        say2= (TextView) findViewById(R.id.sayed);
        btn=(Button) findViewById(R.id.button);
        say3= (TextView) findViewById(R.id.txt_branch);
        say4= (TextView) findViewById(R.id.txt_branch2);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Socket s = new Socket("10.0.2.2",Integer.parseInt("5001"));
                    dos = new DataOutputStream(s.getOutputStream());
                    dos.writeUTF("Login,correct");
                    dis=new DataInputStream(s.getInputStream());
                    string0=dis.readUTF();
                    final String [] items = string0.split(",");
                    string2=dis.readUTF();
                    final String [] items0 = string2.split(",");
                    string4=dis.readUTF();
                    final String [] items1 = string4.split(",");
                    string5=dis.readUTF();
                    final String [] items2 = string5.split(",");
                    string6=dis.readUTF();
                    final String [] items3 = string6.split(",");
                    string7=dis.readUTF();
                    final String [] items4 = string7.split(",");

                    Date_display.this.runOnUiThread(new Runnable()
                    {
                        public void run()
                        {

                            ArrayList<String> data= new ArrayList<>();
                            say3.setText(items[1]);
                            say4.setText(items4[1]);
                            data.add("no");
                            data.add(items[0]);
                            data.add(items0[0]);
                            data.add(items1[0]);
                           /* data.add("Lang");
                            data.add("Bussines");*/
                            ArrayAdapter<String> adapter=new ArrayAdapter<String>(getApplicationContext(),
                                    R.layout.spinner_layout , data);
                            spinner3.setAdapter(adapter);




                            ArrayList<String> data2= new ArrayList<>();
                            data2.add("no");
                            data2.add(items2[0]);
                            data2.add(items3[0]);
                            data2.add(items4[0]);
                           /* data.add("Lang");
                            data.add("Bussines");*/
                            ArrayAdapter<String> adapter2=new ArrayAdapter<String>(getApplicationContext(),
                                    R.layout.spinner_layout , data2);
                            spinner4.setAdapter(adapter2);

                            string3="";
                            text = spinner3.getSelectedItem().toString();

                           // if(text.equals(""))
                            //{
                            btn.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    text = spinner3.getSelectedItem().toString();

                                    if(text.equals(items0[0])) {

                                        Toast.makeText(Date_display.this, items0[0], Toast.LENGTH_SHORT).show();
                                        Intent toy = new Intent(Date_display.this, MapsActivity.class);
                                        startActivity(toy);
                                        try {

                                            dos.writeUTF("Map");


                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }


                                    say.setText(text);
                                }
                            });

                            //}

                            //say2.setText(text);
                            //Toast.makeText(Date_display.this,text, Toast.LENGTH_SHORT).show();
                            //Intent toy = new Intent(login.this, MainActivity.class);

                        }

                    });
                  // dos.writeUTF("sa");

                        while (true) {

                            try {

                                    dos.writeUTF(text);

                                   if(count==0)
                                   {
                                       //count=1;
                                       break;
                                   }


                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }

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





            }
        });
        t.start();

        /////////////////////////////////



    }
}
//android:background="@drawable/sa"