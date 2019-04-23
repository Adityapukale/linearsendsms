package com.example.its_akki.external1;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import static com.example.its_akki.external1.R.drawable.imgone;

public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSION_REQUEST_SEND_SMS = 0;
    EditText e1, e2;
    Button b1;
    String number, msg;
    int c=0;
    LinearLayout l1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.etnumber);
        e2 = (EditText) findViewById(R.id.etmessage);
        b1 = (Button) findViewById(R.id.sendsms);
        l1=(LinearLayout)findViewById(R.id.Linear);
       }
    public void sendmsg (View view){
        number = e1.getText().toString();
        msg = e2.getText().toString();
        SmsManager sm = SmsManager.getDefault();
        sm.sendTextMessage(number, null, msg, null, null);
        Toast.makeText(this, "msg sent", Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.op1:
                if(c==0) {
                    l1.setBackgroundResource(R.drawable.imgone);
                    c=1;
                }
                else {
                    l1.setBackgroundResource(R.drawable.imgtwo);
                    c=0;
                }
                return true;
            case R.id.op2:
                l1.setBackgroundColor(Color.parseColor("#FCFAF09E"));
                return true;

         default:   return super.onOptionsItemSelected(item);
        }
    }
}