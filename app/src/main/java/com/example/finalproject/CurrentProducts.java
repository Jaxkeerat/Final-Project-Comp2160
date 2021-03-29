package com.example.finalproject;

import androidx.annotation.Nullable;
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
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;
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

        listItems.add("Twinkies, 1/20/2070");
        listItems.add("Baked Beans, 4/20/2021");
        listItems.add("Wonder Bread, 1/27/2022");
        listItems.add("Kellogs chews, 5/12/2021");
        listItems.add("PoppieSeed Muffinz, 3/29/2021");
        listItems.add("twinkies, 1/20/2070");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        listItems.add("Test Item Filler, 1/20/2020");
        Collections.sort(listItems);

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

    /*
    private void initializeListView() {
        // creating a new array adapter for our list view.
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, listItems);

        // below line is used for getting reference
        // of our Firebase Database.
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();

        // in below line we are calling method for add child event
        // listener to get the child of our database.
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // this method is called when new child is added to
                // our data base and after adding new child
                // we are adding that item inside our array list and
                // notifying our adapter that the data in adapter is changed.
                listItems.add(snapshot.getValue(String.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // this method is called when the new child is added.
                // when the new child is added to our list we will be
                // notifying our adapter that data has changed.
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                // below method is called when we remove a child from our database.
                // inside this method we are removing the child from our array list
                // by comparing with it's value.
                // after removing the data we are notifying our adapter that the
                // data has been changed.
                listItems.remove(snapshot.getValue(String.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                // this method is called when we move our
                // child in our database.
                // in our code we are note moving any child.
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // this method is called when we get any
                // error from Firebase with error.
            }
        });
        // below line is used for setting
        // an adapter to our list view.
        currentProd.setAdapter(adapter);
    }
     */

}