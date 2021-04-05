package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button addButton, currentButton, expiredButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        addButton = findViewById(R.id.addBTN);
        currentButton = findViewById(R.id.currButton);
        expiredButton =  findViewById(R.id.expButton);

        openCurrent();
        openAddActivity();
        openExpActivity();

    }

    public void openAddActivity(){
        Button openAdd = (addButton);
        openAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, add_new_item.class));
            }
        });
    }
    public void openCurrent() {
        Button openCurrent = (currentButton);
        openCurrent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CurrentProducts.class));
            }
        });
    }
    public void openExpActivity(){
        Button openExp = (expiredButton);
        openExp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, expired_products.class));
            }
        });

    }
}