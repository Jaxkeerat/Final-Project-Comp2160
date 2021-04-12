package com.example.finalproject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
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
import java.util.List;
import java.util.Map;


public class CurrentProducts extends AppCompatActivity {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    Data_storage data_storage;
    ArrayAdapter<String> adapter;

    private ArrayList<String> productsList = new ArrayList<String>();

    private Map<Integer, String> productInfo = new HashMap<Integer, String>();

    ListView currentProd;
    Button mainPage;

    TextView popUpData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        popUpData = (TextView)findViewById(R.id.popupmsg);
        databaseInitialize();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_products);
        currentProd = (ListView) findViewById(R.id.simpleListView);
        mainPage = findViewById(R.id.main_page_button);

        Map<String, String> cpal = new HashMap<String, String>();

        //productsList.add("twinkies, 1/20/2070");

        mainPage();
        //populate list from db
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, productsList);
        currentProd.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        currentProd.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //set data for popo up msg
                //Toast.makeText(CurrentProducts.this, "currently selected: "+i, Toast.LENGTH_SHORT).show();
                String message = (String)productInfo.get(i);


                LayoutInflater inflater = (LayoutInflater)
                        getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = inflater.inflate(R.layout.popup_window, null);
                TextView messageBox = (TextView)popupView.findViewById(R.id.popupmsg);
                messageBox.setText(message);

                // create the popup window
                int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                boolean focusable = true; // lets taps outside the popup also dismiss it
                final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                // show the popup window
                popupWindow.setAnimationStyle(R.anim.myfirst_animation);
                popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);
                //popUpData.setText(message);
                // dismiss the popup window when touched
                popupView.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {
                        popupWindow.dismiss();
                        return true;
                    }
                });
            }

        });
    }


    public void databaseInitialize(){
        //database connection
        databaseReference =  FirebaseDatabase.getInstance("https://finalproject-cd6bb-default-rtdb.firebaseio.com/").getReference();
        databaseReference.addValueEventListener(new ValueEventListener() {
            //any time database changes this will be envoked + once on create
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //hold ctrl alt v to get correct type its like magic
                //get all of the children at this level
                Iterable<DataSnapshot> children = snapshot.getChildren();
                int count = 0;
                for (DataSnapshot child: children) {
                    FireBaseData stuff = child.getValue(FireBaseData.class);
                    String productDisplayData = stuff.toString();

                    //custom setget
                    String prodGeneralInfo = stuff.setGetGeneralInfo();

                    //don't question this took me hours to figure out this bug and i found a work around
                    addItemToList(productDisplayData, adapter, count, prodGeneralInfo);
                    count++;

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    public void addItemToList(String string, ArrayAdapter<String> adapter, int key, String genInfo){
        this.productsList.add(string);
        adapter.notifyDataSetChanged();
        this.productInfo.put(key,genInfo);
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