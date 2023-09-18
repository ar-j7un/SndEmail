package com.example.sndemail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.e1);//To
        e2=findViewById(R.id.e2);//Cc
        e3=findViewById(R.id.e3);//Subject
        e4=findViewById(R.id.e4);//Body
    }
    public void onCompose(View v)
    {
        sendEmail();

    }
    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {e1.getText().toString()};
        String[] CC = {e2.getText().toString()};

        String Sub=e3.getText().toString();
        String Body=e4.getText().toString();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);


        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,Sub );
        emailIntent.putExtra(Intent.EXTRA_TEXT, Body);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i(String.valueOf("Finished sending email..."),"Finished sending email...");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }
}