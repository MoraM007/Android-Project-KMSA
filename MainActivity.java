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
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    TextView txt2;
    DataInputStream dis;
    String string0;
    String string2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = (TextView) findViewById(R.id.textView222);
        txt2=(TextView) findViewById(R.id.textView4);
         Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Socket s = new Socket("10.0.2.2",Integer.parseInt("5001"));
                            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            dos.writeUTF("Login,correct");
                            dis=new DataInputStream(s.getInputStream());
                            string0=dis.readUTF();
                            final String [] items = string0.split(",");
                            string2=dis.readUTF();
                            final String [] items0 = string2.split(",");
                            MainActivity.this.runOnUiThread(new Runnable()
                            {
                                public void run()
                                {
                                     //Toast.makeText(MainActivity.this,string0, Toast.LENGTH_SHORT).show();
                                        txt.setText(items[0]);
                                        txt2.setText(items0[0]);
                                        //Intent toy = new Intent(login.this, MainActivity.class);
                                        //startActivity(toy);
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





                    }
                });
                t.start();

    }
}
    //apply plugin: 'com.google.gms.google-services'