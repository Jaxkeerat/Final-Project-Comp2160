package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;


public class CurrentProducts extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    Data_storage data_storage;


    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();
    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LIST VIEW
    ArrayAdapter<String> adapter;
    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter = 0;
    ListView currentProd;
    Button mainPage, addItem;
    //use as base add save states for when view is changed
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_products);
        currentProd = (ListView) findViewById(R.id.simpleListView);
        mainPage = findViewById(R.id.main_page_button);
        //database connection
        databaseReference =  FirebaseDatabase.getInstance("https://finalproject-cd6bb-default-rtdb.firebaseio.com/").getReference();

        //load temp files
        String name = "good food";
        String expDate = "3/29/2021";

        listItems.add(name);
        listItems.add(expDate);
        listItems.add(name);
        listItems.add(expDate);
        listItems.add(name);
        listItems.add(expDate);
        listItems.add(name);
        listItems.add(expDate);
        listItems.add(name);
        listItems.add(expDate);

        //populate list from db
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
        currentProd.setAdapter(adapter);

        mainPage();
    }

    public void mainPage(){
        Button openAdd = (mainPage);
        openAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    public String Combine(String st1, String st2){
        String combinedStr = st1 + ", " + st2;

        return combinedStr;
    }

}