package com.example.mirchi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Objects.requireNonNull(getSupportActionBar()).hide();

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openmixupoffline();
            }
        });
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opennehakakkar();
            }
        });
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opensidhumoose();
            }
        });
        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendivine();
            }
        });
        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openarijit();
            }
        });
        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendiljit();
            }
        });
        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openbadshah();
            }
        });
        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openoldsongs();
            }
        });
        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openlatestsongs();
            }
        });

        TextView wish = findViewById(R.id.wish);
        Calendar now = Calendar.getInstance();
        int hour = now.get(Calendar.HOUR_OF_DAY);
        if (hour>=4 && hour < 12)
            { wish.setText("Good Morning");}
        else if (hour>=12 && hour < 18)
            { wish.setText("Good Afternoon");}
        else if (hour>=18 && hour<22)
            { wish.setText("Good Evening");}
        else
            { wish.setText("Good Night");}

    }
    public void openmixupoffline(){
        Intent intent = new Intent(this, mix_up_offline.class);
        startActivity(intent);
    }
    public void opennehakakkar(){
        Intent intent = new Intent(this, neha_kakkar.class);
        startActivity(intent);
    }
    public void opensidhumoose(){
        Intent intent = new Intent(this, sidhu_moose.class);
        startActivity(intent);
    }
    public void opendivine(){
        Intent intent = new Intent(this, divine.class);
        startActivity(intent);
    }
    public void openarijit(){
        Intent intent = new Intent(this, arijit.class);
        startActivity(intent);
    }
    public void opendiljit(){
        Intent intent = new Intent(this, diljit.class);
        startActivity(intent);
    }
    public void openbadshah(){
        Intent intent = new Intent(this, badshah.class);
        startActivity(intent);
    }
    public void openoldsongs(){
        Intent intent = new Intent(this, oldsongs.class);
        startActivity(intent);
    }
    public void openlatestsongs(){
        Intent intent = new Intent(this, latestsongs.class);
        startActivity(intent);
    }

}