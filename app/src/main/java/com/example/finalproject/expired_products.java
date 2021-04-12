package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;

import java.util.ArrayList;
import java.util.Collections;

public class expired_products extends AppCompatActivity {


    FirebaseDatabase firebaseDB ;
    private DatabaseReference dbReference;


    ArrayList<String> items = new ArrayList<>();
    ArrayAdapter<String> outputEx;
    ListView expiredProd;
    private Button info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expired_products);

        expiredProd = (ListView) findViewById(R.id.ExListView);
        dbReference = FirebaseDatabase.getInstance("https://finalproject-cd6bb-default-rtdb.firebaseio.com/").getReference();

        expiredProd = (ListView) findViewById(R.id.ExListView);
        String prodName = "Food";
        String expiryDate = "12/12/2021";

        items.add("Twinkies, 2/20/2021");
        items.add("Baked Beans, 4/07/2021");
        items.add("Wonder Bread, 4/10/2021");
        items.add("Kellogg's chews, 2/12/2021");
        items.add("Poppy Seed Muffins, 3/29/2021");

        Collections.sort(items);
        outputEx = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        expiredProd.setAdapter(outputEx);


        info = (Button) findViewById(R.id.info);

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openProductInfo();
            }

        });
    }
    public void openProductInfo() {

        Intent intent = new Intent(this, productinfo.class);
        startActivity(intent);

    }
}
