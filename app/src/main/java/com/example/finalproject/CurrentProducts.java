package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import java.util.ArrayList;

public class CurrentProducts extends AppCompatActivity {

    //LIST OF ARRAY STRINGS WHICH WILL SERVE AS LIST ITEMS
    ArrayList<String> listItems=new ArrayList<String>();
    //DEFINING A STRING ADAPTER WHICH WILL HANDLE THE DATA OF THE LIST VIEW
    ArrayAdapter<String> adapter;
    //RECORDING HOW MANY TIMES THE BUTTON HAS BEEN CLICKED
    int clickCounter = 0;


    //use as base add save states for when view is changed
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_products);
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listItems);
    }

    public void addItems(View v) {
        listItems.add("Clicked : "+clickCounter++);
        adapter.notifyDataSetChanged();
    }

    public void onPause(){
        // to be added
        // refrences https://stackoverflow.com/questions/4540754/how-do-you-dynamically-add-elements-to-a-listview-on-android
    }
}