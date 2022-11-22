package com.example.petmilyproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button scheduleButton = (Button) findViewById(R.id.scheduleButton);
        final Button petsignupButton = (Button) findViewById(R.id.petsignupButton);

        scheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PetScheduleDetail.class);
                startActivity(intent);
            }
        });

        petsignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PetSignUpPhotoActivity.class);
                startActivity(intent);
            }
        });
    }
}