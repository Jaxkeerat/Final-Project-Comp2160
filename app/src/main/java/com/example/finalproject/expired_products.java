package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class expired_products extends AppCompatActivity {

    ArrayList<String> items = new ArrayList<>();
    ArrayAdapter<String>  outputEx ;
    ListView expiredProd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expired_products);

        expiredProd = (ListView) findViewById(R.id.ExListView);
        String prodName = "Food";
        String expiryDate = "12/12/2021";

        items.add("Twinkies, 1/20/2070");
        items.add("Baked Beans, 4/20/2021");
        items.add("Wonder Bread, 1/27/2022");
        items.add("Kellogg's chews, 5/12/2021");
        items.add("Poppy Seed Muffins, 3/29/2021");
        items.add("twinkies, 1/20/2070");

        Collections.sort(items);
        outputEx = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        expiredProd.setAdapter(outputEx);
    }
}