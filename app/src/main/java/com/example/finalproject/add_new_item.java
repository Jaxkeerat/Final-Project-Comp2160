package com.example.finalproject;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


public class add_new_item<requestCode> extends AppCompatActivity {

    private EditText product, price_input, expiry, purchase;
    private Button image_btn1, button2;
    int count =0;
    private Button plus, minus;
    private EditText item_quantity;
    private ImageView imageView;

    FirebaseDatabase firebaseDatabase;

    private DatabaseReference mdb;

    Data_storage data_storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_new_item);

        product=(EditText)findViewById(R.id.product);
        price_input=(EditText)findViewById(R.id.price_input);
        expiry=(EditText)findViewById(R.id.editTextDate2);
        purchase=(EditText)findViewById(R.id.editTextDate);

        firebaseDatabase =FirebaseDatabase.getInstance();

        //database connection
        mdb =  FirebaseDatabase.getInstance("https://finalproject-cd6bb-default-rtdb.firebaseio.com/").getReference();

        data_storage = new Data_storage();


        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        item_quantity = findViewById(R.id.item_quantity);
        button2 = findViewById(R.id.button2);
        image_btn1=findViewById(R.id.image_btn1);
        imageView = findViewById(R.id.imageView);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                item_quantity.setText(String.valueOf(count));
             }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                item_quantity.setText(String.valueOf(count));
            }
        });
        //image capture
        if(ContextCompat.checkSelfPermission(add_new_item.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(add_new_item.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    },
                    100);
        }


        image_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,100);
            }

        });
    }
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onActivityResult( int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(captureImage);
        }



        //add to firebase
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String product_name = product.getText().toString();
                String Date_1 = expiry.getText().toString();
                String Date_2 = purchase.getText().toString();
                String price =price_input.getText().toString();
                String quantity= item_quantity.getText().toString();

                if (TextUtils.isEmpty(product_name) && TextUtils.isEmpty(Date_1) && TextUtils.isEmpty(Date_2) && TextUtils.isEmpty(quantity)&& TextUtils.isEmpty(price)) {
                    
                    Toast.makeText(add_new_item.this, "Please add some data.", Toast.LENGTH_SHORT).show();
                } else {

                    addDatatoFirebase(product_name, Date_1, Date_2, price, quantity );
                }

                

            }
        });
    }

    private void addDatatoFirebase(String product_name, String Date_1, String Date_2, String price, String quantity) {

        data_storage.setProduct(product_name);
        data_storage.setEditTextDate2(Date_1);
        data_storage.setEditTextDate(Date_2);
        data_storage.setPrice_input(price);
        data_storage.setItem_quantity(quantity);

        Query databaseReference;
        mdb.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mdb.push().setValue(data_storage);
                Toast.makeText(add_new_item.this,"Product has been added", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(add_new_item.this, "Fail to add Product ",Toast.LENGTH_SHORT).show();
            }
        });



    }


}
