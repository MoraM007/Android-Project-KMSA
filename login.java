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

import static android.R.attr.data;

public class login extends AppCompatActivity {
    EditText txt_username,txt_pass;
    Button btn;
    String string;

    DataInputStream dis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txt_username = (EditText) findViewById(R.id.Username);
        txt_pass= (EditText) findViewById(R.id.password);
        btn = (Button) findViewById(R.id.buttonLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread t = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            Socket s = new Socket("10.0.2.2",Integer.parseInt("5001"));
                            //Toast.makeText(this,"sayed kkjijk",Toast.LENGTH_SHORT).show();
                            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
                            dos.writeUTF("Login"+","+txt_username.getText().toString()+","+txt_pass.getText().toString());
                            dis=new DataInputStream(s.getInputStream());
                            string=dis.readUTF();

                            login.this.runOnUiThread(new Runnable()
                            {
                                public void run()
                                {
                                    if(string.equals("correct"))
                                    {
                                        Toast.makeText(login.this,string, Toast.LENGTH_SHORT).show();
                                        Intent toy = new Intent(login.this, Date_display.class);
                                        startActivity(toy);

                                    }
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
        });
    }
}
