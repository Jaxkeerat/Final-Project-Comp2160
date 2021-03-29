package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button addButton, currentButton, expiredButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = findViewById(R.id.addBTN);
        currentButton = findViewById(R.id.currButton);
        expiredButton =  findViewById(R.id.expButton);

    }

    public void openAddActivity(View view){
        Intent intent = new Intent(this, add_new_item.class);
        startActivity(intent);
    }
     public void openCurrent(View view) {
        Intent intent  = new Intent(this, CurrentProducts.class);
        startActivity(intent);
      }
      public void openExpActivity( View view){
        Intent intent = new Intent(this, expired_products.class);
        startActivity(intent);

      }


}
